package com.jeancsil.cli.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.icu.tokenattributes.ScriptAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

public class ParseAnalyzer {

  public ParseAnalyzer() {}

  public HashMap<String, LinkedList<String>> parse(Analyzer analyzer, String searchTerm) {
    var meta = new HashMap<String, LinkedList<String>>();
    meta.putIfAbsent("tokens", new LinkedList<>());
    meta.putIfAbsent("scripts", new LinkedList<>());
    meta.putIfAbsent("types", new LinkedList<>());
    meta.putIfAbsent("bytes", new LinkedList<>());

    try (TokenStream tokenStream = analyzer.tokenStream(null, searchTerm)) {
      tokenStream.reset();
      while (tokenStream.incrementToken()) {
        var charTerm = tokenStream.getAttribute(CharTermAttribute.class);

        meta.get("tokens").add(charTerm.toString());
        meta.get("scripts").add(tokenStream.getAttribute(ScriptAttribute.class).getName());
        meta.get("types").add(tokenStream.getAttribute(TypeAttribute.class).type());
        meta.get("bytes").add(tokenStream.getAttribute(TermToBytesRefAttribute.class).getBytesRef().toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return meta;
  }
}

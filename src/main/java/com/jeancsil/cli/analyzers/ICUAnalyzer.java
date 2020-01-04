package com.jeancsil.cli.analyzers;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.icu.ICUFoldingFilter;
import org.apache.lucene.analysis.icu.segmentation.ICUTokenizer;
import org.apache.lucene.analysis.miscellaneous.RemoveDuplicatesTokenFilter;

public class ICUAnalyzer extends Analyzer {

  @Override
  protected TokenStreamComponents createComponents(String fieldName) {
    final Tokenizer tokenizer = new ICUTokenizer();
    TokenStream in = new ICUFoldingFilter(tokenizer);
    in = new RemoveDuplicatesTokenFilter(in);

    return new TokenStreamComponents(tokenizer, in);
  }
}

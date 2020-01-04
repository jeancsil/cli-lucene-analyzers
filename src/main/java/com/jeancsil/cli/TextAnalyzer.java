package com.jeancsil.cli;

import static com.jeancsil.cli.helpers.Printer.yellow;

import com.jeancsil.cli.analyzers.ICUAnalyzer;
import com.jeancsil.cli.services.ConsoleOutput;
import com.jeancsil.cli.services.ParseAnalyzer;

public class TextAnalyzer {

  public static void main(String[] args) {
    if (args.length == 0) {
      showUsage();
      System.exit(1);
    }

    var sb = new StringBuilder();
    for (String text : args) {
      sb.append(text).append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);

    var parseAnalyzer = new ParseAnalyzer();
    new ConsoleOutput().printFromMeta(parseAnalyzer.parse(new ICUAnalyzer(), sb.toString()), sb);
  }

  private static void showUsage() {
    yellow("usage:");
    yellow(" java -jar " + getExecutableName() + " [the text to be analyzed] ");
  }

  private static String getExecutableName() {
    return new java.io.File(
            TextAnalyzer.class.getProtectionDomain().getCodeSource().getLocation().getPath())
        .getName();
  }
}

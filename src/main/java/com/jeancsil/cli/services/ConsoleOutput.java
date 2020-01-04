package com.jeancsil.cli.services;

import java.util.LinkedList;
import java.util.Map;

public class ConsoleOutput {

  public void printFromMeta(Map<String, LinkedList<String>> meta, final StringBuilder inputString) {
    LinkedList<String> tokens = meta.get("tokens");
    LinkedList<String> scripts = meta.get("scripts");
    LinkedList<String> bytes = meta.get("bytes");

    var table = new String[tokens.size()][3];

    for (int i = 0; i < tokens.size(); i++) {
      String rtlMark = "";
      if (scripts.get(i).equals("Arabic")) {
        rtlMark = "\u200e";
      }

      table[i][0] = rtlMark + tokens.get(i);
      table[i][1] = scripts.get(i);
      table[i][2] = bytes.get(i);
    }

    System.out.print(String.format("%s", "Script"));
    System.out.print(String.format("%9s", "Bytes"));
    System.out.println(String.format("%59s", "Text"));

    for (String[] strings : table) {
      System.out.print(strings[1]);
      System.out.print(String.format("%" + (10 - strings[1].length()) + "s", ""));

      System.out.print(strings[2]);
      System.out.print(String.format("%" + (60 - strings[2].length()) + "s", ""));

      System.out.println(strings[0]);
    }
  }
}

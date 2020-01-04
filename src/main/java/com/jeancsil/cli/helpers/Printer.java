package com.jeancsil.cli.helpers;

public class Printer {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public Printer() {}

  public static void green(final String text) {
    System.out.print(String.format("%s%s%s", ANSI_GREEN, text, ANSI_RESET));
  }

  public static void greenln(final String text) {
    green(text);
    System.out.println();
  }

  public static void yellow(final String text) {
    System.out.print(String.format("%s%s%s", ANSI_YELLOW, text, ANSI_RESET));
  }

  public static void yellowln(final String text) {
    yellow(text);
    System.out.println();
  }

  public static void white(final String text) {
    System.out.print(String.format("%s%s%s", ANSI_WHITE, text, ANSI_RESET));
  }

  public static void whiteln(final String text) {
    white(text);
    System.out.println();
  }
}

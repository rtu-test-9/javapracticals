package ru.printers;

public class ConsolePrinter implements Printer {
    public void doPrint(String arg0) {
        System.out.println(arg0);
    }
}

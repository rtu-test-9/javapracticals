package ru.printers;
import org.springframework.stereotype.Component;

@Component("consolePrinterBean")
public class ConsolePrinter implements Printer {
    @Override
    public void doPrint(String arg0) {
        System.out.println(arg0);
    }
}

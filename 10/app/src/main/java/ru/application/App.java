package ru.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.printers.*;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
            );

        Printer consolePrinter = context.getBean("consolePrinterBean", ConsolePrinter.class);
        Printer filePrinter = context.getBean("filePrinterBean", FilePrinter.class);

        consolePrinter.doPrint("Hello from console printer");
        filePrinter.doPrint("Hello from file printer");

        context.close();
    }
}
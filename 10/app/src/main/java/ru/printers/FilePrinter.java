package ru.printers;

import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component("filePrinterBean")
public class FilePrinter implements Printer {
    @Override
    public void doPrint(String arg0) {
        try {
            FileOutputStream output = new FileOutputStream("output.txt");
            output.write(arg0.getBytes());
            output.close();
        }
        catch (IOException exception) {
            System.out.println("Couldnt open file");
        }
    }
}
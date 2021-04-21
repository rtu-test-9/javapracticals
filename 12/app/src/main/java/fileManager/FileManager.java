package fileManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;

public class FileManager {
    
    private String message = "";

    private String sourceFilePath;

    private String outputFilePath;

    @Value("${sourceFilePath.name}")
    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    @Value("${outputFilePath.name}")
    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }
    
    @PostConstruct
    public void init(){
        try {
            FileInputStream input = new FileInputStream(this.sourceFilePath);
            Scanner scan = new Scanner(input);
            while (scan.hasNextLine()) {
                message = message.concat(scan.nextLine());
            }
            scan.close();
            input.close();
        } catch (IOException exception) {
            message = "null";
        }
    }

    @PreDestroy
    public void die() throws Exception {
        FileOutputStream output = new FileOutputStream(this.outputFilePath);
        File inputFile = new File(this.sourceFilePath);
        inputFile.delete();
        output.write(message.getBytes());
        output.close();
    }
}

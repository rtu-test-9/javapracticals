package application;

import java.io.FileOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import fileManager.FileManager;

@Configuration
@ComponentScan("fileManager")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Bean
    @Scope("singleton")
    public FileManager fileManager() {
        return new FileManager();
    }
}
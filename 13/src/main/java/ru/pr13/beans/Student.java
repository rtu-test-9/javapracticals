package ru.pr13.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Student {
    @Autowired
    private Environment env;

    @Override
    public String toString() {
        return env.getProperty("student.name") + " " + env.getProperty("student.last_name") + " " + env.getProperty("student.group");
    }

    @GetMapping("/")
    public String getInfo (){
        return this.toString();
    }
}
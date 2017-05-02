package com.documents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class DocumentsBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(DocumentsBackendApplication.class, args);
    }
}

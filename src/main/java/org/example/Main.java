package org.example;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Main method to create an instance of the ArchiverIngestion class and call the archiveFolderFile() method
public class Main {
    public static void main(String[] args) throws IOException {
        ArchiverIngestion dataIngestionObj = new ArchiverIngestion();
        dataIngestionObj.archiveFolderFile();
        System.out.println("File successfully processed");
    }
}
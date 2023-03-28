package org.example;

import java.io.IOException;

// Main method to create an instance of the ArchiverIngestion class and call the archiveFolderFile() method
public class Main {
    public static void main(String[] args) throws IOException {
        ArchiverIngestion dataIngestionObj = new ArchiverIngestion();
        //dataIngestionObj.archiveFolderFile();
        System.out.println("File successfully processed");
        dataIngestionObj.cleanUpArchiveFolder();
        System.out.println("ARCHIVE folder clean successfully with all the folder, subfolder and files deleted");
    }
}
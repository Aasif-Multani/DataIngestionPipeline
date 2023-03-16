package org.example;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArchiverIngestion {
    // Declare instance variables
    private String landingLoc;
    private String archiveFolder;
    private String fileName;
    private String fileExtension;
    private String fileStatus;
    private String logPath;

    // Constructor to initialize the instance variables
    public ArchiverIngestion() {
        this.landingLoc = "landing";
        this.archiveFolder = "archive";
        this.fileName = "sample_file";
        this.fileExtension = ".csv";
        this.fileStatus = "processed";
        this.logPath = "log";
    }

    // Method to archive the file in a specified directory
    public void archiveFolderFile() throws IOException {
        // Get the current date and time in the desired format
        LocalDateTime currentTime = LocalDateTime.now();
        String currentDateTime = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String currentDate = currentTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Create the necessary directory structure if it doesn't exist
        String dateFolder = archiveFolder + File.separator + currentDate;
        File directory = new File(dateFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String finalFolder = dateFolder + File.separator + fileStatus;
        directory = new File(finalFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Specify the file paths for the source and destination files
        String landingLocPath = landingLoc + File.separator + fileName + fileExtension;
        String archiveFileName = fileName + "_" + currentDateTime + fileExtension;
        String archiveFolderPath = finalFolder + File.separator + archiveFileName;

        // Rename the source file and move it to the archive directory
        File archiveFile = new File(archiveFolderPath);
        File landingFile = new File(landingLocPath);
        landingFile.renameTo(archiveFile);
    }
}

import org.example.ArchiverIngestion;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;

public class main_test {
    @Test
    public void testArchiveFolderFile() throws IOException {
        // Create a temporary file in the landing directory for testing purposes
        File landingFile = new File("landing/sample_file.csv");
        landingFile.createNewFile();

        // Create a new instance of ArchiverIngestion
        ArchiverIngestion archiver = new ArchiverIngestion();

        // Call the archiveFolderFile() method
        archiver.archiveFolderFile();

        // Assert that the file has been moved to the archive directory
        File archiveFile = new File("archive/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "/processed/sample_file_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".csv");
        assertTrue(archiveFile.exists());
    }
}
import org.example.ArchiverIngestion;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

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
        String archiveFilePath = "archive/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "/processed/sample_file_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".csv";
        File archiveFile = new File(archiveFilePath);
        assertTrue("Archive file does not exist: " + archiveFilePath, archiveFile.exists());

        // Assert that the file is no longer present in the landing directory
        assertFalse("Landing file still exists", landingFile.exists());

        // Assert that the file has the correct content
        String expectedContent = "test content";
        String actualContent = Files.readString(archiveFile.toPath(), StandardCharsets.UTF_8);
        assertEquals("File content does not match", expectedContent, actualContent);
    }
}

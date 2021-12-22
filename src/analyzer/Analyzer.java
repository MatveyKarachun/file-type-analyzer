package analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Analyzer {

    public static String analyze(String filePath, String pattern, String fileType) throws IOException {

        byte[] patternBytes = pattern.getBytes();
        byte[] fileBytes = Files.readAllBytes(Path.of(filePath));

        boolean patternFound = false;

        for (int i = 0; i < fileBytes.length - patternBytes.length; i++) {
            if (fileBytes[i] == patternBytes[0]) {
                for (int j = 1; j < patternBytes.length; j++) {
                    if (patternBytes[j] != fileBytes[i + j]) {
                        break;
                    } else if (j == patternBytes.length - 1) {
                        patternFound = true;
                        break;
                    }
                }
                if (patternFound) {
                    break;
                }
            }
        }
        if (patternFound) {
            return fileType;
        } else {
            return "Unknown file type";
        }
    }
}

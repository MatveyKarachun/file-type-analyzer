package analyzer;

import analyzer.searchstrategies.SearchStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Analyzer {

    public static String analyze(String filePathStr, String pattern, String fileType, SearchStrategy strategy) throws IOException {

        byte[] patternBytes = pattern.getBytes();
        Path filePath = Path.of(filePathStr);
        byte[] fileBytes = Files.readAllBytes(filePath);

        String result = filePath.getFileName().toString() + ": ";
        if (strategy.search(fileBytes, patternBytes)) {
            return result + fileType;
        } else {
            return result + "Unknown file type";
        }
    }
}

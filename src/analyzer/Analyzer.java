package analyzer;

import analyzer.searchstrategies.SearchStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Analyzer {

    public static String analyze(String filePath, String pattern, String fileType, SearchStrategy strategy) throws IOException {

        byte[] patternBytes = pattern.getBytes();
        byte[] fileBytes = Files.readAllBytes(Path.of(filePath));

        if (strategy.search(fileBytes, patternBytes)) {
            return fileType;
        } else {
            return "Unknown file type";
        }
    }
}

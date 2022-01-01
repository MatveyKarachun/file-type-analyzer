package analyzer;

import analyzer.searchstrategies.SearchStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Analyzer {

    public static String analyze(String filePathStr, List<FilePattern> filePatterns, SearchStrategy strategy) throws IOException {

        Path filePath = Path.of(filePathStr);
        byte[] fileBytes = Files.readAllBytes(filePath);
        String result = filePath.getFileName().toString() + ": ";
        String fileType = "Unknown file type";

        for (FilePattern filePattern : filePatterns) {
            byte[] patternBytes = filePattern.getPattern().getBytes();
            if (strategy.search(fileBytes, patternBytes)) {
                fileType = filePattern.getFileType();
            }
        }

        result += fileType;
        return result;
    }
}

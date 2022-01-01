package analyzer;

import analyzer.searchstrategies.SearchStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        List<String> patternsLines = Files.readAllLines(Path.of(args[1]));
        List<FilePattern> filePatterns = new ArrayList<>(patternsLines.size());
        for (String patternLine : patternsLines) {
            String[] patternFields = patternLine.split(";");
            int priority = Integer.parseInt(patternFields[0]);
            String pattern = patternFields[1].replaceAll("\"", "");
            String fileType = patternFields[2].replaceAll("\"", "");
            filePatterns.add(new FilePattern(priority, pattern, fileType));
        }
        File testFilesDir = new File(args[0]);
        File[] testFiles = testFilesDir.listFiles();
        String algorithmName = "--naive";
        SearchStrategy strategy = SearchStrategy.createStrategy(algorithmName);
        ExecutorService executor = Executors.newFixedThreadPool(testFiles.length);
        List<Callable<String>> callables = new ArrayList<>(testFiles.length);
        for (File file : testFiles) {
            callables.add(() -> Analyzer.analyze(file.getAbsolutePath(), filePatterns, strategy));
        }
        List<Future<String>> futures = executor.invokeAll(callables);
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
    }
}

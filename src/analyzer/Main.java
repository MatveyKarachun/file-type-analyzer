package analyzer;

import analyzer.searchstrategies.SearchStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        File testFilesDir = new File(args[0]);
        File[] testFiles = testFilesDir.listFiles();
        String algorithmName = "--KMP";
        String pattern = args[1];
        String fileType = args[2];
        SearchStrategy strategy = SearchStrategy.createStrategy(algorithmName);
        ExecutorService executor = Executors.newFixedThreadPool(testFiles.length);
        List<Callable<String>> callables = new ArrayList<>(testFiles.length);
        for (File file : testFiles) {
            callables.add(() -> Analyzer.analyze(file.getAbsolutePath(), pattern, fileType, strategy));
        }
        List<Future<String>> futures = executor.invokeAll(callables);
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
    }
}

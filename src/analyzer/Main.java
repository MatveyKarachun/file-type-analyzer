package analyzer;

import analyzer.searchstrategies.SearchStrategy;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println(new File("").getAbsolutePath());
        String algorithmName = args[0];
        String relativePath = args[1];
        String pattern = args[2];
        String fileType = args[3];
        SearchStrategy strategy = SearchStrategy.createStrategy(algorithmName);
        long startTime = System.nanoTime();
        try {
            System.out.println(Analyzer.analyze(relativePath, pattern, fileType, strategy));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.println("It took " + ((double) elapsedNanos / 1000_000_000) + " seconds");
    }
}

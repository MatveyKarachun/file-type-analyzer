package analyzer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String relativePath = args[0];
        String pattern = args[1];
        String fileType = args[2];
        try {
            System.out.println(Analyzer.analyze(relativePath, pattern, fileType));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

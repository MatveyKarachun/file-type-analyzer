package analyzer.searchstrategies;

public interface SearchStrategy {

    boolean search(byte[] haystack, byte[] needle);

    static SearchStrategy createStrategy(String name) {
        if ("--naive".equals(name)) {
            return new NaiveAlgorithm();
        } else {
            return null;
        }
    }
}

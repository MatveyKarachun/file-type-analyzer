package analyzer.searchstrategies;

class NaiveAlgorithm implements SearchStrategy {

    @Override
    public boolean search(byte[] haystack, byte[] needle) {

        for (int i = 0; i < haystack.length - needle.length; i++) {
            if (haystack[i] == needle[0]) {
                for (int j = 1; j < needle.length; j++) {
                    if (needle[j] != haystack[i + j]) {
                        break;
                    } else if (j == needle.length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

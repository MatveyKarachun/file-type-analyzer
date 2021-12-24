package analyzer.searchstrategies;

public class Kmp implements SearchStrategy {

    byte[] needle;
    int[] p;//prefix function

    @Override
    public boolean search(byte[] haystack, byte[] needle) {
        this.needle = needle;
        calculatePrefixFunc();
        for (int i = 0, shift = 1; i < haystack.length - needle.length + 1; i += shift) {
            for (int j = 0; j < needle.length; j++) {
                if (haystack[i + j] != needle[j]) {
                    if (j == 0) {
                        shift = 1;
                    } else {
                        shift = j - p[j - 1];
                    }
                    break;
                } else if (j == needle.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void calculatePrefixFunc() {
        p = new int[needle.length];
        p[0] = 0;
        for (int i = 1; i < needle.length; i++) {
            p[i] = longestBorderThatCanBeExtendedLength(i - 1, needle[i]) + 1;
        }
    }

    private int longestBorderThatCanBeExtendedLength(int ind, byte current) {
        if (ind == -1) {
            return - 1;
        }
        if (needle[p[ind]] == current) {
            return p[ind];
        }
        return longestBorderThatCanBeExtendedLength(p[ind] - 1, current);
    }
}
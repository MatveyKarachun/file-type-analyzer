package analyzer.searchstrategies;

public class Kmp implements SearchStrategy {

    byte[] needle;
    int[] p;//prefix function

    @Override
    public boolean search(byte[] haystack, byte[] needle) {
        this.needle = needle;
        prefixFunc();

        return false;
    }

    private void prefixFunc() {
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
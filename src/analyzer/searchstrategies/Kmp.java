package analyzer.searchstrategies;

import java.util.ArrayList;
import java.util.List;

public class Kmp implements SearchStrategy {

    @Override
    public boolean search(byte[] haystack, byte[] needle) {

        int[] p = prefixFunc(needle);

        return false;
    }

    private static int[] prefixFunc(byte[] seq) {

        int[] p = new int[seq.length];
        p[0] = 0;
        for (int i = 1; i < seq.length; i++) {
            p[i] = longestBorderThatCanBeExtendedLength(seq, p, i) + 1;
        }

        return p;
    }


    private static int longestBorderThatCanBeExtendedLength(byte[] seq, int[] p, int ind) {
        if (ind == 0) {
            return -1;
        }
        if (seq[p[ind - 1]] == seq[ind]) {
            return p[ind - 1];
        } else {
            return longestBorderThatCanBeExtendedLength(seq, p, p[ind - 1]);
        }
    }

}

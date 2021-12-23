package analyzer.searchstrategies;

public class Kmp implements SearchStrategy {

    @Override
    public boolean search(byte[] haystack, byte[] needle) {

        int[] p = prefixFunc(needle);

        return false;
    }

    private static int[] prefixFunc(byte[] seq) {

        int[] p = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            p[i] = pp(i, seq[i], seq, p);
        }

        return p;
    }

    private static int pp(int i, byte current, byte[] seq, int[] p) {
        if (i == -1) {
            return 0;
        }
        if (i == 0) {
            return 0;
        }
        if (seq[p[i - 1]] == current) {
            return p[i - 1] + 1;
        }
        return pp(p[i - 1] - 1, current, seq, p);
    }

    public static void main(String[] args) {
        byte[] dick = "abcdabefabcdabghabcdabq".getBytes();
        int[] p = prefixFunc(dick);
        for (int i : p) {
            System.out.print(i + " ");
        }
    }
}
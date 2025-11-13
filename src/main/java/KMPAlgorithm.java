import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {

    private int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int length = 0; // length of the longest prefix(and also suffix)
        int i = 1;
        lps[0] = 0;

        // build the LPS array
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++; // extended the prefix match
                lps[i] = length; // store the longest prefix-suffix so far
                i++;
            } else {
                // if mismatch after some matches, then jump back using LPS
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public List<Integer> KMPSearch(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        List<Integer> result = new ArrayList<>();

        if (M == 0 || N < M) {
            return result;
        }

        int[] lps = computeLPSArray(pattern); // precompute fallback table

        int i = 0;
        int j = 0;

        // Scan text using the pattern and LPS table
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            // if full match found
            if (j == M) {
                result.add(i - j);
                j = lps[j - 1]; // continue searching
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                // if mismatch after some matches, then jump using LPS
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++; // if notjing, then just move forward
                }
            }
        }
        return result;
    }
}
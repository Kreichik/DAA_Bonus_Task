import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KMPAlgorithmTest {

    private final KMPAlgorithm kmp = new KMPAlgorithm();

    @Test
    void testShortString() {
        String text = "AAAAABABAAAABAA";
        String pattern = "ABA";
        List<Integer> expected = Arrays.asList(4, 6, 11);
        List<Integer> actual = kmp.KMPSearch(text, pattern);
        assertEquals(expected, actual);
    }

    @Test
    void testMediumLengthString() {
        String text = "ABCXABCABHHYABCABCX";
        String pattern = "ABCX";
        List<Integer> expected = Arrays.asList(0, 15);
        List<Integer> actual = kmp.KMPSearch(text, pattern);
        assertEquals(expected, actual);
    }

    @Test
    void testLongerStringWithOverlap() {
        String text = "AAAAAAABBBBAAAAAAAAAAAAAAABAAAAAABBAAAA";
        String pattern = "AAAAB";
        List<Integer> expected = Arrays.asList(3, 22, 29);
        List<Integer> actual = kmp.KMPSearch(text, pattern);
        assertEquals(expected, actual);
    }

    @Test
    void testNoMatch() {
        String text = "The quick brown fox jumps over the lazy dog";
        String pattern = "KMP";
        List<Integer> actual = kmp.KMPSearch(text, pattern);
        assertTrue(actual.isEmpty());
    }
}
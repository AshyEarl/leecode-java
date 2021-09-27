package ashy.earl.leecode;

import java.util.ArrayList;

public class _0005_LongestPalindromicSubstring implements MyTest {
    @Override
    public void test() {
//        System.out.println("babad: " + longestPalindrome("babad"));
//        System.out.println("cbbd: " + longestPalindrome("cbbd"));
//        System.out.println("a: " + longestPalindrome("a"));
//        System.out.println("ac: " + longestPalindrome("ac"));
        System.out.println("aacabdkacaa: " + longestPalindrome("aacabdkacaa"));
    }

    private static boolean isPalindromic(String s, int start, int end) {
        for (int i = 0, n = ((end - start) >>> 1) + 1; i < n; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        int max = 1;
        int start = 0;
        int end = 0;
        ArrayList<Integer>[] lastIdxs = new ArrayList[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ArrayList<Integer> idxs = lastIdxs[c - '0'];
            if (idxs == null) {
                idxs = new ArrayList<>(2);
                idxs.add(i);
                lastIdxs[c - '0'] = idxs;
                continue;
            } else idxs.add(i);
            for (int idx : idxs) {
                int len = i - idx + 1;
                // No need try short case.
                if (len <= max) break;
                if (isPalindromic(s, idx, i)) {
                    max = len;
                    start = idx;
                    end = i;
                    break;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

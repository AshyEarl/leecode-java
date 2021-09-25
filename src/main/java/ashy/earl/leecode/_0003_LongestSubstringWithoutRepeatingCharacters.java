package ashy.earl.leecode;

// https://leetcode.com/problems/longest-substring-without-repeating-characters
public class _0003_LongestSubstringWithoutRepeatingCharacters implements MyTest {
    @Override
    public void test() {
//        System.out.println("'': " + lengthOfLongestSubstring(""));
//        System.out.println("'abcabcbb': " + lengthOfLongestSubstring("abcabcbb"));
//        System.out.println("' ': " + lengthOfLongestSubstring(" "));
//        System.out.println("'aab': " + lengthOfLongestSubstring("aab"));
//        System.out.println("'abba': " + lengthOfLongestSubstring("abba"));
//        System.out.println("'nfpdmpi': " + lengthOfLongestSubstring("nfpdmpi"));
        System.out.println("'aabaab!bb': " + lengthOfLongestSubstring("aabaab!bb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] lastIdxs = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIdxs[i] = -1;
        }
        int max = 0;
        // Last no repeate char start index.
        int lastRepeatStart = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIdx = lastIdxs[c];
            int noRepeatLen = i - lastRepeatStart;
            if (lastIdx != -1) {
                int len = i - lastIdx;
                // Ignore: abba (i==3)-> len[4] vs noRepeatLen[2]
                if (len > noRepeatLen) len = noRepeatLen;
                // abba (i==3)-> lastRepeatStart[1] vs lastIdx[0]
                if (lastRepeatStart < lastIdx) lastRepeatStart = lastIdx;
                if (len > max) max = len;
            } else {
                if (noRepeatLen > max) max = noRepeatLen;
            }
            lastIdxs[c] = i;
        }
        return max;
    }
}

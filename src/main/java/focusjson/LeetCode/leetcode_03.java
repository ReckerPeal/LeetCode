package focusjson.LeetCode;


import java.util.HashSet;
import java.util.Set;

public class leetcode_03 {

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(slideWindows(s));

        String s1 = "abcaabcded";
        System.out.println(slideWindows(s1));
        String s3 = " ";
        System.out.println(slideWindows(s3));
        String s4 = "";
        System.out.println(slideWindows(s4));
    }

    //dvdf
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        Set<Character> characters = new HashSet<>();
        int max = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            characters.add(chars[i]);
            for (int j = i + 1; j < s.length(); j++) {
                if (characters.contains(chars[j])) {
                    max = j - i >= max ? j - i : max;
                    characters.clear();
                    break;
                }
                characters.add(chars[j]);
                max = j - i >= max ? j - i + 1 : max;
            }
        }
        return max;
    }

    public static int lenghtOfLongsSubString(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isAllUnique(i, j, s)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    public static boolean isAllUnique(int start, int end, String s) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    /**
     * 滑动窗口方式，设置两个变量，一个为起始位置startIndex，
     * 一个为滑动位置slideIndex，查找字符串中出现的字符放进set，
     * 如果查找到重复元素，startIndex，删除第一个元素，起始元素前移。
     * 最坏效率O(2n),查询复杂度为O(n)
     * @param s
     * @return
     */
    public static int slideWindows(String s) {
        int i = 0, j = 0, n = s.length(), max = 0;
        Set<Character> characterSet = new HashSet<>();
        while (i < n && j < n) {
            if (!characterSet.contains(s.charAt(j))) {
                characterSet.add(s.charAt(j++));
                max= Math.max(max,j-i);
            } else {
                characterSet.remove(s.charAt(i++));
            }
        }
        return max;
    }
}

package focusjson.LeetCode;


import java.util.HashSet;
import java.util.Set;

public class leetcode_03 {

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));

        String s1 = "abcaabcded";
        System.out.println(lengthOfLongestSubstring(s1));
        String s3 = " ";
        System.out.println(lengthOfLongestSubstring(s3));
        String s4 = "";
        System.out.println(lengthOfLongestSubstring(s4));
    }

    //dvdf
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if(chars.length==0){
            return 0;
        }
        Set<Character> characters= new HashSet<>();
        int max=1;
        for (int i =0;i<chars.length-1;i++){
            characters.add(chars[i]);
            for (int j=i+1;j<s.length();j++){
                if(characters.contains(chars[j])){
                    max=j-i>=max?j-i:max;
                    characters.clear();
                    break;
                }
                characters.add(chars[j]);
                max=j-i>=max?j-i+1:max;
            }
        }
        return max;
    }
}

package sun.xiaolei.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:无重复字符的最长子串
 * <p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class P3_longest_substring_without_repeating_characters {

    public static void main(String[] args) {
        System.out.println("abcabcbb:" + lengthOfLongestSubstring3("abcabcbb"));
        System.out.println("bbbbb:" + lengthOfLongestSubstring3("bbbbb"));
        System.out.println("pwwkew:" + lengthOfLongestSubstring3("pwwkew"));
        System.out.println("a:" + lengthOfLongestSubstring3("a"));

    }

    /**
     * 暴力法
     * 逐个检查所有的子字符串，看它是否不含有重复的字符
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                //遍历检查是否包含重复元素
                if (traversal(s, i, j)) maxLength = Math.max(maxLength, j - i);
            }
        }
        return maxLength;
    }

    public static boolean traversal(String s, int start, int end) {
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
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            }
        }
        return maxLength;
    }

    /**
     * 滑动窗口的优化
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }

}

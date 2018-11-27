package p46;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * @author Guozhu Zhu
 * @date 2018/11/27
 * @version 1.0
 *
 */
public class Demo02 {
	
	public static void main(String[] args) {
		String str = "afjdlafjdlty";
		int ans = lengthOfLongestSubstring(str);
		System.out.println(ans);
	}
	
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}

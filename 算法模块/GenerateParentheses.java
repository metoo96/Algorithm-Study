package p28;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author Guozhu Zhu
 * @date 2018/8/16
 * @version 1.0
 *
 */
public class Test03 {
	
	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
	    for (String i : res) {
	    	System.out.println(i);
	    }
	}
	
	public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", n, n);
        return ans;
    }

    public static void dfs(List<String> list, String st, int left, int right) {
        if (left > right) {
        	return;
        }
        System.out.println("left:" + left + "right" + right);
        if (left == 0 && right == 0) {
            list.add(st);
        }
        if (left > 0) {
        	dfs(list, st + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(list, st + ")", left, right- 1);	
        } 
    }

}

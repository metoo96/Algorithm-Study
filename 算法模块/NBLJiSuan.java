package p19;

import java.util.Stack;

/**
 * 简单逆波兰表达式求解
 * @author Guozhu Zhu
 * @date 2018/8/5
 * @version 1.0
 *
 */
public class NBLJisuan {
	
	public static Stack<String> ms2 = new Stack<>();
	public static void main(String[] args) throws Exception {
		String[] nbl = {"1", "0", "-", "3", "%"};
		System.out.println(NBLJisuan(nbl));
	}
	
	//求值
	public static int NBLJisuan(String[] nbl) throws Exception {
		  for (String s : nbl) {
	            if (s.matches("\\d++") || s.charAt(0) == '-' && s.length() > 1) {
	                ms2.push(s);
	            } else {
	            	int res = 0;
	                int b = Integer.parseInt(ms2.pop());
	                int a = Integer.parseInt(ms2.pop());
	                if (s.equals("+")) {
	                    res = a + b;
	                } else if (s.equals("-")) {
	                   res = a - b;
	                } else if (s.equals("*")) {
	                   res = a * b;
	                } else if (s.equals("\\")) {
	                   res = a / b;
	                } else if (s.equals("%")) {
	                   if (b != 0) {
	                   res = a % b;
	                   } else {
	                	   throw new Exception("求余时错误！");
	                   }
	                }
	                ms2.push("" + res);
	            }
	        }
	        return Integer.parseInt(ms2.pop());
	}

}

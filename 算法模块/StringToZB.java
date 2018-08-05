package p19;

import java.util.ArrayList;

/**
 * 将字符串转换为中序表达式
 * @author Guozhu Zhu
 * @date 2018/8/5
 * @version 1.0
 *
 */
public class StringToZB {
	
	public static void main(String[] args) {
		String str = "1+2+3+7+6+(8+99)";
		ArrayList<String> list = stringToZB(str);
		for (String i : list) {
			System.out.println(i);
		}
	}
    
	//将字符串分割为子字符串
	private static ArrayList<String> stringToZB(String str) {
	    ArrayList<String> newList = new ArrayList<>();
	    int i = 0;
	    String str1 = "";
	    while (i < str.length()) {
	    	if (str.charAt(i) < 48 || str.charAt(i) > 57) {  //非数字
	    		newList.add(str.charAt(i) + "");
	    		i++;
	    	} else {
	    		str1="";
	    		while (i < str.length() && str.charAt(i) >= 48 && str.charAt(i) <= 57) {
	    			str1 +=  str.charAt(i);
	    			i++;	
	    			}
	    		}
	    	    newList.add(str1 + ""); 
	    	}
		return newList;
	}

}

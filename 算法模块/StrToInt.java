package p30;

/**
 * 字符串转换为整数
 * @author Guozhu Zhu
 * @date 2018/8/20
 * @version 1.0
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		String str = "-1234567";
	    int res = StrToInt(str);
	    System.out.println(res); 
	}
	
	public static int StrToInt(String str) {
		if (str.length() == 0 || "".equals(str)) {
			return 0;
		}
		int mark = 0;    //标记开始解析的位置
		int sum = 0;     //合计的结果
		char[] ch = str.toCharArray();
		if (ch[0] == '-') {
			mark = 1;
		}
		//开始解析
		for (int i = mark; i < ch.length; i++) {
			if (ch[i] == '+') {
				continue;
			}
			if (ch[i] < 48 || ch[i] > 57) {
				return 0;
			}
			sum = sum*10 + ch[i]-48;
		}
		return mark == 0 ? sum : -sum;
	}

}

package pOffer;

/**
 * 替换空格
 * @author Guozhu Zhu
 * @date 2018/12/24
 * @version 1.0
 *
 */
public class Demo02 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		StringBuffer strBuf = new StringBuffer("zhuguozhu  zhuguozhu zhuguozhu");
		String resStr = replaceSpace(strBuf);
		System.out.println(resStr);
		String resStr1 = replaceSpace1(strBuf);
		System.out.println(resStr1);
	}
	
	//method1
	public static String replaceSpace(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}
	
	//method2
	public static String replaceSpace1(StringBuffer str) {
		StringBuilder strBud = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				strBud.append("%20");
			} else {
				strBud.append(str.charAt(i));
			}
		}
		return strBud.toString();
	}

}

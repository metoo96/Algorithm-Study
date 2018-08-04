package p19;

/**
 * 翻转单词的顺序列
 * Example:
 * Before: "Student a am I"
 * After:  "I am a Student"
 * @author Guozhu Zhu
 * @date 2018/8/4
 * @version 1.0
 *
 */
public class Test01 {
	
	public static void main(String[] args) {
		String str = "Student a am I";
		System.out.println(reverseString(str));
	}
	
	public static String reverseString(String str) {
		char[] arr = str.toCharArray();
		reverse(arr, 0, arr.length-1);    //整体翻转
		int start = 0;
		for (int i = 0; i <= arr.length; i++) {
			if (i == arr.length || arr[i] == ' ') {
				reverse(arr, start, i-1); //局部单词翻转
				start = i + 1;
			}
		}
		return new String(arr);
	}
	
	//翻转
	public static void reverse(char[] arr, int start, int end) {
		while (start < end) {
			char temp = arr[start];
			arr[start++] = arr[end];
			arr[end--] = temp;
		}
	}

}

package p19;

import java.util.ArrayList;
import java.util.List;

/**
 * 逆波兰表达式求值
 * @author Guozhu Zhu
 * @date 2018/8/5
 * @version 1.0
 *
 */
public class NBL {
	
    private static MyStack ms1 = new MyStack();//生成逆波兰表达式的栈
    private static MyStack ms2 = new MyStack();//运算栈

    // 将字符串转换为中序表达式
    public static List<String> zb(String s) {
        List<String> ls = new ArrayList<String>();//存储中序表达式
        int i = 0;
        String str;
        char c;
        while (i < s.length()){
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48
                        && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }
        return ls;
    }
    
    //将中序表达式转换为逆波兰表达式
    /**
	1、从左至右扫描中缀表达式。
	2、若读取的是操作数，则判断该操作数的类型，并将该操作数存入操作数堆栈
	3、若读取的是运算符
	  (1) 该运算符为左括号"("，则直接存入运算符堆栈。
	  (2) 该运算符为右括号")"，则输出运算符堆栈中的运算符到操作数堆栈，直到遇到左括号为止。
	  (3) 该运算符为非括号运算符：
	      (a) 若运算符堆栈栈顶的运算符为括号，则直接存入运算符堆栈。
	      (b) 若比运算符堆栈栈顶的运算符优先级高，则直接存入运算符堆栈。
	      (c) 若比运算符堆栈栈顶的运算符优先级低或相等，则输出栈顶运算符到操作数堆栈，并将当前运算符压入运算符堆栈。
	4、当表达式读取完成后运算符堆栈中尚有运算符时，则依序取出运算符到操作数堆栈，直到运算符堆栈为空。
     */
    public static List<String> parse(List<String> ls) {
        List<String> lss = new ArrayList<String>();
        for (String ss : ls) {
            if (ss.matches("\\d+") || (ss.charAt(0) == '-' && ss.length() > 1)) {        //数字
                lss.add(ss);
            } else if (ss.equals("(")) {     //(
                ms1.push(ss);
            } else if (ss.equals(")")) {     //)
                while (!ms1.top.equals("(")) {
                    lss.add(ms1.pop());
                }
                ms1.pop();       
            } else {
                while (ms1.size() != 0 && getValue(ms1.top) >= getValue(ss)) {
                    lss.add(ms1.pop());
                }
                ms1.push(ss);
            }
        }
        while (ms1.size() != 0) {
            lss.add(ms1.pop());
        }
        return lss;
    }
    
    //对逆波兰表达式进行求值
    public static int jisuan(List<String> ls) {
        for (String s : ls) {
        	//自然数和负数时
            if (s.matches("\\d+") || (s.length() > 1 && s.charAt(0) == 0)) { 
                ms2.push(s);
            } else {
                int b = Integer.parseInt(ms2.pop());
                int a = Integer.parseInt(ms2.pop());
                if (s.equals("+")) {
                    a = a + b;
                } else if (s.equals("-")) {
                    a = a - b;
                } else if (s.equals("*")) {
                    a = a * b;
                } else if (s.equals("\\")) {
                    a = a / b;
                }
                ms2.push("" + a);
            }
        }
        return Integer.parseInt(ms2.pop());
    }
    
    //获取运算符优先级 +,-为1 *,/为2 ()为0
    public static int getValue(String s) {
        if (s.equals("+")) {
        	return 1;
        } else if (s.equals("-")) {
        	return 1;
        } else if (s.equals("*")) {
        	return 2;
        } else if (s.equals("\\")) {
        	return 2;
        }
        return 0;
    }
    
    //========Test========
    public static void main(String[] args) {
        System.out.println(jisuan(parse(zb("1+((2+3)*4)-5"))));
    }

}

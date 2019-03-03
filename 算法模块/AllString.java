package p55;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 字符串的全排列
 * @author Guozhu Zhu
 * @date 2019/3/3
 * @version 1.0
 *
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            Set<String> set = getSortSet(str.toCharArray(), 0);
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println();
        }
    }
    
    public static Set<String> getSortSet(char[] cs, int start) {
        Set<String> set = new TreeSet<>();
        if (start == cs.length-1) {
            set.add(String.valueOf(cs));
            return set;
        }
        for (int j = 0; j < cs.length; j++) {
            swap(cs, start, j);
            set.addAll(getSortSet(cs, start+1));
            swap(cs, start, j);
        }
        return set;
    }
    
    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    
}

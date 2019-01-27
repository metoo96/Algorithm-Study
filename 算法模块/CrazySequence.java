
import java.util.*;
/**
 * 疯狂序列
 * @author Guozhu Zhu
 * @version  2019/1/27
 * @version  1.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long ans = (long)Math.ceil(((Math.sqrt(1+8*num) - 1) / 2));
        System.out.println(ans);
        return;
    }

}
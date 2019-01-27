import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int I = sc.nextInt();
            int J = sc.nextInt();
            int K = sc.nextInt();
            int[][] a = new int[I][J];
            int[][] b = new int[J][K];
            int[][] c = new int[I][K];
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < J; i++) {
                for (int j = 0; j < K; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < I; i++) {
                for (int j = 0; j <K; j++) {
                    c[i][j] = 0;
                    for (int k = 0; k < J; k++) {
                        c[i][j] += a[i][k]*b[k][j];
                    }
                }
            }
            for (int i = 0; i < I; i++) {
                for (int k = 0; k < K; k++) {
                    System.out.print(c[i][k] + " ");
                    if (k == K-1) {
                        System.out.println();
                    }
                }
            }
            
        }
    }
    
}
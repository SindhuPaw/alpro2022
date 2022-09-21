import java.util.Scanner;

public class Tantangan {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("n = ");
        int n = inp.nextInt();

        for(int i = 0; i < n; i++) {
            if(i <= n / 2) {
                for(int j = 0; j < n; j++) {
                    if(j <= i || j >= n - (i + 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for(int j = 0; j < n; j++) {
                    if(j >= i || j <= n - (i + 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            
        System.out.println();
        }
    }
}
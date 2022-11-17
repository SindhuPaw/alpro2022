import java.util.Scanner;

public class Pola {
    public static void main(String[] args) {
        int n; // jumlah baris dan kolom pola
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan nilai n = ");
        n = inp.nextInt();

        int i = 1;
        while(i <= n) {
            int j = 1;
            while (j<=n) {
                if ((j <= i || j >= (n + 1) - i) && (j >= i || j <= (n + 1) - i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                j++;
            }

            System.out.println();
            i++;
        }
    }
}

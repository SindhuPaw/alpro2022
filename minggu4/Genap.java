import java.util.Scanner;

public class Genap {
    public static void main(String[] args) {
        int n; // jumlah angka genap yang akan ditampilkam
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan nilai n = ");
        n = inp.nextInt();

        int i = 1;
        while(i <= 2 * n) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }

            i++;
        }
    }
}

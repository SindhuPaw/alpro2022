import java.util.Scanner;

public class Penjumlahan{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan nilai x = ");
        int x = scan.nextInt();
        System.out.print("Masukkan nilai y = ");
        int y = scan.nextInt();

        int hasil = x + y;

        System.out.println("x + y = " + hasil);
    }
}
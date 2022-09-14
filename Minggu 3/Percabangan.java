import java.util.Scanner;

public class Percabangan {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String keterangan;

        System.out.print("Masukkan nama : ");
        String nama = scan.nextLine();
        System.out.print("Masukkan nilai : ");
        int nilai = scan.nextInt();

        if ( nilai >= 60){
            keterangan = "Lulus";
        }else{
            keterangan = "Tidak lulus";
        }

        System.out.println(nama + ' ' + keterangan);
    }
}

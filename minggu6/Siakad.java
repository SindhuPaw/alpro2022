import java.util.Scanner;

public class Siakad {
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static int jumData = 0;
    // static Scanner scan = new Scanner(System.in);

    public static void tambahData() {
        Scanner scan = new Scanner(System.in);
        String nim, nama;

        System.out.println("\nSilahkan tambah data!");
        System.out.print("Nama = ");
        nama = scan.nextLine();
        System.out.print("NIM = ");
        nim = scan.nextLine();

        mahasiswa[jumData] = new Mahasiswa();
        mahasiswa[jumData].setNim(nim);
        mahasiswa[jumData].setNama(nama);
        jumData++;
    }

    public static void tampilData() {
        System.out.println("\nBerikut data Anda:");

        int i = 0;
        while (i < jumData) {
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\nMenu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu = ");
            menu = scan.nextInt();

            if(menu == 1) {
                tambahData();
            } else if(menu == 2) {
                tampilData();
            }
        } while (menu != 3);
    }
}
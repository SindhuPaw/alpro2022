import java.util.Scanner;

public class Siakad {
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static int jumData = 0;

    public static void tambah() {
        Scanner scan = new Scanner(System.in);
        String nim, nama;

        System.out.print("Nama : ");
        nama = scan.nextLine();
        System.out.print("NIM : ");
        nim = scan.nextLine();

        mahasiswa[jumData] = new Mahasiswa();
        mahasiswa[jumData].setNama(nama);
        mahasiswa[jumData].setNim(nim);
        jumData++;
    }

    public static void tampilkan() {
        System.out.println("\nBerikut data Anda :");

        int i = 0;
        while(i < jumData) {
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
    }

    public static void urutkan() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pilih algoritma pengurutan :");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.print("Pilih algoritma : ");
        int algo = scan.nextInt();

        switch(algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 3: {
                quickSort(mahasiswa, 0, jumData - 1);
                break;
            }
        }
    }

    public static void exchangeSort() {
        for(int x = 0; x < jumData; x++) {
            for (int y = x + 1; y < jumData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) <= -1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j].getNim().compareTo(arr[low].getNim())<=-1)
                swap(arr, ++p, j);
    
        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot){
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\nMenu siakad :");
            System.out.println("1. Tambah data");
            System.out.println("2. Lihat data");
            System.out.println("3. Urutkan data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu : ");
            menu = scan.nextInt();

            if (menu == 1) {
                tambah();
            } else if (menu ==2 ) {
                tampilkan();
            } else if (menu == 3) {
                urutkan();
            }
        } while (menu!=4);
    }
}
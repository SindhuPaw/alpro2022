import java.util.Scanner;

class Siakad {
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static int jumData = 0;

    static void tambah() {
        Scanner scan = new Scanner(System.in);
        String nim, nama;

        System.out.println("\n===Tambah Data===");
        System.out.print("NIM : ");
        nim = scan.nextLine();
        System.out.print("Nama : ");
        nama = scan.nextLine();

        mahasiswa[jumData] = new Mahasiswa();
        mahasiswa[jumData].setNim(nim);
        mahasiswa[jumData].setNama(nama);
        jumData++;
    }

    static void tampilkan() {
        System.out.println("\nBerikut data Anda :");

        int i = 0;
        while(i < jumData) {
            System.out.println(mahasiswa[i].getNim() + " " + mahasiswa[i].getNama());
            i++;
        }
    }

    static void urutkan() {
        Scanner scan = new Scanner(System.in);
        int algo;

        System.out.println("\n===Algoritma Pengurutan===");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.print("Pilih algoritma : ");
        algo = scan.nextInt();

        switch(algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort(mahasiswa, jumData);
                break;
            }
            case 3: {
                quickSort(mahasiswa, 0, jumData - 1);
            }
        }
    }

    static void exchangeSort() {
        for(int x = 0; x < jumData; x++) {
            for (int y = x + 1; y < jumData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) > 0) {
                    swap(x, y);
                }
            }
        }
    }

    static void selectionSort(int low) {
        Mahasiswa temp = mahasiswa[low];
        int index = 0;

        for(int i = low + 1; i < jumData; i++) 
            if(mahasiswa[i].getNim().compareTo(temp.getNim()) < 0) {
                temp = mahasiswa[i];
                index = i;
            }

        if(index != 0)
            swap(low, index);

        if(low < jumData)
            selectionSort(low + 1);
    }

    static void quickSort(Mahasiswa[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high){
        Mahasiswa pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++) 
            if(arr[j].getNim().compareTo(pivot.getNim()) < 0 ) {
                i++;
                swap(i, j);
            }

        swap((i + 1), high);
        return (i + 1);
    }

    static void swap(int i, int j) {
        Mahasiswa temp = mahasiswa[i];
        mahasiswa[i] = mahasiswa[j];
        mahasiswa[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n===Menu Siakad===");
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
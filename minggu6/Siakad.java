import java.util.Scanner;

class Siakad {
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static int jumData = 0;

    static void tambah() {
        Scanner scan = new Scanner(System.in);
        long nim;
        String nama;

        System.out.println("\n===Tambah Data===");
        System.out.print("NIM : ");
        nim = scan.nextLong();
        scan.nextLine();
        System.out.print("Nama : ");
        nama = scan.nextLine();

        mahasiswa[jumData] = new Mahasiswa();
        mahasiswa[jumData].setNim(nim);
        mahasiswa[jumData].setNama(nama);
        jumData++;

        System.out.println();
    }

    static void tampilkan() {
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < jumData; i++) {
            System.out.println((i + 1) + ". " + mahasiswa[i].getNama() + " - " + mahasiswa[i].getNim());
        }
    }

    static void urutkan() {
        Scanner scan = new Scanner(System.in);
        int algo;

        System.out.println("\n===Urutkan Data===");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Insertion Sort");
        System.out.println("5. Bubble Sort");
        System.out.println("6. Shell Sort");
        System.out.println("7. Binary Insertion Sort");
        System.out.print("\nPilihan : ");
        algo = scan.nextInt();
        scan.nextLine();

        switch(algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort();
                break;
            }
            case 3: {
                quickSort(0, jumData - 1);
                break;
            }
            case 4: {
                insertionSort();
                break;
            }
            case 5: {
                bubbleSort();
                break;
            }
            case 6: {
                shellSort();
                break;
            }
            case 7: {
                binaryInsertionSort();
                break;
            }
        }
    }

    static void binaryInsertionSort() {
        for(int i = 1; i < jumData; i++) {
            int temp = i;

            for(int j = i - 1; j > -1; j--) {
                if(mahasiswa[temp].getNim() < mahasiswa[j].getNim()) {
                    swap(temp, j);
                    temp -= 1;
                } else {
                    break;
                }
            }
        }
    }

    static void shellSort() {
        for(int gap = jumData / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < jumData; i++) {
                for(int j = i; j >= gap && mahasiswa[j].getNim() < mahasiswa[j - gap].getNim(); j--) {
                swap(j, j - gap);
                }   
            }
        }
    }

    static void bubbleSort() {
        for(int i = jumData; i > 1; i--) {
            for(int j = 0; j < i - 1; j++) {
                if(mahasiswa[j].getNim() > mahasiswa[j + 1].getNim()) {
                    swap(j, (j + 1));
                }
            }
        }
    }

    static void insertionSort() {
        for(int i = 1; i < jumData; i++) {
            for(int j = i; j > 0; j--) {
                if(mahasiswa[j - 1].getNim() > mahasiswa[j].getNim()) {
                    swap((j - 1), j);
                } else {
                    break;
                }
            }
        }
    }

    static void quickSort(int low, int high){
        if(low < high) {
            Long pivot = mahasiswa[high].getNim();
            int index = low - 1;
            int swapPivot = 0;
            int i = 0;

            for(i = low; i < high; i++) {
                if(mahasiswa[i].getNim() <= pivot) {
                    swapPivot = 1;
                    index++;
                    if(index != i) {
                        swap(index, i);
                    }
                }
            }

            if(mahasiswa[index + 1].getNim() > mahasiswa[high].getNim()) {
                index++;
                if(index != i) {
                    swap(index, high);
                }
            }

            if((index - 1) > 0) {
                quickSort(low, index - 1);
            }
            if((index + 1) <= jumData) {
                quickSort(index + 1, high);
            }
        }
    }

    static void selectionSort() {
        for(int i = 0; i < jumData - 1; i++) {
            Mahasiswa temp = mahasiswa[i];
            int swap = 0;
            int secondArgument = 0;

            for(int j = i + 1; j < jumData; j++) {
                if (temp.getNim() > mahasiswa[j].getNim()) {
                    temp = mahasiswa[j];
                    secondArgument = j;
                    swap = 1;
                }
            }

            if(swap == 1) {
                swap(i, secondArgument);
            }
       }
    }

    static void swap(int x, int y) {
        Mahasiswa temp = mahasiswa[x];
        mahasiswa[x] = mahasiswa[y];
        mahasiswa[y] = temp;
    }

    static void exchangeSort() {
        for(int i = 0; i < jumData; i++) {
            for (int j = i + 1; j < jumData; j++) {
                if (mahasiswa[i].getNim() > mahasiswa[j].getNim()) {
                    swap(i, j);
                }
            }
        }
    }

    static void cari() {
        Scanner scan = new Scanner(System.in);
        int pilihan;
        long nim;
        String nama = "";

        System.out.println("\n===Cari Data===");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("\nPilihan : ");
        pilihan = scan.nextInt();
        scan.nextLine();

        nim = formCari();

        switch(pilihan) {
            case 1: {
                nama = linear(nim);
                break;
            }
            case 2: {
                nama = binary(nim, 0, (jumData - 1));
                break;
            }
        }

        if(nama.equals("error")) {
            System.out.println("Data tidak ditemukan!");
        } else {
            System.out.println("Nama : " + nama);
        }

        scan.nextLine();
    }

    static String binary(long nim, int low, int high) {
        String pesan = "error";

        if(low <= high) {
            int middle = low + ((high - low) / 2);

            if(nim == mahasiswa[middle].getNim()) {
                return mahasiswa[middle].getNama();
            } else if(nim < mahasiswa[middle].getNim()) {
                pesan = binary(nim, low, (middle - 1));
            } else {
                pesan = binary(nim, (middle + 1), high);
            }
        }

        return pesan;
    }

    static long formCari() {
        Scanner scan = new Scanner(System.in);
        long nim;

        System.out.print("\nNIM : ");
        nim = scan.nextLong();
        scan.nextLine();

        return nim;
    }

    static String linear(long nim) {
        String pesan = "error";

        for(int i = 0; i < jumData; i++) {
            if(nim == mahasiswa[i].getNim()) {
                return mahasiswa[i].getNama();
            }
        }

         return pesan;
    }

    static void edit() {
        Scanner scan = new Scanner(System.in);
        int pilihan;
        long nim;
        String nama;

        System.out.print("\nPilihan : ");
        pilihan = scan.nextInt();
        scan.nextLine();

        System.out.print("\nNIM : ");
        nim = scan.nextLong();
        scan.nextLine();
        System.out.print("Nama : ");
        nama = scan.nextLine();

        mahasiswa[pilihan - 1].setNim(nim);
        mahasiswa[pilihan - 1].setNama(nama);

        System.out.println();
    }

    static void hapus() {
        Scanner scan = new Scanner(System.in);
        int pilihan;

        System.out.print("\nPilihan : ");
        pilihan = scan.nextInt();
        scan.nextLine();

        for(int i = pilihan; i < jumData; i++) {
            mahasiswa[pilihan - 1].setNim(mahasiswa[pilihan].getNim());
            mahasiswa[pilihan - 1].setNama(mahasiswa[pilihan].getNama());
        }

        jumData -= 1;
        System.out.println();
    }

    static String uas() {
        int jarak = jumData;
        int susut = 13;
        int urut = 0;
        String pesan = "Tidak ada Data!";
        Mahasiswa temp;

        if(jumData != 0) {
            do {
                jarak = (jarak * 10) / susut;

                if(jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                } 

                for(int i = 0; (i + jarak) < jumData; i++) {
                    if(mahasiswa[i].getNim() > mahasiswa[i + jarak].getNim()) {
                        swap(i, (i + jarak));
                        urut = 0;
                    }
                }
            } while(urut == 0);
        } else {
            return pesan;
        }

        pesan = "Data telah diurutkan, silakan tampilkan data!";
        return pesan;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        String pesan;

        do {
            System.out.println("===Menu Siakad===");
            System.out.println("1. Tambah data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Urutkan data");
            System.out.println("4. Cari data");
            System.out.println("5. Edit data");
            System.out.println("6. Hapus data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
            System.out.print("\nPilihan : ");
            menu = scan.nextInt();
            scan.nextLine();

            if(menu == 1) {
                tambah();
            } else if(menu == 2) {
                System.out.println("\n===Tampilkan Data===");
                tampilkan();
                scan.nextLine();
            } else if(menu == 3) {
                urutkan();
                System.out.println("\n===Tampilkan Data===");
                tampilkan();
                scan.nextLine();
            } else if(menu == 4) {
                exchangeSort();
                cari();
            } else if(menu == 5) {
                System.out.println("\n===Edit Data===");
                tampilkan();
                edit();
            } else if(menu == 6) {
                System.out.println("\n===Hapus Data===");
                tampilkan();
                hapus();
                System.out.println("\n===Tampilkan Data===");
                tampilkan();
                scan.nextLine();
            } else if(menu == 7) {
                pesan = uas();
                System.out.println("\n" + pesan);
                scan.nextLine();
            }
        } while (menu != 8);
    }
}
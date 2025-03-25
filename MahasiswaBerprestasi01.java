import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MahasiswaBerprestasi01 {
    ArrayList<Mahasiswa01> listMhs = new ArrayList<>();

    void tambah(Mahasiswa01 mhs) {
        listMhs.add(mhs);
    }

    void tampil() {
        for (Mahasiswa01 mhs : listMhs) {
            mhs.tampilInformasi();
        }
    }

    void sortByIPK() {
        Collections.sort(listMhs, Comparator.comparingDouble(Mahasiswa01::getIpk));
    }

    int findBinarySearch(double cari, int left, int right) {
        if (right >= left) {
            int mid = (left + right) / 2;

            if (cari == listMhs.get(mid).getIpk()) {
                return mid;
            } else if (listMhs.get(mid).getIpk() > cari) {
                return findBinarySearch(cari, left, mid - 1);
            } else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }

    int sequentialSearch(double cari) {
        for (int i = 0; i < listMhs.size(); i++) {
            if (listMhs.get(i).getIpk() == cari) {
                return i;
            }
        }
        return -1;
    }

    void tampilPosisi(double cari, int posisi) {
        if (posisi != -1) {
            System.out.println("Mahasiswa dengan IPK " + cari + " ditemukan pada indeks: " + posisi);
        } else {
            System.out.println("Mahasiswa dengan IPK " + cari + " tidak ditemukan.");
        }
    }

    void tampilDataSearch(int posisi) {
        if (posisi != -1) {
            System.out.println("\nData Mahasiswa yang ditemukan:");
            listMhs.get(posisi).tampilInformasi();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MahasiswaBerprestasi01 list = new MahasiswaBerprestasi01();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            list.tambah(new Mahasiswa01(nim, nama, kelas, ipk));
            System.out.println("------------------------------");
        }

        
        list.sortByIPK();

        System.out.println("\nData Mahasiswa setelah diurutkan berdasarkan IPK:");
        list.tampil();

        System.out.print("\nMasukkan IPK mahasiswa yang ingin dicari: ");
        double cari = sc.nextDouble();
        int posisi = list.findBinarySearch(cari, 0, list.listMhs.size() - 1);

        list.tampilPosisi(cari, posisi);
        list.tampilDataSearch(posisi);
    }
}

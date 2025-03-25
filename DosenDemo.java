import java.util.Scanner;

public class DosenDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen01 data = new DataDosen01();

       
        data.tambahDosen(new Dosen01("12345", "Dr. Andi", 45, "Teknik"));
        data.tambahDosen(new Dosen01("67890", "Prof. Budi", 50, "Ekonomi"));
        data.tambahDosen(new Dosen01("11121", "Dr. Andi", 35, "Kedokteran"));
        data.tambahDosen(new Dosen01("14151", "Dr. Citra", 45, "Sastra"));

        System.out.println("Data Dosen:");
        data.tampilkanSemua();

       
        System.out.print("\nMasukkan nama dosen yang ingin dicari: ");
        String cariNama = sc.nextLine();
        data.pencarianDataSequential(cariNama);

       
        System.out.print("\nMasukkan usia dosen yang ingin dicari: ");
        int cariUsia = sc.nextInt();
        data.pencarianDataBinary(cariUsia);
    }
}

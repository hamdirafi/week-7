import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class DataDosen01 {
    ArrayList<Dosen01> listDosen = new ArrayList<>();

    void tambahDosen(Dosen01 dosen) {
        listDosen.add(dosen);
    }

    void tampilkanSemua() {
        for (Dosen01 dosen : listDosen) {
            dosen.tampilInformasi();
        }
    }

    
    void pencarianDataSequential(String cariNama) {
        ArrayList<Dosen01> hasil = new ArrayList<>();
        for (Dosen01 dosen : listDosen) {
            if (dosen.getNama().equalsIgnoreCase(cariNama)) {
                hasil.add(dosen);
            }
        }

        if (hasil.isEmpty()) {
            System.out.println("Dosen dengan nama '" + cariNama + "' tidak ditemukan.");
        } else {
            System.out.println("\nDosen dengan nama '" + cariNama + "' ditemukan:");
            for (Dosen01 dosen : hasil) {
                dosen.tampilInformasi();
            }
            if (hasil.size() > 1) {
                System.out.println("⚠ Peringatan: Terdapat lebih dari satu hasil dengan nama yang sama!");
            }
        }
    }

    
    void pencarianDataBinary(int cariUsia) {
        Collections.sort(listDosen, Comparator.comparingInt(Dosen01::getUsia));

        int left = 0, right = listDosen.size() - 1;
        ArrayList<Dosen01> hasil = new ArrayList<>();

        while (left <= right) {
            int mid = (left + right) / 2;

            if (listDosen.get(mid).getUsia() == cariUsia) {
                hasil.add(listDosen.get(mid));

                
                int i = mid - 1;
                while (i >= 0 && listDosen.get(i).getUsia() == cariUsia) {
                    hasil.add(listDosen.get(i));
                    i--;
                }

                int j = mid + 1;
                while (j < listDosen.size() && listDosen.get(j).getUsia() == cariUsia) {
                    hasil.add(listDosen.get(j));
                    j++;
                }
                break;
            } else if (listDosen.get(mid).getUsia() > cariUsia) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (hasil.isEmpty()) {
            System.out.println("Dosen dengan usia " + cariUsia + " tahun tidak ditemukan.");
        } else {
            System.out.println("\nDosen dengan usia " + cariUsia + " tahun ditemukan:");
            for (Dosen01 dosen : hasil) {
                dosen.tampilInformasi();
            }
            if (hasil.size() > 1) {
                System.out.println("⚠ Peringatan: Terdapat lebih dari satu hasil dengan usia yang sama!");
            }
        }
    }
}

class Dosen01 {
    String nidn, nama, fakultas;
    int usia;

    Dosen01(String nidn, String nama, int usia, String fakultas) {
        this.nidn = nidn;
        this.nama = nama;
        this.usia = usia;
        this.fakultas = fakultas;
    }

    void tampilInformasi() {
        System.out.println("NIDN    : " + nidn);
        System.out.println("Nama    : " + nama);
        System.out.println("Usia    : " + usia);
        System.out.println("Fakultas: " + fakultas);
        System.out.println("------------------------------");
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }
}

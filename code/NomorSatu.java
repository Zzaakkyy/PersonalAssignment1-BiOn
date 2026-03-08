class Mahasiswa1 {
// Atribut
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;
// Constructor
    public Mahasiswa1(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }
// Method untuk menampilkan informasi mahasiswa
public void tampilkanInfo() {
    System.out.println("Nama: " + nama);
    System.out.println("NIM: " + nim);
    System.out.println("Jurusan: " + jurusan);
    System.out.println("IPK: " + ipk);
}

}

// Main class
public class NomorSatu {
    // Main method
   public static void main(String[] args) {
        System.out.println("==== Data Mahasiswa1 ====");
        
        // Membuat array daftarMahasiswa 
        Mahasiswa1[] daftarMahasiswa = {
            // Mengisi array dengan 5 objek mahasiswa
            new Mahasiswa1("Andi", "123456", "Teknik Informatika", 3.5),
            new Mahasiswa1("Budi", "123457", "Teknik Informatika", 3.9),
            new Mahasiswa1("Citra", "123458", "Teknik Informatika", 3.7),
            new Mahasiswa1("Dewi", "123459", "Teknik Informatika", 3.8),
            new Mahasiswa1("Eka", "123460", "Teknik Informatika", 3.6)
        };
        
        // LOOP untuk menampilkan data dari array dataMahasiswa
        for (Mahasiswa1 m : daftarMahasiswa) {
            m.tampilkanInfo();  // Memanggil method tampilkanInfo untuk setiap mahasiswa
            System.out.println(); // Baris kosong untuk pemisah antar mahasiswa
        }
    }
}
    
        
    

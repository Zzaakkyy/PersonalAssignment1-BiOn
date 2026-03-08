import java.util.Scanner;

class Mahasiswa3 {

// Atribut
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

// Constructor
    public Mahasiswa3(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        setIpk(ipk); // Setter untuk validasi IPK
    }

 
// Method getter untuk mengakses atribut 
    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getJurusan() { return jurusan; }
    public double getIpk() { return ipk; }

// Method setter untuk mengatur nilai IPK dengan validasi
    public void setIpk(double ipk) {
        if (ipk >= 0.0 && ipk <= 4.0) {
            this.ipk = ipk;
        } else {
            System.out.println("IPK " + ipk + " tidak valid! Harus 0.0 - 4.0");
            System.out.println("IPK Gagal dirubah. Nilai IPK tetap: " + this.ipk);// Menampilkan pesan error dan mempertahankan nilai IPK sebelumnya
        }
    }

    public void updateIpk(double ipkBaru) {
        double ipkLama = this.ipk;
        setIpk(ipkBaru);
        if (this.ipk != ipkLama) {
            System.out.println("IPK berhasil diperbarui dari " + ipkLama + " menjadi " + this.ipk);
        } else {
            System.out.println("IPK tetap: " + this.ipk);
        }
    }

// Method untuk mengecek kelulusan berdasarkan IPK
    public void cekKelulusan() { 
        if (ipk >= 3.0) {
            System.out.println("Status: Lulus");
        } else {
            System.out.println("Status: Belum Lulus");
        }
    }

// Method untuk menghitung predikat berdasarkan IPK
    public void hitungPredikat() {
        String predikat;
        if (ipk >= 3.75) {
            predikat = "Dengan Pujian";
        } else if (ipk >= 3.50) {      // 3.50 ≤ IPK < 3.75
            predikat = "Sangat Memuaskan";
        } else if (ipk >= 3.00) {      // 3.00 ≤ IPK < 3.50
            predikat = "Memuaskan";
        } else {                        // IPK < 3.00
            predikat = "Perlu Perbaikan";
        }
        System.out.println("Predikat: " + predikat);
    }

// Method untuk menampilkan informasi mahasiswa
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);
        cekKelulusan();
        hitungPredikat();
    }

}

// Main class
public class NomorTiga {
// Method untuk mencari mahasiswa berdasarkan NIM
    public static Mahasiswa3 cariMahasiswaByNim(Mahasiswa3[] daftar, String nimCari) {
        for (Mahasiswa3 m : daftar) {
            if (m.getNim().equals(nimCari)) {
                return m; // Mahasiswa ditemukan
            } 
        }
        return null; // Mahasiswa tidak ditemukan
    } 

// Method untuk menampilkan semua data mahasiswa
    public static void tampilkanSemuaData(Mahasiswa3[] daftar) {
        for (Mahasiswa3 m : daftar) {
            m.tampilkanInfo();
            System.out.println(); 
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
// Membuat array daftarMahasiswa 
        Mahasiswa3[] daftarMahasiswa = {
            // Mengisi array dengan 5 objek Mahasiswa
            new Mahasiswa3("Andi", "123456", "Teknik Informatika", 3.5),
            new Mahasiswa3("Budi", "123457", "Teknik Informatika", 3.9),
            new Mahasiswa3("Citra", "123458", "Teknik Informatika", 3.7),
            new Mahasiswa3("Dewi", "123459", "Teknik Informatika", 3.8),
            new Mahasiswa3("Eka", "123460", "Teknik Informatika", 3.6)
        };

// Menampilkan semua data mahasiswa sebelum dirubah
        System.out.println("Data Mahasiswa Sebelum Update IPK");
        tampilkanSemuaData(daftarMahasiswa);

// Meminta input NIM dan IPK baru untuk update
        System.out.print("Update IPK Mahasiswa\n");
        System.out.print("Masukkan NIM Mahasiswa yang ingin diupdate: ");
        String nimInput = scanner.nextLine();

//Cari mahasiswa berdasarkan NIM
        Mahasiswa3 mhsDitemukan = cariMahasiswaByNim(daftarMahasiswa, nimInput);

        if (mhsDitemukan != null) {
            System.out.print("Masukkan IPK baru untuk " + mhsDitemukan.getNama() + ": ");
            double ipkBaru = scanner.nextDouble();
            System.out.println();
            mhsDitemukan.updateIpk(ipkBaru);
            System.out.println("Data Mahasiswa Setelah Update IPK");
            mhsDitemukan.tampilkanInfo();
        } else {
            System.out.println("Mahasiswa dengan NIM " + nimInput + " tidak ditemukan.");
            scanner.close();
            return;
        }
    }
}
    
        
    

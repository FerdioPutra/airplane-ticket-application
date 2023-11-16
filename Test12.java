import java.util.Scanner;

class TiketPesawat {
    private String nama;
    private String kotaAsal;
    private String kotaTujuan;
    private double harga;
    private int tanggal;

    public TiketPesawat(String nama, String kotaAsal, String kotaTujuan, int tanggal) {
        this.nama = nama;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.tanggal = tanggal;
        this.harga = hitungHarga(kotaAsal, kotaTujuan);
    }
    private double hitungHarga(String asal, String tujuan) {
        
        // Harga tiket berdasarkan kota asal dan tujuan
  
        if (asal.equals("Palembang") && tujuan.equals("Jakarta")) {
            return 500000.0;
        } else if (asal.equals("Palembang") && tujuan.equals("Surabaya")) {
            return 600000.0;
        } else if (asal.equals("Jakarta") && tujuan.equals("Surabaya")) {
            return 400000.0;
        } else if (asal.equals("Jakarta") && tujuan.equals("Bali")) {
            return 700000.0;
        } else if (asal.equals("Surabaya") && tujuan.equals("Bali")) {
            return 450000.0;
        } else if (asal.equals("Surabaya") && tujuan.equals("Semarang")) {
            return 350000.0;
        } else if (asal.equals("Bali") && tujuan.equals("Semarang")) {
            return 800000.0;
        } else if (asal.equals("Bali") && tujuan.equals("Bandung")) {
            return 750000.0;
        } else if (asal.equals("Semarang") && tujuan.equals("Bandung")) {
            return 300000.0;
        }  else if (asal.equals("Semarang") && tujuan.equals("Surabaya")) {
            return 350000.0;
        }
        else {
            return 0.0; 
        }
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Kota Asal: " + kotaAsal + ", Kota Tujuan: " + kotaTujuan + ", Harga: " + harga + ", Tanggal: " + tanggal;
    }
}

public class Test12 {
    private TiketPesawat[] tiketPesawatArray;
    private int size;

    public Test12(int capacity) {
        tiketPesawatArray = new TiketPesawat[capacity];
        size = 0;
    }

    public void add(String nama, String kotaAsal, String kotaTujuan, int tanggal) {
        if (size < tiketPesawatArray.length) {
            TiketPesawat tiket = new TiketPesawat(nama, kotaAsal, kotaTujuan, tanggal);
            tiketPesawatArray[size] = tiket;
            size++;
            System.out.println("Tiket berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas penuh, tidak dapat menambahkan tiket lagi.");
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                tiketPesawatArray[i] = tiketPesawatArray[i + 1];
            }
            size--;
            System.out.println("Tiket berhasil dihapus.");
        } else {
            System.out.println("Indeks tidak valid, tidak dapat menghapus tiket.");
        }
    }

    public void printTiketPesawat() {
        System.out.println("Daftar Tiket Pesawat:");
        for (int i = 0; i < size; i++) {
            System.out.println("Tiket #" + (i + 1) + ": " + tiketPesawatArray[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Test12 pemesanan = new Test12(5);

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Tambah Tiket");
            System.out.println("2. Hapus Tiket");
            System.out.println("3. Tampilkan Tiket");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1/2/3/4): ");
            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nama: ");
                    String nama = input.nextLine();
                    System.out.print("Pilih Kota Asal (Palembang, Jakarta, Surabaya, Bali, Semarang, Bandung): ");
                    String kotaAsal = input.nextLine();
                    System.out.print("Pilih Kota Tujuan (Palembang, Jakarta, Surabaya, Bali, Semarang, Bandung): ");
                    String kotaTujuan = input.nextLine();
                    System.out.print("Masukkan Tanggal (yyyymmdd): ");
                    int tanggal = input.nextInt();
                    pemesanan.add(nama, kotaAsal, kotaTujuan, tanggal);
                    break;
                case 2:
                    System.out.print("Masukkan nomor tiket yang akan dihapus: ");
                    int index = input.nextInt();
                    pemesanan.remove(index - 1);
                    break;
                case 3:
                    pemesanan.printTiketPesawat();
                    break;
                case 4:
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}

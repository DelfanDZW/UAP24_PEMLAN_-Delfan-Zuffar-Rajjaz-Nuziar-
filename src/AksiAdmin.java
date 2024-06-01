//untuk import alat
import java.util.Map;
import java.util.Scanner;

public class AksiAdmin extends Aksi {
    @Override
    public void tampilanAksi() {
        // Menampilkan opsi aksi yang dapat dilakukan oleh admin.
        System.out.println("Aksi Admin:");
        System.out.println("1. Tambah Film");
        System.out.println("2. Lihat List Film");
        System.out.println("3. Logout");
        System.out.println("4. Tutup Aplikasi");
    }

    @Override
    public void keluar() {
        // Melakukan logout dari akun dan menampilkan pesan konfirmasi.
        Akun.logout();
        System.out.println("Anda telah logout.");
    }

    @Override
    public void tutupAplikasi() {
        // Menutup aplikasi dengan menghentikan program.
        System.out.println("Aplikasi ditutup.");
        System.exit(0);
    }

    @Override
    public void lihatListFilm() {
        // Mengambil daftar film dari kelas Film dan menampilkannya.
        Map<String, Film> films = Film.getFilms();
        if (films.isEmpty()) {
            System.out.println("Tidak ada film yang tersedia.");
        } else {
            for (Film film : films.values()) {
                // Menampilkan detail setiap film yang tersedia.
                System.out.println("Film: " + film.getName() + " - Deskripsi: " + film.getDescription() + " - Harga: " + film.getPrice() + " - Stok: " + film.getStock());
            }
        }
    }

    public void tambahFilm() {
        // Meminta input dari admin untuk menambahkan film baru.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Film: ");
        String name = scanner.nextLine();
        System.out.print("Deskripsi Film: ");
        String description = scanner.nextLine();
        System.out.print("Harga Tiket: ");
        double price = scanner.nextDouble();
        System.out.print("Stok Tiket: ");
        int stock = scanner.nextInt();

        // Memanggil metode dari kelas Film untuk menambahkan film baru.
        Film.addFilm(name, description, price, stock);
    }
}

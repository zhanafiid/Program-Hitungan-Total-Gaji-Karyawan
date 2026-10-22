import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan golongan karyawan (A/B/C): ");
        String golongan = input.nextLine().trim().toUpperCase(Locale.ROOT);

        System.out.print("Masukkan jumlah jam lembur: ");
        if (!input.hasNextInt()) {
            System.out.println("Jam lembur harus berupa bilangan bulat.");
            input.close();
            return;
        }
        int jamLembur = input.nextInt();

        double gajiPokok;
        if (golongan.equals("A")) {
            gajiPokok = 5000000;
        } else if (golongan.equals("B")) {
            gajiPokok = 6500000;
        } else if (golongan.equals("C")) {
            gajiPokok = 9500000;
        } else {
            System.out.println("Golongan tidak valid. Pilih A, B, atau C.");
            input.close();
            return;
        }

        if (jamLembur < 0) {
            System.out.println("Jam lembur tidak boleh negatif.");
            input.close();
            return;
        }

        double persenLembur;
        if (jamLembur == 0) {
            persenLembur = 0.00;
        } else if (jamLembur == 1) {
            persenLembur = 0.30;
        } else if (jamLembur == 2) {
            persenLembur = 0.32;
        } else if (jamLembur == 3) {
            persenLembur = 0.34;
        } else if (jamLembur == 4) {
            persenLembur = 0.36;
        } else {
            persenLembur = 0.38;
        }

        double gajiLembur = gajiPokok * persenLembur;
        double totalPenghasilan = gajiPokok + gajiLembur;

        NumberFormat rupiah = NumberFormat.getNumberInstance(
                Locale.forLanguageTag("id-ID"));
        rupiah.setMaximumFractionDigits(0);

        System.out.println("\n===== HASIL PERHITUNGAN =====");
        System.out.println("Golongan          : " + golongan);
        System.out.println("Gaji pokok        : Rp" + rupiah.format(gajiPokok));
        System.out.println("Jam lembur        : " + jamLembur + " jam");
        System.out.println("Persentase lembur : " + (int)(persenLembur * 100) + "%");
        System.out.println("Gaji lembur       : Rp" + rupiah.format(gajiLembur));
        System.out.println("Total penghasilan : Rp" + rupiah.format(totalPenghasilan));
        input.close();
    }
}

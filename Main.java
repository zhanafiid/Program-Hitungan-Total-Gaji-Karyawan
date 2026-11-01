import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Indeks 0 = A, 1 = B, 2 = C
        int[] gaji = {5_000_000, 6_500_000, 9_500_000};
        // Indeks 0 s.d. 4 untuk lembur 1, 2, 3, 4, dan >= 5 jam
        int[] persenLembur = {30, 32, 34, 36, 38};

        System.out.print("Masukkan golongan karyawan (A/B/C): ");
        String golongan = input.nextLine().trim().toUpperCase(Locale.ROOT);

        int indeksGaji;
        if (golongan.equals("A")) {
            indeksGaji = 0;
        } else if (golongan.equals("B")) {
            indeksGaji = 1;
        } else if (golongan.equals("C")) {
            indeksGaji = 2;
        } else {
            System.out.println("Golongan tidak valid. Gunakan A, B, atau C.");
            input.close();
            return;
        }

        System.out.print("Masukkan jumlah jam lembur: ");
        if (!input.hasNextInt()) {
            System.out.println("Jam lembur harus berupa bilangan bulat.");
            input.close();
            return;
        }
        int jamLembur = input.nextInt();
        if (jamLembur < 0) {
            System.out.println("Jam lembur tidak boleh negatif.");
            input.close();
            return;
        }

        int gajiPokok = gaji[indeksGaji];
        int persen = 0;
        if (jamLembur >= 1 && jamLembur <= 4) {
            persen = persenLembur[jamLembur - 1];
        } else if (jamLembur >= 5) {
            persen = persenLembur[4];
        }

        long gajiLembur = (long) gajiPokok * persen / 100;
        long totalPenghasilan = gajiPokok + gajiLembur;
        NumberFormat rupiah = NumberFormat.getIntegerInstance(
                Locale.forLanguageTag("id-ID"));

        System.out.println("\n===== HASIL PERHITUNGAN GAJI =====");
        System.out.println("Golongan          : " + golongan);
        System.out.println("Gaji pokok        : Rp" + rupiah.format(gajiPokok));
        System.out.println("Jam lembur        : " + jamLembur + " jam");
        System.out.println("Persentase lembur : " + persen + "%");
        System.out.println("Gaji lembur       : Rp" + rupiah.format(gajiLembur));
        System.out.println("Total penghasilan : Rp" + rupiah.format(totalPenghasilan));

        input.close();
    }
}

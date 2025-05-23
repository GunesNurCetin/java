import java.security.SecureRandom;
import java.util.Scanner;

public class SifreUretici {

    private static final String KARAKTERLER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

    public static String sifreUret(int uzunluk) {
        SecureRandom random = new SecureRandom();
        StringBuilder sifre = new StringBuilder(uzunluk);

        for (int i = 0; i < uzunluk; i++) {
            int index = random.nextInt(KARAKTERLER.length());
            sifre.append(KARAKTERLER.charAt(index));
        }

        return sifre.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Şifre uzunluğunu girin: ");
        int uzunluk = scanner.nextInt();

        String rastgeleSifre = sifreUret(uzunluk);
        System.out.println("Rastgele Şifre: " + rastgeleSifre);
    }
}

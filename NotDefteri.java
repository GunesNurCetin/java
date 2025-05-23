
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotDefteri extends JFrame {

    private final JTextArea textArea;
    private final JFileChooser fileChooser;

    public NotDefteri() {
        super("Basit Not Defteri");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        fileChooser = new JFileChooser();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Dosya");
        JMenuItem kaydet = new JMenuItem("Kaydet");
        JMenuItem yukle = new JMenuItem("Aç");

        kaydet.addActionListener(e -> dosyaKaydet());
        yukle.addActionListener(e -> dosyaYukle());

        menu.add(yukle);
        menu.add(kaydet);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void dosyaKaydet() {
        int secim = fileChooser.showSaveDialog(this);
        if (secim == JFileChooser.APPROVE_OPTION) {
            File dosya = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosya))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void dosyaYukle() {
        int secim = fileChooser.showOpenDialog(this);
        if (secim == JFileChooser.APPROVE_OPTION) {
            File dosya = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(dosya))) {
                textArea.read(reader, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NotDefteri().setVisible(true));
    }
}

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CreatePDF {
    public static void main(String[] args) {
        // Tableau de chaînes de caractères
        String[] lines = {
            "Ligne 1 : Bonjour le monde",
            "Ligne 2 : Ceci est un exemple de PDF",
            "Ligne 3 : Créé avec iText en Java"
        };

        // Créer un document
        Document document = new Document();

        try {
            // Initialiser le PdfWriter
            PdfWriter.getInstance(document, new FileOutputStream("example.pdf"));

            // Ouvrir le document
            document.open();

            // Ajouter chaque ligne du tableau dans le PDF
            for (String line : lines) {
                document.add(new Paragraph(line));
            }

            // Fermer le document
            document.close();

            System.out.println("PDF créé avec succès !");
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}

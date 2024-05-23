import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Profile2 extends JFrame {

    private JPanel Profile2Panel;
    private JButton UserDataButton;
    private JButton uploadPhotoButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton SearchButton;
    private JButton BrowseallPhotosButton;
    private JButton BackgroundChangerButton;
    private JButton SignOutButton;
    private JButton FilterCatagoryChanger;
    private JTextField textField6;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel Image1;
    private JLabel Image2;
    private JLabel Image3;
    private JLabel Image4;
    private JLabel Image5;
    private JLabel Image6;
    private JLabel Image7;
    private JLabel Image8;
    private JLabel Image9;
    private JLabel Image10;



    String pathofimage ;
    String pathofimage2 ;
    String pathofimage3 ;
    String pathofimage4 ;
    String pathofimage5 ;
    String pathofimage6 ;
    String pathofimage7 ;
    String pathofimage8 ;
    String pathofimage9 ;
    String pathofimage10 ;




    public Profile2() {
        setContentPane(Profile2Panel);
        setTitle("Gadget GUI app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setVisible(true);


        UserDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Profile2.this, "This is the User's data");
            }
        });

        uploadPhotoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                XMLPhotoWriter.main(null); // Κλήση της main μεθόδου της XMLPhotoWriter κλάσης
            }
        });

        pathofimage = "src/PhotoFolder/KeyBoard.jpg";
        pathofimage2 = "src/PhotoFolder/mouse.jpg";
        pathofimage3 = "src/PhotoFolder/KeyBoard.jpg";
        pathofimage4 = "src/PhotoFolder/mouse.jpg";
        pathofimage5 = "src/PhotoFolder/KeyBoard.jpg";
        pathofimage6 = "src/PhotoFolder/mouse.jpg";
        pathofimage7 = "src/PhotoFolder/KeyBoard.jpg";
        pathofimage8 = "src/PhotoFolder/mouse.jpg";
        pathofimage9 = "src/PhotoFolder/KeyBoard.jpg";
        pathofimage10 = "src/PhotoFolder/mouse.jpg";



        Image1.setIcon(new ImageIcon(pathofimage));

        Image2.setIcon(new ImageIcon(pathofimage2));

        Image3.setIcon(new ImageIcon(pathofimage));

        Image4.setIcon(new ImageIcon(pathofimage2));

        Image5.setIcon(new ImageIcon(pathofimage));

        Image6.setIcon(new ImageIcon(pathofimage2));

        Image7.setIcon(new ImageIcon(pathofimage));

        Image8.setIcon(new ImageIcon(pathofimage2));

        Image9.setIcon(new ImageIcon(pathofimage));

        Image10.setIcon(new ImageIcon(pathofimage2));
    }



    public class XMLPhotoWriter {

        public static void main(String[] args) {
            // Δήλωση των πληροφοριών των φωτογραφιών
            String[] photoPaths = {"src/PhotoFolder/Keyboard.jpg", "photos/photo2.jpg"}; // Πίνακας με τις διαδρομές των φωτογραφιών
            String[][] filters = {{"Filter 1 for photo 1", "Filter 2 for photo 1", "Filter 3 for photo 1", "Filter 4 for photo 1"},
                    {"Filter 1 for photo 2", "Filter 2 for photo 2", "Filter 3 for photo 2", "Filter 4 for photo 2"}}; // Δισδιάστατος πίνακας με τα φίλτρα για κάθε φωτογραφία

            String xmlFilePath = "src/Database1.xml"; // Καθορισμός της διαδρομής για το XML αρχείο

            try {
                writeToXML(photoPaths, filters, xmlFilePath); // Κλήση της συνάρτησης για τη δημιουργία του XML
                System.out.println("Οι πληροφορίες των φωτογραφιών αποθηκεύτηκαν επιτυχώς στο XML.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void writeToXML(String[] photoPaths, String[][] filters, String xmlFilePath) throws ParserConfigurationException, IOException {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Δημιουργία του XML Document
            Document doc = docBuilder.newDocument();

            // Δημιουργία του ριζικού στοιχείου
            Element rootElement = doc.createElement("Photos");
            doc.appendChild(rootElement);

            // Επανάληψη για κάθε φωτογραφία
            for (int i = 0; i < photoPaths.length; i++) {
                // Δημιουργία του στοιχείου φωτογραφίας
                Element photo = createPhotoElement(doc, photoPaths[i], filters[i]);
                rootElement.appendChild(photo);
            }

            // Εγγραφή του περιεχομένου του XML σε αρχείο
            writeXMLToFile(doc, xmlFilePath);
        }

        private static Element createPhotoElement(Document doc, String photoPath, String[] filter) {
            // Δημιουργία του στοιχείου φωτογραφίας
            Element photo = doc.createElement("Photo");

            // Δημιουργία του στοιχείου Path και προσθήκη της διαδρομής της φωτογραφίας
            Element pathElement = doc.createElement("Path");
            pathElement.appendChild(doc.createTextNode(photoPath));
            photo.appendChild(pathElement);

            // Δημιουργία των στοιχείων φίλτρων και προσθήκη των τιμών τους
            for (int i = 0; i < filter.length; i++) {
                Element filterElement = doc.createElement("Filter" + (i + 1)); // Οι αριθμοί των φίλτρων ξεκινούν από 1, οπότε προσθέτουμε 1
                filterElement.appendChild(doc.createTextNode(filter[i]));
                photo.appendChild(filterElement);
            }

            return photo;
        }

        private static void writeXMLToFile(Document doc, String filePath) throws IOException {
            // Εγγραφή του περιεχομένου του XML σε αρχείο
            FileWriter writer = new FileWriter(new File(filePath));
            writer.write(docToString(doc));
            writer.close();
        }

        private static String docToString(Document doc) {
            try {
                // Χρήση ενός Transformer για τη μετατροπή του XML σε κείμενο
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                // Δημιουργία κειμένου από το δέντρο XML
                java.io.StringWriter sw = new java.io.StringWriter();
                StreamResult result = new StreamResult(sw);
                DOMSource source = new DOMSource(doc);
                transformer.transform(source, result);
                return sw.toString();
            } catch (TransformerException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void main(String[] args) {
        new Profile2();
    }


}



//    public class DisplayImageFromXML {
//
//        public static void main(String[] args) throws Exception {
//            // Parse the XML file
//            File xmlFile = new File("images.xml"); // Replace with your XML file name
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(xmlFile);
//
//            // Get the image URL element
//            NodeList imageElements = document.getElementsByTagName("imageUrl");
//            if (imageElements.getLength() > 0) {
//                Element imageElement = (Element) imageElements.item(0);
//                //imageUrl = imageElement.getTextContent();
//            } else {
//                System.out.println("Error: Image URL not found in XML file.");
//                return;
//            }
//
//            // Download and display the image
//            //URL url = new URL(imageUrl);
//            //BufferedImage image = ImageIO.read(url);
//
//            // Display the image (basic example using Swing)
//            JFrame frame = new JFrame("Image from XML");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            //JLabel label = new JLabel(new ImageIcon(image));
//            //frame.add(label);
//            frame.pack();
//            frame.setVisible(true);
//        }
//    } */

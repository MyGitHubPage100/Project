import javax.swing.*;
import java.awt.*;

public class DataBaseManagement extends JFrame {


    private JPanel DataBaseManagmentPanel;
    private JButton ScrapPhotoButton;
    private JButton EditPhotoDetailsButton;
    private JButton ShowMoreButton;
    private JButton closeButton;

    public DataBaseManagement() {
        setContentPane(DataBaseManagmentPanel);
        setTitle("ImageEditor GUI app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new DataBaseManagement();
    }
}

import javax.swing.*;
import java.awt.*;

public class FilterEditor extends JFrame {

    private JPanel ImageEditorPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField1;
    private JButton saveButton;
    private JButton exitButton;

    public FilterEditor() {
        setContentPane(ImageEditorPanel);
        setTitle("ImageEditor GUI app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FilterEditor();
    }
}

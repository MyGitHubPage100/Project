import javax.swing.*;
import java.awt.*;

public class UserData extends JFrame {

    private JPanel UserDataPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;


    public UserData() {
        setContentPane(UserDataPanel);
        setTitle("Profile Data app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setVisible(true);

    }
        public static void main (String[]args){
            new UserData();
        }
    }

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Profile extends JFrame {

    private JButton addNewProfileButton1;
    private JPanel ProfilePanel;
    private JButton addNewProfileButton5;
    private JButton addNewProfileButton2;
    private JButton addNewProfileButton4;
    private JButton addNewProfileButton3;
    private JButton CustomerButton;
    private JButton clickMeButton;

    public Profile(){
        setContentPane(ProfilePanel);
        setTitle("Profiles GUI app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setVisible(true);
        addNewProfileButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Profile.this, "Hello");
            }
        });
    }

    public static void main(String[] args) {
        // Δημιουργία ενός αντικειμένου ProfileEditor
        new Profile();
    }
}

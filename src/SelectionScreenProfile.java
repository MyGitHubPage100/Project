import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class SelectionScreenProfile extends JFrame {
    private JButton SelectionProfileButton6;
    private JPanel SelectionScreenProfilePanel;
    private JButton SelectionProfileButton5;
    private JButton SelectionProfileButton2;
    private JButton SelectionProfileButton4;
    private JButton SelectionProfileButton3;
    private JButton CustomerProfileButton1;
    private JButton clickMeButton;

    public SelectionScreenProfile(){
        setContentPane(SelectionScreenProfilePanel);
        setTitle("Profiles GUI app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setVisible(true);
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SelectionScreenProfile.this, "Hello");
            }
        });
    }

    public static void main(String[] args) {
        // Δημιουργία ενός αντικειμένου ProfileEditor
        new SelectionScreenProfile();
    }
}
import mp.AJPMicro;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class loginmain extends JFrame
        implements ActionListener {
    JLabel userId, password, error;
    JTextField userIdTxt;
    JPasswordField passwordTxt;
    JButton login;

    public loginmain() {
        setLayout(null);
        setTitle("Login");
        userId = new JLabel("User ID");
        password = new JLabel("Password");
        error = new JLabel("");
        userIdTxt = new JTextField();
        passwordTxt = new JPasswordField();
        login = new JButton("Login");
        login.addActionListener(this);
        userId.setBounds(130, 70, 150, 30);
        userIdTxt.setBounds(200, 70, 150, 30);
        password.setBounds(120, 120, 100, 20);
        passwordTxt.setBounds(200, 120, 150, 30);
        login.setBounds(170, 180, 130, 30);
        error.setBounds(30, 150, 300, 20);
        userIdTxt.setToolTipText("Enter User ID");
        passwordTxt.setToolTipText("Enter Password");
        add(userId);
        add(userIdTxt);
        add(password);
        add(passwordTxt);
        add(login);
        add(error);
        setVisible(true);
        setSize(500, 370);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String passCheck = new String(passwordTxt.getPassword());
        if (userIdTxt.getText().equals("gaurav") &&
                passCheck.equals("gaurav")) {
        	new AJPMicro(); 
            error.setText("");
            setVisible(false);
           
        } else {
            error.setForeground(Color.red);
            error.setText("User ID or Password is incorrect!");
        }
    }

    public static void main(String args[]) {
        new loginmain();
    }
}
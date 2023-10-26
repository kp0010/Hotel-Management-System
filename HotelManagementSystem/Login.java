package HotelManagementSystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(550, 250,600,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
//            System.out.println("DONE");
            Conn conn = new Conn();
            char[] passtemp = password.getPassword();
            String pass = new String(passtemp);
            String query = "select * from login where username='" + username.getText() + "' and password = '" + pass + "'";
//            System.out.println(query);
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next() == true) {
                    JOptionPane.showMessageDialog(null, "Logged In Successfully");
                    setVisible(false);
                    new Dashboard();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
}
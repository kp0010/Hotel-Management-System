package HotelManagementSystem;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDrivers extends JFrame implements ActionListener {

    private final JPanel contentPane;
    private final JTextField t1;
    private final JTextField t2;
    private final JTextField t3;
    private final JTextField t4;
    private final JTextField t5;
    private final JComboBox comboBox;
    private final JComboBox comboBox_1;
    JButton b1, b2;

    public AddDrivers() {
        setBounds(450, 250, 1000, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("Assets/icon.png");
        setIconImage(icon);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 370);
        add(l15);

        JLabel l10 = new JLabel("Add Drivers");
        l10.setFont(new Font("Tahoma", Font.BOLD, 20));
        l10.setBounds(130, 20, 120, 22);
        contentPane.add(l10);


        JLabel l1 = new JLabel("Name");
//        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBounds(55, 70, 102, 22);
        contentPane.add(l1);


        t1 = new JTextField();
        t1.setBounds(182, 70, 156, 30);
        contentPane.add(t1);


        JLabel l2 = new JLabel("Age");
//        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(55, 112, 102, 22);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(182, 112, 156, 30);
        contentPane.add(t2);


        JLabel l3 = new JLabel("Gender");
//        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(55, 154, 102, 22);
        contentPane.add(l3);

        comboBox = new JComboBox(new String[]{"Male", "Female"});
        comboBox.setBounds(182, 154, 156, 30);
        comboBox.setBackground(Color.white);
        contentPane.add(comboBox);

        JLabel l4 = new JLabel("Car Company");
//        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(55, 196, 102, 22);
        contentPane.add(l4);

        t3 = new JTextField();
        t3.setBounds(182, 196, 156, 30);
        contentPane.add(t3);

        JLabel l5 = new JLabel("Car Brand");
//        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setBounds(55, 238, 102, 22);
        contentPane.add(l5);


        t4 = new JTextField();
        t4.setBounds(182, 238, 156, 30);
        contentPane.add(t4);


        JLabel l6 = new JLabel("Available");
//        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l6.setBounds(55, 280, 102, 22);
        contentPane.add(l6);


        comboBox_1 = new JComboBox(new String[]{"Available", "Unavailable"});
        comboBox_1.setBounds(182, 280, 156, 30);
        comboBox_1.setBackground(Color.white);
        contentPane.add(comboBox_1);


        JLabel l7 = new JLabel("Location");
//        l7.setForeground(new Color(25, 25, 112));
        l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l7.setBounds(55, 322, 102, 22);
        contentPane.add(l7);


        t5 = new JTextField();
        t5.setBounds(182, 322, 156, 30);
        contentPane.add(t5);


        b1 = new JButton("Add Drivers");
        b1.addActionListener(this);
        b1.setBounds(52, 394, 130, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBounds(207, 394, 130, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        contentPane.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                try {
                    Conn c = new Conn();
                    String name = t1.getText();
                    String age = t2.getText();
                    String gender = (String) comboBox.getSelectedItem();
                    String company = t3.getText();
                    String brand = t4.getText();
                    String available = (String) comboBox_1.getSelectedItem();
                    String location = t5.getText();
                    String str = "INSERT INTO driver VALUES ( '" + name + "', '" + age + "', '" + gender + "','" + company + "', '" + brand + "', '" + available + "','" + location + "')";


                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            } else if (ae.getSource() == b2) {
                this.setVisible(false);
            }
        } catch (Exception eee) {
            eee.printStackTrace();
        }
    }
}
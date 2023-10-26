package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployees extends JFrame {
    JTextField nametxt, agetxt, textField_2, salarytxt, phonetxt, aadhartxt, emailtxt;
    JComboBox c1;

    public AddEmployees() {
        getContentPane().setForeground(Color.BLACK);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");

        Image icon = Toolkit.getDefaultToolkit().getImage("Assets/icon.png");
        setIconImage(icon);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel Passportno = new JLabel("NAME");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(60, 30, 150, 27);
        add(Passportno);

        nametxt = new JTextField();
        nametxt.setBounds(200, 30, 150, 27);
        add(nametxt);

        JButton Next = new JButton("Add Employee");
        Next.setBounds(55, 420, 130, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);

        JButton cancelbtn = new JButton("Cancel");
        cancelbtn.setForeground(Color.white);
        cancelbtn.setBackground(Color.black);
        cancelbtn.setBounds(220, 420, 130, 30);
        add(cancelbtn);

        JLabel Pnrno = new JLabel("AGE");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 80, 150, 27);
        add(Pnrno);

        agetxt = new JTextField();
        agetxt.setBounds(200, 80, 150, 27);
        add(agetxt);

        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 125, 150, 27);
        add(Gender);

        JRadioButton maleradio = new JRadioButton("MALE");
        maleradio.setBackground(Color.WHITE);
        maleradio.setBounds(200, 125, 70, 27);
        add(maleradio);

        JRadioButton femaleradio = new JRadioButton("FEMALE");
        femaleradio.setBackground(Color.WHITE);
        femaleradio.setBounds(280, 125, 70, 27);
        add(femaleradio);


        JLabel Address = new JLabel("JOB");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        String[] course = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 170, 150, 30);
        add(c1);

        JLabel Nationality = new JLabel("SALARY");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        salarytxt = new JTextField();
        salarytxt.setBounds(200, 220, 150, 27);
        add(salarytxt);

        JLabel Name = new JLabel("PHONE");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        phonetxt = new JTextField();
        phonetxt.setBounds(200, 270, 150, 27);
        add(phonetxt);

        JLabel Phno = new JLabel("AADHAR");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phno.setBounds(60, 320, 150, 27);
        add(Phno);

        aadhartxt = new JTextField();
        aadhartxt.setBounds(200, 320, 150, 27);
        add(aadhartxt);

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        emailtxt = new JTextField();
        emailtxt.setBounds(200, 370, 150, 27);
        add(emailtxt);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.BLACK);
        AddPassengers.setFont(new Font("Tahoma", Font.BOLD, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        add(image);


        Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = nametxt.getText();
                String age = agetxt.getText();
                String salary = salarytxt.getText();
                String phone = phonetxt.getText();
                String aadhar = aadhartxt.getText();
                String email = emailtxt.getText();

                String gender = null;

                if (maleradio.isSelected()) {
                    gender = "Male";

                } else if (femaleradio.isSelected()) {
                    gender = "Female";
                }


                String s6 = (String) c1.getSelectedItem();

                try {
                    Conn c = new Conn();
                    String query = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + s6 + "', '" + salary + "', '" + phone + "','" + aadhar + "', '" + email + "')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cancelbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setSize(900, 530);
        setVisible(true);
        setLocation(530, 250);

    }

    public static void main(String[] args) {
        new AddEmployees();
    }
}
package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

public class AddCustomers extends JFrame implements ActionListener {

    JComboBox comboId;
    JTextField tfNumber, tfName, tfCountry, tfDeposit;
    JRadioButton radioGenderMale, radioGenderFemale;
    Choice chRoom;
    JLabel lblCheckInTime;
    JButton btnAdd, btnCancel;

    AddCustomers() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(80, 20, 300, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(35, 80, 100, 20);
        lblName.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 80, 150, 25);
        add(tfName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(35, 120, 100, 20);
        lblGender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblGender);

        radioGenderMale = new JRadioButton("Male");
        radioGenderMale.setBackground(Color.white);
        radioGenderMale.setBounds(200, 120, 80, 25);
        add(radioGenderMale);

        radioGenderFemale = new JRadioButton("Female");
        radioGenderFemale.setBackground(Color.white);
        radioGenderFemale.setBounds(280, 120, 80, 25);
        add(radioGenderFemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioGenderFemale);
        genderGroup.add(radioGenderMale);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(35, 160, 100, 20);
        lblId.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblId);

        String[] options = {"Aadhar Card", "Passport", "Driving License", "Voted-ID Card", "Ration Card"};
        comboId = new JComboBox(options);
        comboId.setBackground(Color.white);
        comboId.setBounds(200, 160, 150, 25);
        add(comboId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(35, 200, 100, 20);
        lblNumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200, 200, 150, 25);
        add(tfNumber);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(35, 240, 100, 20);
        lblCountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200, 240, 150, 25);
        add(tfCountry);

        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(35, 280, 150, 20);
        lblRoom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblRoom);

        chRoom = new Choice();

        try {
            Conn conn = new Conn();
            String roomq = "SELECT * From room WHERE availability = 'Available'";
            ResultSet response = conn.s.executeQuery(roomq);

            while (response.next()) {
                chRoom.add(response.getString("roomNumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        chRoom.setBounds(200, 280, 150, 25);
        add(chRoom);

        JLabel lblTime = new JLabel("Check-in Time");
        lblTime.setBounds(35, 320, 150, 20);
        lblTime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblTime);

        Date curr_date = new Date();

        lblCheckInTime = new JLabel("" + curr_date);
        lblCheckInTime.setBounds(195, 320, 200, 20);
        lblCheckInTime.setFont(new Font("Raleway", Font.PLAIN, 12));
        add(lblCheckInTime);

        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setBounds(35, 360, 100, 20);
        lblDeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblDeposit);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200, 360, 150, 25);
        add(tfDeposit);

        btnAdd = new JButton("Add");
        btnAdd.setBackground(Color.black);
        btnAdd.setForeground(Color.white);
        btnAdd.setBounds(40, 430, 120, 35);
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.black);
        btnCancel.setForeground(Color.white);
        btnCancel.setBounds(220, 430, 120, 35);
        btnCancel.addActionListener(this);
        add(btnCancel);

        ImageIcon posterImg = new ImageIcon(ClassLoader.getSystemResource("Assets/fifth.png"));
        Image img = posterImg.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
        ImageIcon posterImg2 = new ImageIcon(img);
        JLabel finalImage = new JLabel(posterImg2);
        finalImage.setBounds(400, 50, 300,400);
        add(finalImage);

        setBounds(550, 250, 800, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            String id = (String) comboId.getSelectedItem();
            String number = tfNumber.getText();
            String name = tfName.getText();
            String country = tfCountry.getText();
            String roomNumber = chRoom.getSelectedItem();
            String time = lblCheckInTime.getText();
            String deposit = tfDeposit.getText();
            String gender = null;

            if (radioGenderMale.isSelected()) {
                gender = "Male";
            } else if (radioGenderFemale.isSelected()) {
                gender = "Female";
            }

            try {
                String query = "INSERT INTO customer VALUES('" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + roomNumber + "', '" + time + "', '" + deposit +"')";
                String query2 = "UPDATE room SET availability = 'Occupied' WHERE roomNumber = '" + roomNumber + "'";
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == btnCancel) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomers();
    }

}

package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//Todo: Uncomment out the Conn declaration and Method used after making conn class
public class AddRooms extends JFrame implements ActionListener {

    JButton addRoomsbtn, cancelbtn;
    JTextField tfroom, tfRoomPrice;
    JComboBox bedTypeCombo, availableCombo, cleaningStatusCombo;

    AddRooms() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //Labels
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        JLabel lblRoomNumber = new JLabel("Room Number");
        lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRoomNumber.setBounds(60, 80, 120, 30);
        add(lblRoomNumber);

        JLabel lblAvailable = new JLabel("Availability");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAvailable.setBounds(60, 130, 120, 30);
        add(lblAvailable);

        JLabel lblCleaningStatus = new JLabel("Cleaning Status");
        lblCleaningStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCleaningStatus.setBounds(60, 180, 120, 30);
        add(lblCleaningStatus);

        JLabel lblRoomPrice = new JLabel("Price");
        lblRoomPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRoomPrice.setBounds(60, 230, 120, 30);
        add(lblRoomPrice);

        JLabel lblBedType = new JLabel("Bed Type");
        lblBedType.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBedType.setBounds(60, 280, 120, 30);
        add(lblBedType);


        //TextFields
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        tfRoomPrice = new JTextField();
        tfRoomPrice.setBounds(200, 230, 150, 30);
        add(tfRoomPrice);
        tfRoomPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((((ke.getKeyChar() >= '0') && (ke.getKeyChar() <= '9'))) || ((ke.getKeyChar() == KeyEvent.VK_PERIOD))) {
                    tfRoomPrice.setEditable(true);
                } else {
                    tfRoomPrice.setEditable(false);
                }
            }
        });


        //Combos
        String[] availableOptions = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130, 150, 30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);

        String[] cleaningStatusOptions = {"Cleaned", "Dirty"};
        cleaningStatusCombo = new JComboBox(cleaningStatusOptions);
        cleaningStatusCombo.setBounds(200, 180, 150, 30);
        cleaningStatusCombo.setBackground(Color.white);
        add(cleaningStatusCombo);

        String[] bedTypeOptions = {"Single Bed", "Double Bed"};
        bedTypeCombo = new JComboBox(bedTypeOptions);
        bedTypeCombo.setBounds(200, 280, 150, 30);
        bedTypeCombo.setBackground(Color.white);
        add(bedTypeCombo);


        //Buttons
        addRoomsbtn = new JButton("Add Room");
        addRoomsbtn.setForeground(Color.white);
        addRoomsbtn.setBackground(Color.black);
        addRoomsbtn.setBounds(60, 350, 130, 30);
        addRoomsbtn.addActionListener(this);
        add(addRoomsbtn);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setForeground(Color.white);
        cancelbtn.setBackground(Color.black);
        cancelbtn.setBounds(220, 350, 130, 30);
        cancelbtn.addActionListener(this);
        add(cancelbtn);


        //Image
        ImageIcon posterimg = new ImageIcon(ClassLoader.getSystemResource("Assets/twelve.jpg"));
        JLabel posterlbl = new JLabel(posterimg);
        posterlbl.setBounds(400, 60, 500, 300);
        add(posterlbl);

        setBounds(550, 250, 940, 470);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addRoomsbtn) {
            String roomNumber = tfroom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String cleaningStatus = (String) cleaningStatusCombo.getSelectedItem();
            String roomPrice = tfRoomPrice.getText();
            String bedType = (String) bedTypeCombo.getSelectedItem();

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO room values('" + roomNumber + "', '" + availability + "', '" + cleaningStatus + "', '" + roomPrice + "', '" + bedType + "')";
//                System.out.println(query);
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "New Room Added Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }

}

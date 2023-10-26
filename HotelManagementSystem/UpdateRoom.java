package HotelManagementSystem;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame {
    private JTextField txt_ID;
    private JTextField txt_Room;

    JComboBox cleaningStatusCombo, availableCombo;
    Choice c1;

    public static void main(String[] args) {
        try {
            new UpdateRoom();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void close(){
        this.dispose();
    }

    public UpdateRoom() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 270, 1000, 450);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("Assets/icon.png");
        setIconImage(icon);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Assets/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(375,70,600,250);
        add(l1);

        JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
        lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUpdateRoomStatus.setBounds(85, 11, 250, 34);
        add(lblUpdateRoomStatus);

        JLabel lblNewLabel = new JLabel("Guest ID");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(60, 80, 90, 30);
        add(lblNewLabel);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c1.setBounds(200, 80, 140, 30);
        add(c1);

        JLabel lblRoomId = new JLabel("Room Number");
        lblRoomId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblRoomId.setBounds(60, 135, 130, 30);
        add(lblRoomId);

        JLabel lblAvailability = new JLabel("Availability");
        lblAvailability.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAvailability.setBounds(60, 190, 90, 30);
        add(lblAvailability);

        JLabel lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCleanStatus.setBounds(60, 245, 90, 30);
        add(lblCleanStatus);

        txt_Room = new JTextField();
        txt_Room.setBounds(200, 135, 140, 30);
        add(txt_Room);
        txt_Room.setColumns(10);

//        txt_Available = new JTextField();
//        txt_Available.setBounds(200, 190, 140, 30);
//        add(txt_Available);
//        txt_Available.setColumns(10);

        String[] cleaningStatusOptions = {"Cleaned", "Dirty"};
        cleaningStatusCombo = new JComboBox(cleaningStatusOptions);
        cleaningStatusCombo.setBounds(200, 245, 140, 30);
        cleaningStatusCombo.setBackground(Color.white);
        add(cleaningStatusCombo);

        String[] availableOptions = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 190, 140, 30);
        availableCombo.setBackground(Color.white);
        add(availableCombo);

        JButton btnCheck = new JButton("Check");
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String s1 = c1.getSelectedItem();
                    Conn c = new Conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where number = "+s1);

                    while(rs1.next()){
                        txt_Room.setText(rs1.getString("roomNumber"));
                    }
                }catch(Exception ee){ee.printStackTrace();}
                try{
                    Conn c  = new Conn();
                    ResultSet rs2 = c.s.executeQuery("select * from room where roomNumber = "+txt_Room.getText());
                    while(rs2.next()){
                        availableCombo.setSelectedItem(rs2.getString("availability"));
                        cleaningStatusCombo.setSelectedItem(rs2.getString("cleaningStatus"));
                    }
                }catch(Exception ee){ee.printStackTrace();}
            }
        });
        btnCheck.setBounds(50, 305, 140, 35);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        add(btnCheck);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws NumberFormatException {

                try{
                    Conn c = new Conn();
                    String str = "update room set cleaningStatus= '"+ cleaningStatusCombo.getSelectedItem() +"' where roomNumber = "+ txt_Room.getText();
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Update Sucessful");

                    new Reception().setVisible(true);
                    setVisible(false);
                }catch (Exception ee){
                    ee.printStackTrace();
                }


            }
        });
        btnUpdate.setBounds(210, 305, 140, 35);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        add(btnUpdate);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(50, 355, 300, 35);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);


        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

}
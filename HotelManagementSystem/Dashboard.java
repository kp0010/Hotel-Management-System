package HotelManagementSystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Dashboard extends JFrame {

    public Dashboard dash = null;

    public static void main(String[] args) {
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
    }

    public Dashboard() {

        super("BLUE HORIZON MANAGEMENT");

        dash = this;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setUndecorated(true);

        Image icon = Toolkit.getDefaultToolkit().getImage("Assets/Icon.png");
        setIconImage(icon);

        setExtendedState(MAXIMIZED_BOTH);
        setForeground(Color.CYAN);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/Dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000);
        add(NewLabel);

        JLabel greetinglbl = new JLabel("WELCOME TO THE BLUE HORIZON SUITES");
        greetinglbl.setForeground(Color.WHITE);
        greetinglbl.setFont(new Font("SansSerif", Font.BOLD, 51));
        greetinglbl.setBounds(450, 100, 1500, 85);
        NewLabel.add(greetinglbl);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu hotelsystem = new JMenu("HOTEL MANAGEMENT");
        hotelsystem.setForeground(Color.BLACK);
        menuBar.add(hotelsystem);

        JMenuItem reception = new JMenuItem("RECEPTION");
        hotelsystem.add(reception);

        JMenu adminmenu = new JMenu("ADMIN");
        adminmenu.setForeground(Color.BLACK);
        menuBar.add(adminmenu);

        JMenuItem emp = new JMenuItem("ADD EMPLOYEE");
        adminmenu.add(emp);

        emp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddEmployees().setVisible(true);
                } catch (Exception e) {
                }
            }
        });


        JMenuItem rooms = new JMenuItem("ADD ROOMS");
        adminmenu.add(rooms);

        rooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddRooms().setVisible(true);
                } catch (Exception e) {
                }
            }
        });


        reception.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Reception(dash);
            }
        });


        JMenuItem FlightDetailshello3 = new JMenuItem("ADD DRIVERS");
        adminmenu.add(FlightDetailshello3);

        FlightDetailshello3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddDrivers().setVisible(true);
                } catch (Exception e) {
                }
            }
        });


        setSize(1950, 1090);
        setVisible(true);
        setLocation(-10, 0);
        getContentPane().setBackground(Color.WHITE);
    }
}
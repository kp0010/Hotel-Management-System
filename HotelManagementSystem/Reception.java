package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Reception extends JFrame implements ActionListener {

  JButton newCustomer, rooms, department, allEmployee, customers, managerInfo, checkout, update, roomStatus, pickup, searchRoom, logout;

  Reception()  {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    newCustomer = new JButton("New Customer Forms");
    newCustomer.setBounds(10, 30, 200, 30);
    newCustomer.setBackground(Color.BLACK);
    newCustomer.setForeground(Color.WHITE);
    newCustomer.addActionListener(this);
    add(newCustomer);

    rooms = new JButton("Rooms");
    rooms.setBounds(10, 70, 200, 30);
    rooms.setBackground(Color.BLACK);
    rooms.setForeground(Color.WHITE);
    add(rooms);
     
    department = new JButton("Department");
    department.setBounds(10, 110, 200, 30);
    department.setBackground(Color.BLACK);
    department.setForeground(Color.WHITE);
    add(department);

    allEmployee = new JButton("All Employees");
    allEmployee.setBounds(10, 150, 200, 30);
    allEmployee.setBackground(Color.BLACK);
    allEmployee.setForeground(Color.WHITE);
    add(allEmployee);

    customers = new JButton("Customer Info");
    customers.setBounds(10, 190, 200, 30);
    customers.setBackground(Color.BLACK);
    customers.setForeground(Color.WHITE);
    add(customers);

    managerInfo = new JButton("Manager Info");
    managerInfo.setBounds(10, 230, 200, 30);
    managerInfo.setBackground(Color.BLACK);
    managerInfo.setForeground(Color.WHITE);
    add(managerInfo);

    checkout = new JButton("Checkout");
    checkout.setBounds(10, 270, 200, 30);
    checkout.setBackground(Color.BLACK);
    checkout.setForeground(Color.WHITE);
    add(checkout);

    update = new JButton("Update Status");
    update.setBounds(10, 310, 200, 30);
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.addActionListener(this);
    add(update);

    roomStatus = new JButton("Update Room Status");
    roomStatus.setBounds(10, 350, 200, 30);
    roomStatus.setBackground(Color.BLACK);
    roomStatus.setForeground(Color.WHITE);
    roomStatus.addActionListener(this);
    add(roomStatus);

    pickup = new JButton("Pickup Service");
    pickup.setBounds(10, 390, 200, 30);
    pickup.setBackground(Color.BLACK);
    pickup.setForeground(Color.WHITE);
    add(pickup);

    searchRoom = new JButton("Search Room");
    searchRoom.setBounds(10, 430, 200, 30);
    searchRoom.setBackground(Color.BLACK);
    searchRoom.setForeground(Color.WHITE);
    searchRoom.addActionListener(this);
    add(searchRoom);

    logout = new JButton("Logout");
    logout.setBounds(10, 470, 200, 30);
    logout.setBackground(Color.BLACK);
    logout.setForeground(Color.WHITE);
    add(logout);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Assets/fourth.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(250, 30, 500, 470);
    add(image);


    setBounds(550, 250, 800, 570);
    setVisible(true);
  }

  public static void main(String[] args)  {
      new Reception();
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == newCustomer){
      new AddCustomers();
      setVisible(false);
    }
    else if (ae.getSource() == searchRoom) {
      try {
        new SearchRoom();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }
    else if (ae.getSource() == roomStatus) {
      try {
        new UpdateRoom();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      setVisible(false);
    }
  }
}

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

    Image icon = Toolkit.getDefaultToolkit().getImage("Assets/icon.png");
    setIconImage(icon);

    newCustomer = new JButton("New Customer Forms");
    newCustomer.setBounds(22, 30, 200, 30);
    newCustomer.setBackground(Color.BLACK);
    newCustomer.setForeground(Color.WHITE);
    newCustomer.addActionListener(this);
    add(newCustomer);

    rooms = new JButton("Rooms");
    rooms.setBounds(22, 70, 200, 30);
    rooms.setBackground(Color.BLACK);
    rooms.setForeground(Color.WHITE);
    rooms.addActionListener(this);
    add(rooms);

    department = new JButton("Department");
    department.setBounds(22, 110, 200, 30);
    department.setBackground(Color.BLACK);
    department.setForeground(Color.WHITE);
    department.addActionListener(this);
    add(department);

    allEmployee = new JButton("All Employees");
    allEmployee.setBounds(22, 150, 200, 30);
    allEmployee.setBackground(Color.BLACK);
    allEmployee.setForeground(Color.WHITE);
    allEmployee.addActionListener(this);
    add(allEmployee);

    customers = new JButton("Customer Info");
    customers.setBounds(22, 190, 200, 30);
    customers.setBackground(Color.BLACK);
    customers.setForeground(Color.WHITE);
    customers.addActionListener(this);
    add(customers);

    managerInfo = new JButton("Manager Info");
    managerInfo.setBounds(22, 230, 200, 30);
    managerInfo.setBackground(Color.BLACK);
    managerInfo.setForeground(Color.WHITE);
    managerInfo.addActionListener(this);
    add(managerInfo);

    checkout = new JButton("Checkout");
    checkout.setBounds(22, 270, 200, 30);
    checkout.setBackground(Color.BLACK);
    checkout.setForeground(Color.WHITE);
    checkout.addActionListener(this);
    add(checkout);

    update = new JButton("Update Status");
    update.setBounds(22, 310, 200, 30);
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.addActionListener(this);
    add(update);

    roomStatus = new JButton("Update Room Status");
    roomStatus.setBounds(22, 350, 200, 30);
    roomStatus.setBackground(Color.BLACK);
    roomStatus.setForeground(Color.WHITE);
    roomStatus.addActionListener(this);
    add(roomStatus);

    pickup = new JButton("Pickup Service");
    pickup.setBounds(22, 390, 200, 30);
    pickup.setBackground(Color.BLACK);
    pickup.setForeground(Color.WHITE);
    pickup.addActionListener(this);
    add(pickup);

    searchRoom = new JButton("Search Room");
    searchRoom.setBounds(22, 430, 200, 30);
    searchRoom.setBackground(Color.BLACK);
    searchRoom.setForeground(Color.WHITE);
    searchRoom.addActionListener(this);
    add(searchRoom);

    logout = new JButton("Logout");
    logout.setBounds(22, 470, 200, 30);
    logout.setBackground(Color.BLACK);
    logout.setForeground(Color.WHITE);
    logout.addActionListener(this);
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

    else if(ae.getSource() == logout) {
      setVisible(false);
    }

    else if (ae.getSource() == rooms) {
      try {
        new Room();
      } catch(SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }

    else if (ae.getSource() == department) {
      try {
        new Department();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }

    else if (ae.getSource() == managerInfo) {
      try {
        new ManagerInfo();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }

    else if (ae.getSource() == customers) {
      try {
        new CustomerInfo();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }

    else if (ae.getSource() == allEmployee) {
      try {
        new EmployeeInfo();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }

    else if (ae.getSource() == checkout) {
      try {
        new CheckOut();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }

    else if (ae.getSource() == update) {
      try {
        new UpdateStatus();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }

    else if (ae.getSource() == pickup) {
      try {
        new PickUp();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      setVisible(false);
    }
  }
}

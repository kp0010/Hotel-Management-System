/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelManagementSystem;

import java.awt.*;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Room extends JFrame {
	Connection Conn = null;
	// private JPanel contentPane;
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	// private JLabel lblRoomNumber;
	private JLabel lblId;

	public static void main(String[] args) {
		try {
			new Room();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public Room() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1100, 600);

		Image icon = Toolkit.getDefaultToolkit().getImage("Assets/Icon.png");
		setIconImage(icon);
                
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Assets/AllRooms.jpg"));
		Image i3 = i1.getImage().getScaledInstance(600, 800,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(500,-200,600,800);
		add(l1);
        
		
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                    Conn c = new Conn();
					String displayCustomersql = "SELECT * FROM Room";
					//PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(100, 490, 120, 30);
		btnLoadData.setBackground(Color.BLACK);
		btnLoadData.setForeground(Color.WHITE);
		add(btnLoadData);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(290, 490, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		add(btnNewButton);

		JLabel lblID = new JLabel("ID");
		lblID.setBounds(45, 15, 69, 14);
		add(lblID);
		
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(120, 15, 69, 14);
		add(lblAvailability);
		
		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(220, 15, 76, 14);
		add(lblCleanStatus);
		
		lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(330, 15, 46, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Bed Type");
		lblNewLabel_1.setBounds(417, 15, 76, 14);
		add(lblNewLabel_1);

		
		lblId = new JLabel("Room Number");
		lblId.setBounds(12, 15, 90, 14);
		add(lblId);
                
		setVisible(true);
    	setBackground(Color.WHITE);
	}

}
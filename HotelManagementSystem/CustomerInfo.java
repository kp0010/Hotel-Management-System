package HotelManagementSystem;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
	Connection Conn = null;
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JLabel lblGender;
	private JTable table;
	private JLabel lblCountry;
	private JLabel lblRoom;
	private JLabel lblStatus;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			new CustomerInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CustomerInfo() throws SQLException {
		//Conn = JavaConnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		setLayout(null);

		Image icon = Toolkit.getDefaultToolkit().getImage("Assets/icon.png");
		setIconImage(icon);

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(450, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		add(btnExit);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                                    Conn c  = new Conn();
                                    
				String displayCustomersql = "select * from Customer";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
		btnLoadData.setBounds(300, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		add(btnLoadData);
		
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		add(lblId);
                
                JLabel l1 = new JLabel("Number");
		l1.setBounds(150, 11, 46, 14);
		add(l1);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(270, 11, 65, 14);
		add(lblNewLabel);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(360, 11, 46, 14);
		add(lblGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		add(table);
		
		lblCountry = new JLabel("Country");
		lblCountry.setBounds(480, 11, 46, 14);
		add(lblCountry);
		
		lblRoom = new JLabel("Room");
		lblRoom.setBounds(600, 11, 46, 14);
		add(lblRoom);
		
		lblStatus = new JLabel("Check-in Status");
		lblStatus.setBounds(680, 11, 100, 14);
		add(lblStatus);
		
		lblNewLabel_1 = new JLabel("Deposit");
		lblNewLabel_1.setBounds(800, 11, 100, 14);
		add(lblNewLabel_1);

		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
}
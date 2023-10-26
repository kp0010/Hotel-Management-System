package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRoom extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTextField txt_Type;
    private JTable roomTable;
    JComboBox c1;

    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchRoom frame = new SearchRoom();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }

    /**
     * Create the frame.
     */
    public SearchRoom() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setBounds(530, 230, 700, 500);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("Assets/icon.png");
        setIconImage(icon);


        JLabel lblSearchForRoom = new JLabel("Search For Room");
        lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSearchForRoom.setBounds(257, 11, 186, 31);
        add(lblSearchForRoom);

        JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
        lblRoomAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRoomAvailable.setBounds(50, 73, 150, 20);
        add(lblRoomAvailable);

        JLabel lblRoomType = new JLabel("Room Number");
        lblRoomType.setBounds(23, 162, 96, 14);
        add(lblRoomType);

        JLabel lblRoomAvailable_1 = new JLabel("Availability");
        lblRoomAvailable_1.setBounds(175, 162, 120, 14);
        add(lblRoomAvailable_1);

        JLabel lblPrice_1 = new JLabel("Price");
        lblPrice_1.setBounds(458, 162, 46, 14);
        add(lblPrice_1);

        JLabel l1 = new JLabel("Bed Type");
        l1.setBounds(580, 162, 96, 14);
        add(l1);

        JCheckBox checkRoom = new JCheckBox("Only display Available");
        checkRoom.setBounds(400, 69, 205, 23);
        checkRoom.setBackground(Color.WHITE);
        add(checkRoom);


        String[] options = {"Single Bed", "Double Bed"};
        c1 = new JComboBox(options);
        c1.setBackground(Color.white);
        c1.setForeground(Color.black);
        c1.setBounds(180, 72, 120, 23);
        add(c1);

        JButton btnSearch = new JButton("Search");

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from Room where bedType = '" + c1.getSelectedItem()+ "'";
                String SQL2 = "select * from Room where availability = 'Available' AND bedType = '"+c1.getSelectedItem()+"'";
                try{
                    Conn c = new Conn();
                    rs = c.s.executeQuery(SQL);
                    roomTable.setModel(DbUtils.resultSetToTableModel(rs));

                    if(checkRoom.isSelected())
                    {
                        rs = c.s.executeQuery(SQL2);
                        roomTable.setModel(DbUtils.resultSetToTableModel(rs));
                    }


                }catch (SQLException ss)
                {
                    ss.printStackTrace();
                }

            }
        });

        btnSearch.setBounds(200, 400, 120, 30);
        btnSearch.setBackground(Color.BLACK);
        btnSearch.setForeground(Color.WHITE);
        add(btnSearch);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });

        btnExit.setBounds(380, 400, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);

        roomTable = new JTable();
        roomTable.setBounds(0, 187, 690, 200);
        roomTable.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(roomTable);
//        scrollPane.setVerticalScrollBarPolicy(
//                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0,187, 683, 200);
        add(scrollPane);

        JLabel lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(306, 162, 96, 14);
        add(lblCleanStatus);

        setVisible(true);
    }
}
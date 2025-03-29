package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_room extends JFrame {

    Choice choice;
    JTable table;
    Search_room() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setForeground(Color.WHITE);
        For.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(For);

        JLabel status = new JLabel("Status: ");
        status.setBounds(50,70,120,20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(status);

        Choice choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        JTable table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Conn conn = new Conn();
            String q = "select * from Room;";
            ResultSet resultSet = conn.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel RN = new JLabel("Room Number ");
        RN.setBounds(23,162,150,20);
        RN.setForeground(Color.WHITE);
        RN.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(RN);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(175,162,150,20);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);

        JLabel price = new JLabel("Price");
        price.setBounds(408,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(580,162,150,20);
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bed);

        JButton search = new JButton("Search");
        search.setBounds(200,420,150,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(search);
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String q1 = "select * from Room where availability ='"+choice.getSelectedItem()+"'";
                try {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(380,420,150,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(back);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Search_room();
    }
}

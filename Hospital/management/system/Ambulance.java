package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try {
            Conn conn = new Conn();
            String sql = "select * from Ambulance";
            ResultSet resultSet = conn.statement.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(31,11,100,14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(264,11,100,14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Car Type");
        label3.setBounds(400,11,100,25);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Availability");
        label4.setBounds(580,11,100,25);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(750,11,100,14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);



        JButton button1 = new JButton("Back");
        button1.setBounds(450,510,120,30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        panel.add(button1);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(230,50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Ambulance();
    }
}

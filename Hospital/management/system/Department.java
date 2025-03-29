package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department (){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try {
            Conn conn = new Conn();
            String sql = "select * from department";
            ResultSet resultSet = conn.statement.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel = new JLabel("Department");
        lblNewLabel.setBounds(145,11,105,20);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblNewLabel);

        JLabel lblNewLabe2 = new JLabel("Phone No");
        lblNewLabe2.setBounds(431,11,150,20);
        lblNewLabe2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblNewLabe2);


        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBounds(400,410,130,30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        panel.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,100);
        setVisible(true);

    };
    public static void main(String[] args) {
        new Department();
    }
}

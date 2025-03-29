package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
    Employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(table);

        try {
            Conn conn = new Conn();
            String sql = "select * from EMP_info";
            ResultSet resultSet = conn.statement.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lbl1 = new JLabel("Name");
        lbl1.setBounds(41,9,70,20);
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lbl1);

        JLabel lbl2 = new JLabel("Age");
        lbl2.setBounds(230,9,70,20);
        lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lbl2);

        JLabel lbl3 = new JLabel("Phone Number");
        lbl3.setBounds(350,9,150,20);
        lbl3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lbl3);

        JLabel lbl4 = new JLabel("Salary");
        lbl4.setBounds(550,9,70,20);
        lbl4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lbl4);

        JLabel lbl5 = new JLabel("Mail");
        lbl5.setBounds(710,9,70,20);
        lbl5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lbl5);

        JLabel lbl6 = new JLabel("NID");
        lbl6.setBounds(850,9,70,20);
        lbl6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lbl6);



        JButton btn = new JButton("Back");
        btn.setBounds(380,500,100,30);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        panel.add(btn);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(1000,600);
        setLocation(250,50);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();
    }
}

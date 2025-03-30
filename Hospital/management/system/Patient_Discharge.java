package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge(){


        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-out");
        label.setBounds(100,20,120,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Name");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
//                Choice.add(resultSet.getString("number"));
                choice.add(resultSet.getString("name"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel INtime = new JLabel();
        INtime.setBounds(200,180,250,20);
        INtime.setFont(new Font("Tahoma",Font.BOLD,14));
        INtime.setForeground(Color.WHITE);
        panel.add(INtime);

        JLabel label4 = new JLabel("Out Time");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        Date date = new Date();

        JLabel OUTtime = new JLabel(""+date);
        OUTtime.setBounds(200,230,250,20);
        OUTtime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTtime.setForeground(Color.WHITE);
        panel.add(OUTtime);


        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,100,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where name = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Patient Discharged Successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(170,300,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where name='"+choice.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        RNo.setText(resultSet.getString("Room_Number"));
                        INtime.setText(resultSet.getString("Time"));
                    }

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(320,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(250,120);

        setVisible(true);


    }
    public static void main(String[] args) {
        new Patient_Discharge();
    }
}

package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_patients_details extends JFrame {
    Update_patients_details() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon ImageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = ImageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);

        ImageIcon ImageIcon1 = new ImageIcon(image);

        JLabel label = new JLabel(ImageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Updated Patients Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Name: ");
        label2.setBounds(25,88,50,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);

        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number: ");
        label3.setBounds(25,129,200,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-time: ");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINtime = new JTextField();
        textFieldINtime.setBounds(248,174,170,20);
        panel.add(textFieldINtime);

        JLabel label5 = new JLabel("Amount Paid(Tk): ");
        label5.setBounds(25,216,200,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount(Tk): ");
        label6.setBounds(25,261,200,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where name = '" + id + "'";
                try {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINtime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));

                    }
                    ResultSet rs = conn.statement.executeQuery("select * from room where room_no = '" + textFieldR.getText() + "'");
                    while (rs.next()) {
                        String price = rs.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+ amountPaid);
                    }
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINtime.getText();
                    String amount = textFieldAmount.getText();

                    conn.statement.executeUpdate("update patient_info set Room_Number = '"+room+"', Time ='"+time+"', Deposite = '"+amount+"' where name = '"+q+"'");
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    setVisible(false);


                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(168,378,89,23);
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
        setSize(950,500);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Update_patients_details();
    }
}

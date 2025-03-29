package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1270,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1270,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1050,0,250,250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i21);
        label1.setBounds(800,10,250,140);
        panel1.add(label1);

        JButton button1 = new JButton("Add New Patient");
        button1.setBounds(20,15,150,30);
        button1.setBackground(new Color(246,215,118));
        panel1.add(button1);
        button1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton button2 = new JButton("Room");
        button2.setBounds(20,58,150,30);
        button2.setBackground(new Color(246,215,118));
        panel1.add(button2);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });
        JButton button3 = new JButton("Department");
        button3.setBounds(20,100,150,30);
        button3.setBackground(new Color(246,215,118));
        panel1.add(button3);
        button3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });
        JButton button4 = new JButton("All Employee Info");
        button4.setBounds(200,15,150,30);
        button4.setBackground(new Color(246,215,118));
        panel1.add(button4);
        button4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });
        JButton button5 = new JButton("Patient Details");
        button5.setBounds(200,58,150,30);
        button5.setBackground(new Color(246,215,118));
        panel1.add(button5);
        button5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new All_patient_info();
            }
        });
        JButton button6 = new JButton("Patient Discharge");
        button6.setBounds(200,100,150,30);
        button6.setBackground(new Color(246,215,118));
        panel1.add(button6);
        button6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_Discharge();
            }
        });
        JButton button7 = new JButton("Update Patient Info");
        button7.setBounds(380,15,150,30);
        button7.setBackground(new Color(246,215,118));
        panel1.add(button7);
        button7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_patients_details();
            }
        });
        JButton button8 = new JButton("Hospital Ambulance");
        button8.setBounds(380,58,152,30);
        button8.setBackground(new Color(246,215,118));
        //button8.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel1.add(button8);
        button8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });
        JButton button9 = new JButton("Search Room");
        button9.setBounds(380,100,150,30);
        button9.setBackground(new Color(246,215,118));
        panel1.add(button9);
        button9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_room();
            }
        });
        JButton button10 = new JButton("Log Out");
        button10.setBounds(560,15,150,30);
        button10.setBackground(new Color(246,215,118));
        panel1.add(button10);
        button10.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });









        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}

package Hospital.management.system;

import javax.swing.*;
import java.awt.*;

public class Reception extends JFrame {
    Reception(){


        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBounds(5, 5, 1270, 100);
        titlePanel.setBackground(new Color(109, 164, 170));
        add(titlePanel);

        JLabel titleLabel = new JLabel("Hospital Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setBounds(400, 30, 500, 30);
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        //Image panel
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(null);
        imagePanel.setBounds(620, 120, 655, 350);
        imagePanel.setBackground(new Color(109, 164, 170));
        add(imagePanel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(400,10,250,250);
        imagePanel.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i11.getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i21);
        label1.setBounds(50,100,350,140);
        imagePanel.add(label1);

        // Sidebar Panel
        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBounds(5, 120, 600, 350);
        sidebar.setBackground(new Color(109, 164, 170));
        add(sidebar);

        JButton button1 = new JButton("Add New Patient");
        button1.setBounds(20, 15, 150, 30);
        button1.setBackground(new Color(246, 215, 118));
        sidebar.add(button1);
        button1.addActionListener(e -> new NEW_PATIENT());

        JButton button2 = new JButton("Room");
        button2.setBounds(20, 58, 150, 30);
        button2.setBackground(new Color(246, 215, 118));
        sidebar.add(button2);
        button2.addActionListener(e -> new Room());

        JButton button3 = new JButton("Department");
        button3.setBounds(20, 100, 150, 30);
        button3.setBackground(new Color(246, 215, 118));
        sidebar.add(button3);
        button3.addActionListener(e -> new Department());

        JButton button4 = new JButton("All Employee Info");
        button4.setBounds(200, 15, 150, 30);
        button4.setBackground(new Color(246, 215, 118));
        sidebar.add(button4);
        button4.addActionListener(e -> new Employee_info());

        JButton button5 = new JButton("Patient Details");
        button5.setBounds(200, 58, 150, 30);
        button5.setBackground(new Color(246, 215, 118));
        sidebar.add(button5);
        button5.addActionListener(e -> new All_patient_info());

        JButton button6 = new JButton("Patient Discharge");
        button6.setBounds(200, 100, 150, 30);
        button6.setBackground(new Color(246, 215, 118));
        sidebar.add(button6);
        button6.addActionListener(e -> new Patient_Discharge());

        JButton button7 = new JButton("Update Patient Info");
        button7.setBounds(380, 15, 150, 30);
        button7.setBackground(new Color(246, 215, 118));
        sidebar.add(button7);
        button7.addActionListener(e -> new Update_patients_details());

        JButton button8 = new JButton("Hospital Ambulance");
        button8.setBounds(380, 58, 152, 30);
        button8.setBackground(new Color(246, 215, 118));
        sidebar.add(button8);
        button8.addActionListener(e -> new Ambulance());

        JButton button9 = new JButton("Search Room");
        button9.setBounds(380, 100, 150, 30);
        button9.setBackground(new Color(246, 215, 118));
        sidebar.add(button9);
        button9.addActionListener(e -> new Search_room());

        JButton button10 = new JButton("Log Out");
        button10.setBounds(200, 200, 150, 30);
        button10.setBackground(new Color(246, 215, 118));
        sidebar.add(button10);
        button10.addActionListener(e -> {
            setVisible(false);
            new Login();
        });
        //footer panel
        JPanel footerpanel = new JPanel();
        footerpanel.setBounds(5,480,1270,165);
        footerpanel.setLayout(null);
        footerpanel.setBackground(new Color(109, 164, 170));
        add(footerpanel);

        JLabel titlefooter = new JLabel("This HPM is created by", JLabel.CENTER);
        titlefooter.setBounds(0,0,1280,50);
        titlefooter.setFont(new Font("Tahoma", Font.BOLD, 16));
        titlefooter.setForeground(Color.WHITE);
        footerpanel.add(titlefooter);

        JLabel titlefooter1 = new JLabel("Sahadat Hossain Shantono", JLabel.CENTER);
        titlefooter1.setBounds(0,20,1280,50);
        titlefooter1.setFont(new Font("Tahoma", Font.BOLD, 16));
        titlefooter1.setForeground(Color.WHITE);
        footerpanel.add(titlefooter1);

        JLabel titlefooter2 = new JLabel("ID: 2023200010133", JLabel.CENTER);
        titlefooter2.setBounds(0,40,1280,50);
        titlefooter2.setFont(new Font("Tahoma", Font.BOLD, 16));
        titlefooter2.setForeground(Color.WHITE);
        footerpanel.add(titlefooter2);

        JLabel titlefooter3 = new JLabel("Teacher: Md miraz sir", JLabel.CENTER);
        titlefooter3.setBounds(0,60,1280,50);
        titlefooter3.setFont(new Font("Tahoma", Font.BOLD, 16));
        titlefooter3.setForeground(Color.WHITE);
        footerpanel.add(titlefooter3);


        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}


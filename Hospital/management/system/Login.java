package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jpasswordField;
    JButton b1,b2;
    Login(){
        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setBounds(40,50,150,30);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD,20));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        JLabel password = new JLabel("Password:");
        password.setBounds(40,100,150,30);
        password.setFont(new Font("Tahoma",Font.BOLD,20));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(170,50,200,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        jpasswordField = new JPasswordField();
        jpasswordField.setBounds(170,100,200,30);
        jpasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jpasswordField.setBackground(new Color(255,179,0));
        add(jpasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image image = imageIcon.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300,-30,400,300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40,160,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(180,160,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(109,164,170));
        setSize(700,300);
        setLocation(350,250);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try {
                Conn conn = new Conn();
                String name = textField.getText();
                String password = jpasswordField.getText();

                String q = "select * from login where ID = '"+name+"'and PW = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(q);
                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }catch (Exception E) {
                E.printStackTrace();
            }

        }else {
            System.exit(0);
        }

    }


    public static void main(String[] args) {
        new Login();
    }
}

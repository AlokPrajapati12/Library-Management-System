package Library_management_System;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login {
    JFrame frame;
    JLabel username,password;
    JTextField userText;
    JPasswordField passText;
    JButton login,cancel;
    Login(){
        frame=new JFrame("Login");
        frame.setSize(600,280);
        frame.getContentPane().setBackground(new Color(28, 53, 50));
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocation(400,270);

        username=new JLabel("Username");
        username.setBounds(40,20,100,30);
        username.setFont(new Font("Tahoma",Font.BOLD,16));
        username.setForeground(Color.white);
        frame.add(username);
        userText=new JTextField();
        userText.setBounds(150,20,150,30);
        userText.setForeground(Color.white);
        userText.setFont(new Font("Tahoma",Font.BOLD,15));
        userText.setBackground(new Color(26,104,110));
        frame.add(userText);

        password=new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setForeground(Color.white);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        frame.add(password);
        passText=new JPasswordField();
        passText.setBounds(150,70,150,30);
        passText.setForeground(Color.white);
        passText.setBackground(new Color(26,104,110));
        frame.add(passText);

        login=new JButton("Login");
        login.setBounds(60,150,100,30);
        login.setFont(new Font("serif",Font.BOLD,15));
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  config c=new config();
                  String user=userText.getText();
                  String pass=passText.getText();
                  String q="select * from login where username='"+user+"' and password='"+pass+"'";
                  ResultSet resultSet=c.statement.executeQuery(q);
                  if(resultSet.next()){
                      new Deshboard();
                      frame.setVisible(false);
                  }else{
                      JOptionPane.showMessageDialog(null,"Invalid username and password");
                  }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(180,150,100,30);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(104);
            }
        });
        frame.add(cancel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image image=imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(330,0,250,250);
        frame.add(label);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    }
}

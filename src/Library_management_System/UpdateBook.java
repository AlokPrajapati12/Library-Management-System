package Library_management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateBook {
    JFrame frame;
    JPanel panel;
    JLabel isbn,title,author,publishyear;
    JTextField titleText,authorText;
    JDateChooser publishyearText;
    JButton update,back,check;
    UpdateBook(){
        frame=new JFrame();
        frame.setSize(420,470);
        frame.setLocation(60,200);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.white);

        panel=new JPanel();
        panel.setBounds(5,5,410,460);
        panel.setBackground(new Color(126, 10, 10));
        panel.setLayout(null);
        frame.add(panel);

        JLabel heading =new JLabel("UPDATE BOOK DETAILS");
        heading.setBounds(80,11,300,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        isbn=new JLabel("ISBN :");
        isbn.setForeground(Color.white);
        isbn.setFont(new Font("Tahoma",Font.BOLD,16));
        isbn.setBounds(20,70,100,30);
        panel.add(isbn);
        Choice isbnText=new Choice();
        isbnText.setFont(new Font("Tahoma",Font.BOLD,14));
        isbnText.setBounds(180,70,170,25);
        panel.add(isbnText);
        try {
            config c=new config();
            ResultSet resultSet=c.statement.executeQuery("select * from addBook");
            while(resultSet.next()){
                isbnText.add(resultSet.getString("ISBN"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        title=new JLabel("Title :");
        title.setForeground(Color.white);
        title.setFont(new Font("Tahoma",Font.BOLD,16));
        title.setBounds(20,120,100,30);
        panel.add(title);
        titleText=new JTextField();
        titleText.setFont(new Font("Tahoma",Font.BOLD,14));
        titleText.setBounds(180,120,170,25);
        panel.add(titleText);

        author=new JLabel("Author :");
        author.setBounds(20,170,100,30);
        author.setForeground(Color.WHITE);
        author.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(author);
        authorText=new JTextField();
        authorText.setFont(new Font("Tahoma",Font.BOLD,14));
        authorText.setBounds(180,170,170,25);
        panel.add(authorText);

        publishyear=new JLabel("Publish Year :");
        publishyear.setForeground(Color.white);
        publishyear.setFont(new Font("Tahoma",Font.BOLD,16));
        publishyear.setBounds(20,220,200,30);
        panel.add(publishyear);
        publishyearText=new JDateChooser();
        publishyearText.setFont(new Font("Tahoma",Font.BOLD,14));
        publishyearText.setBounds(180,220,170,25);
        panel.add(publishyearText);

        update=new JButton("UPDATE");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setBounds(50,300,100,30);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    config c=new config();
                    String isbn=isbnText.getSelectedItem();
                    String title=titleText.getText();
                    String author=authorText.getText();
                    String  year=((JTextField)publishyearText.getDateEditor().getUiComponent()).getText();
                    String q="update addBook set title='"+title+"',author='"+author+"',publish_year='"+year+"' where ISBN ='"+isbn+"'";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                    frame.setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(update);

        back=new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(200,300,100,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        panel.add(back);

        check=new JButton("CHECK");
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setBounds(125,360,100,30);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ch=isbnText.getSelectedItem();
                String q="select * from addBook where ISBN ='"+ch+"'";
                try {
                    config c=new config();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while (resultSet.next()){
                        titleText.setText(resultSet.getString("title"));
                        authorText.setText(resultSet.getString("author"));
                        ((JTextField)publishyearText.getDateEditor().getUiComponent()).setText(resultSet.getString("publish_year"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(check);


        frame.setVisible(true);

    }
    public static void main(String[] args){
        new UpdateBook();
    }
}

package Library_management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBook {
    JFrame frame;
    JPanel panel;
    JTable table;
    ViewBook(){
        frame=new JFrame();
        frame.setSize(430,500);
        frame.setLocation(60,200);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.white);

        panel=new JPanel();
        panel.setBounds(5,5,420,490);
        panel.setBackground(new Color(126, 10, 10));
        panel.setLayout(null);
        frame.add(panel);

        JLabel heading =new JLabel("VIEW BOOK DETAILS");
        heading.setBounds(80,11,300,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel isbn=new JLabel("ISBN");
        isbn.setBounds(20,60,100,30);
        isbn.setForeground(Color.white);
        isbn.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(isbn);
        JLabel title=new JLabel("Title");
        title.setBounds(150,60,100,30);
        title.setForeground(Color.white);
        title.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(title);
        JLabel author=new JLabel("Author");
        author.setBounds(240,60,100,30);
        author.setForeground(Color.white);
        author.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(author);
        JLabel publish=new JLabel("P_Year");
        publish.setBounds(325,60,100,30);
        publish.setForeground(Color.white);
        publish.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(publish);

        table=new JTable();
        table.setBounds(0,90,420,360);
        table.setBackground(new Color(126, 10, 10));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        table.setForeground(Color.white);
        panel.add(table);
        try {
            config c=new config();
            ResultSet resultSet=c.statement.executeQuery("select * from addBook");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back=new JButton("BACK");
        back.setBounds(310,450,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        panel.add(back);

        frame.setVisible(true);

    }

    public static void main(String[] args){
        new ViewBook();
    }
}

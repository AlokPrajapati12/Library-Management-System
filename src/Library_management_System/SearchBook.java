package Library_management_System;

import net.proteanit.sql.DbUtils;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class SearchBook {
    JFrame frame;
    JPanel panel;
    JLabel search;
    JTable table;
    JRadioButton isbn1,name,author1;
    Choice searchText;
    JButton searchButton;
    SearchBook(){
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

        JLabel heading =new JLabel("SEARCH BOOK");
        heading.setBounds(120,11,200,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        search=new JLabel("Search :");
        search.setFont(new Font("Tahoma",Font.BOLD,15));
        search.setForeground(Color.white);
        search.setBounds(10,50,80,30);
        panel.add(search);
        searchText=new Choice();
        searchText.setBounds(90,55,200,25);
        searchText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(searchText);

        table=new JTable();
        table.setBounds(0,160,420,200);
        table.setBackground(new Color(14, 10, 126));
        table.setFont(new Font("Tahoma",Font.PLAIN,14));
        table.setForeground(Color.white);
        panel.add(table);

        JLabel searchBy=new JLabel("Search By :");
        searchBy.setBounds(10,100,100,20);
        searchBy.setFont(new Font("Tahoma",Font.BOLD,14));
        searchBy.setForeground(Color.white);
        panel.add(searchBy);
        isbn1=new JRadioButton("ISBN");
        isbn1.setBounds(100,100,90,20);
        isbn1.setFont(new Font("Tahoma",Font.BOLD,14));
        isbn1.setBackground(new Color(126, 10, 10));
        isbn1.setForeground(Color.white);
        isbn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    config c=new config();
                    ResultSet resultSet=c.statement.executeQuery("select * from addBook");
                    while (resultSet.next()){
                        searchText.add(resultSet.getString("ISBN"));
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(isbn1);


        name=new JRadioButton("Name");
        name.setBounds(190,100,90,20);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setBackground(new Color(126, 10, 10));
        name.setForeground(Color.white);
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    config c=new config();
                    ResultSet resultSet=c.statement.executeQuery("select * from addBook");
                    while (resultSet.next()){
                        searchText.add(resultSet.getString("title"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(name);

        author1=new JRadioButton("Author");
        author1.setBounds(280,100,90,20);
        author1.setFont(new Font("Tahoma",Font.BOLD,14));
        author1.setBackground(new Color(126, 10, 10));
        author1.setForeground(Color.white);
        author1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    config c=new config();
                    ResultSet resultSet=c.statement.executeQuery("select * from addBook");
                    while (resultSet.next()){
                        searchText.add(resultSet.getString("author"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(author1);
        ButtonGroup group=new ButtonGroup();
        group.add(isbn1);
        group.add(name);
        group.add(author1);

        JLabel isbn=new JLabel("ISBN");
        isbn.setBounds(20,130,100,30);
        isbn.setForeground(Color.white);
        isbn.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(isbn);
        JLabel title=new JLabel("Title");
        title.setBounds(150,130,100,30);
        title.setForeground(Color.white);
        title.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(title);
        JLabel author=new JLabel("Author");
        author.setBounds(240,130,100,30);
        author.setForeground(Color.white);
        author.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(author);
        JLabel publish=new JLabel("P_Year");
        publish.setBounds(325,130,100,30);
        publish.setForeground(Color.white);
        publish.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(publish);

        searchButton=new JButton("SEARCH");
        searchButton.setBounds(300, 55, 90, 25);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    config c=new config();
                    String q="";
                    String selectedSearch="";
                    if(isbn1.isSelected()){
                        selectedSearch="ISBN";
                        q="select * from addBook where ISBN='"+searchText.getSelectedItem()+"'";
                    } else if(name.isSelected()){
                        selectedSearch="Name";
                        q="select * from addBook where title='"+searchText.getSelectedItem()+"'";
                    } else if(author1.isSelected()){
                        selectedSearch="Author";
                        q="select * from addBook where author='"+searchText.getSelectedItem()+"'";
                    }
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(searchButton);

        JButton back=new JButton("BACK");
        back.setBounds(290,370,100,30);
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
        new SearchBook();
    }
}

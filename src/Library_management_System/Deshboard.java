package Library_management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deshboard {
    JFrame frame;
    JPanel p1,p2;
    JButton addBook,searchBook,deleteBook,updateBook,viewBook,logout;
    Deshboard(){
        frame=new JFrame();
        frame.setSize(1950,1090);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.white);

        p1=new JPanel();
        p1.setBounds(5,5,1525,150);
        p1.setLayout(null);
        p1.setBackground(new Color(109, 202, 62));
        frame.add(p1);
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/header.png"));
        Image image=imageIcon.getImage().getScaledInstance(1525,270,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(0,0,1525,270);
        p1.add(label);

        addBook=new JButton("Add Book");
        addBook.setBounds(30,15,150,30);
        addBook.setFont(new Font("serif",Font.BOLD,16));
        addBook.setBackground(new Color(243, 63, 63));
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new AddBook();
            }
        });
        label.add(addBook);

        searchBook=new JButton("Search Book");
        searchBook.setBounds(30,60,150,30);
        searchBook.setFont(new Font("serif",Font.BOLD,16));
        searchBook.setBackground(new Color(243, 63, 63));
        searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchBook();
            }
        });
        label.add(searchBook);

        updateBook=new JButton("Update Book");
        updateBook.setBounds(30,105,150,30);
        updateBook.setFont(new Font("serif",Font.BOLD,16));
        updateBook.setBackground(new Color(243, 63, 63));
        updateBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new UpdateBook();
            }
        });
        label.add(updateBook);

        deleteBook=new JButton("Delete Book");
        deleteBook.setBounds(260,15,150,30);
        deleteBook.setFont(new Font("serif",Font.BOLD,16));
        deleteBook.setBackground(new Color(243, 63, 63));
        deleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new DeleteBook();
            }
        });
        label.add(deleteBook);

        viewBook=new JButton("View Book");
        viewBook.setBounds(260,60,150,30);
        viewBook.setFont(new Font("serif",Font.BOLD,16));
        viewBook.setBackground(new Color(243, 63, 63));
        viewBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new ViewBook();
            }
        });
        label.add(viewBook);

        logout=new JButton("Logout");
        logout.setBounds(260,105,150,30);
        logout.setFont(new Font("serif",Font.BOLD,16));
        logout.setBackground(new Color(243, 63, 63));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
        label.add(logout);


        p2=new JPanel();
        p2.setBounds(5,160,1525,625);
        p2.setLayout(null);
        p2.setBackground(new Color(179, 227, 167));
        frame.add(p2);

        ImageIcon imageIcon2=new ImageIcon(ClassLoader.getSystemResource("icon/1.png"));
        Image image1=imageIcon2.getImage().getScaledInstance(1525,670,Image.SCALE_DEFAULT);
        ImageIcon imageIcon3=new ImageIcon(image1);
        JLabel label1=new JLabel(imageIcon3);
        label1.setBounds(0,0,1525,670);
        p2.add(label1);


        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Deshboard();
    }
}

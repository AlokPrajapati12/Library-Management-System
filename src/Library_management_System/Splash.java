package Library_management_System;

import javax.swing.*;
import java.awt.*;

public class Splash {
    JFrame frame;
    Splash(){
        frame=new JFrame();
        frame.setSize(1090,700);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocation(200,50);
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        Image image=imageIcon.getImage().getScaledInstance(1090,700,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(0,0,1090,700);
        frame.add(label);
        frame.setVisible(true);
        try {
            Thread.sleep(2000);
            frame.setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Splash();
    }
}

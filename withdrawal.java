import java.awt.Color;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.*;

public class withdrawal extends JFrame implements ActionListener{
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;

    withdrawal(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,440,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,480,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setUndecorated(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
          String amount1=amount.getText();
          Date date=new Date();
          if(amount1.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter a valid amount.");
          }
          else{
            try{
            conn c=new conn();
            String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount1+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs "+amount1+" withdrawn successfully");
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
          }
        }else if(ae.getSource()==back){
            setVisible(false);
           new transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new withdrawal("");
    }
}
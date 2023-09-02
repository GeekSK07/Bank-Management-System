import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;

public class fastcash extends JFrame implements ActionListener {

    JButton o1,o2,o3,o4,o5,o6,back;
    String pinnumber;
    fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        o1=new JButton("Rs 100");
        o1.setBounds(170,415,150,30);
        o1.addActionListener(this);
        image.add(o1);

        o2=new JButton("Rs 500");
        o2.setBounds(350,415,150,30);
        o2.addActionListener(this);
        image.add(o2);

        o3=new JButton("Rs 1000");
        o3.setBounds(170,450,150,30);
        o3.addActionListener(this);
        image.add(o3);

        o4=new JButton("Rs 2000");
        o4.setBounds(350,450,150,30);
        o4.addActionListener(this);
        image.add(o4);

        o5=new JButton("Rs 5000");
        o5.setBounds(170,485,150,30);
        o5.addActionListener(this);
        image.add(o5);

        o6=new JButton("Rs 10000");
        o6.setBounds(350,485,150,30);
        o6.addActionListener(this);
        image.add(o6);

        back=new JButton("Back");
        back.setBounds(350,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
        else{
           String amount=((JButton)ae.getSource()).getText().substring(3);
           conn c=new conn();
           try{
              ResultSet rs=c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
              int balance=0;
              while (rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
              }
              if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
              }
              Date date=new Date();
              String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully");

              setVisible(false);
              new transaction(pinnumber).setVisible(true);
           }catch(Exception e){
            System.out.println(e);
           }
        }
    }
    public static void main(String[] args) {
        new fastcash("");
    }
}

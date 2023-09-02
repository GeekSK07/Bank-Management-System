import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ministatement extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;

    ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);

        JLabel text=new JLabel();
        add(text);

        JLabel bank=new JLabel("Swiss Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel mini=new JLabel();
        mini.setBounds(20,120,400,200);
        add(mini);

        back=new JButton("BACK");
        back.setBounds(280,520,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try{
           conn c=new conn();
           ResultSet rs=c.s.executeQuery("select * from login where pin = '"+pinnumber+"' ");
           while(rs.next()){
            card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
           }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
          conn c=new conn();
          ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
          while(rs.next()){
            mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getInt("amount") + "<br><br><html>");
          }
        }catch(Exception e){
            System.out.println(e);
        }


        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transaction(pinnumber).setVisible(true);
    }
    public static void main(String[] args) {
        new ministatement("");
    }
}

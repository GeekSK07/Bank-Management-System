import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
     JButton login,signup,clear;
     JTextField cardtext;
     JPasswordField pintext;

   login(){
      setTitle("BANKING SYSTEM");

      setLayout(null);
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
      Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel label=new JLabel(i3);
      label.setBounds(70,10,100,100);
      add(label);
      JLabel text=new JLabel("Welcome to Online Banking System");
      text.setBounds(200,40,1000,40);
      text.setFont(new Font("Osward",Font.BOLD,30));
      add(text);

      JLabel cardno=new JLabel("Card No: ");
      cardno.setBounds(120,150,150,40);
      cardno.setFont(new Font("Raleway",Font.BOLD,25));
      add(cardno);

      cardtext =new JTextField();
      cardtext.setBounds(300,150,230,40);
      cardtext.setFont(new Font("Arial",Font.BOLD,14));
      add(cardtext);

      JLabel pin=new JLabel("PIN: ");
      pin.setBounds(120,220,150,40);
      pin.setFont(new Font("Raleway",Font.BOLD,25));
      add(pin);

      pintext =new JPasswordField();
      pintext.setBounds(300,220,230,40);
      add(pintext);

      login = new JButton("LOGIN");
      login.setBounds(300, 300, 100, 30);
      login.setBackground(Color.BLACK);
      login.setForeground(Color.WHITE);
      login.addActionListener(this);
      add(login);

      clear  = new JButton("CLEAR");
      clear.setBounds(430, 300, 100, 30);
      clear.setBackground(Color.BLACK);
      clear.setForeground(Color.WHITE);
      clear.addActionListener(this);
      add(clear);

      signup = new JButton("SIGN UP");
      signup.setBounds(300, 350, 230, 30);
      signup.setBackground(Color.BLACK);
      signup.setForeground(Color.WHITE);
      signup.addActionListener(this);
      add(signup);

      getContentPane().setBackground(Color.WHITE);

       setSize(800, 480);
       setVisible(true); 
       setLocation(350, 200);
   }

   public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == clear){
      cardtext.setText("");
      pintext.setText("");
     }
     else if(ae.getSource()==login){
         conn c=new conn();
         String cardnumber=cardtext.getText();
         String pinnumber=pintext.getText();
         String query="select * from login where cardnumber='"+cardnumber+"'and pin ='"+pinnumber+"'"; 
         try{
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
               setVisible(false);
               new transaction(pinnumber).setVisible(true);
            }
            else{
               JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin");
            }
         }catch(Exception e){
             System.out.println(e);
         }
     }
     else if(ae.getSource()==signup){
        setVisible(false);
        new signup1().setVisible(true);
     }
   }
public static void main(String[] args) {
    new login();
}
    
}
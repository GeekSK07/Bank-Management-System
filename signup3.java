import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.util.*;
import java.awt.event.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox j1,j2,j3,j4,j5,j6,j7;
    JButton submit,cancel;
    String formno;
    

  signup3(String formno){
   this.formno=formno;
    setLayout(null);
    JLabel l1=new JLabel("Page 3: Account Details");
    l1.setFont(new Font("Raleway",Font.BOLD,22));
    l1.setBounds(280,40,400,40);
    add(l1);

    JLabel type=new JLabel("Account Type:");
    type.setFont(new Font("Raleway",Font.BOLD,22));
    type.setBounds(100,140,200,30);
    add(type);

    r1=new JRadioButton("Savings Account");
    r1.setFont(new Font("Raleway",Font.BOLD,16));
    r1.setBackground(Color.WHITE);
    r1.setBounds(100,180,200,20);
    add(r1);

    r2=new JRadioButton("Fixed Deposit Account");
    r2.setFont(new Font("Raleway",Font.BOLD,16));
    r2.setBackground(Color.WHITE);
    r2.setBounds(350,180,200,20);
    add(r2);

    r3=new JRadioButton("Current Account");
    r3.setFont(new Font("Raleway",Font.BOLD,16));
    r3.setBackground(Color.WHITE);
    r3.setBounds(100,220,200,20);
    add(r3);

    r4=new JRadioButton("Recurring Deposit Account");
    r4.setFont(new Font("Raleway",Font.BOLD,16));
    r4.setBackground(Color.WHITE);
    r4.setBounds(350,220,250,20);
    add(r4);

    ButtonGroup acctype=new ButtonGroup();
    acctype.add(r1);
    acctype.add(r2);
    acctype.add(r3);
    acctype.add(r4);

    JLabel card=new JLabel("Card Number:");
    card.setFont(new Font("Raleway",Font.BOLD,22));
    card.setBounds(100,300,200,30);
    add(card);

    JLabel number=new JLabel("XXXX-XXXX-XXXX-4134");
    number.setFont(new Font("Raleway",Font.BOLD,22));
    number.setBounds(330,300,300,30);
    add(number);

    JLabel cdetails=new JLabel("Your 16 Digit card number");
    cdetails.setFont(new Font("Raleway",Font.BOLD,12));
    cdetails.setBounds(100,330,300,20);
    add(cdetails);

    JLabel pin=new JLabel("PIN:");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    pin.setBounds(100,370,200,30);
    add(pin);

    JLabel pnumber=new JLabel("XXXX");
    pnumber.setFont(new Font("Raleway",Font.BOLD,22));
    pnumber.setBounds(330,370,300,30);
    add(pnumber);

     JLabel pdetails=new JLabel("Your 4 Digit password");
    pdetails.setFont(new Font("Raleway",Font.BOLD,12));
    pdetails.setBounds(100,400,300,20);
    add(pdetails);

    
    JLabel services=new JLabel("Services Required: ");
    services.setFont(new Font("Raleway",Font.BOLD,22));
    services.setBounds(100,450,300,30);
    add(services); 

    j1=new JCheckBox("ATM CARD");
    j1.setBackground(Color.WHITE);
    j1.setFont(new Font("Raleway",Font.BOLD,16));
    j1.setBounds(100,500,200,30);
    add(j1);

    j2=new JCheckBox("Internet Banking");
    j2.setBackground(Color.WHITE);
    j2.setFont(new Font("Raleway",Font.BOLD,16));
    j2.setBounds(350,500,200,30);
    add(j2);

    j3=new JCheckBox("Mobile Banking");
    j3.setBackground(Color.WHITE);
    j3.setFont(new Font("Raleway",Font.BOLD,16));
    j3.setBounds(100,550,200,30);
    add(j3); 
    
    j4=new JCheckBox("Email & SMS alerts");
    j4.setBackground(Color.WHITE);
    j4.setFont(new Font("Raleway",Font.BOLD,16));
    j4.setBounds(350,550,200,30);
    add(j4);

     j5=new JCheckBox("Cheque Book");
    j5.setBackground(Color.WHITE);
    j5.setFont(new Font("Raleway",Font.BOLD,16));
    j5.setBounds(100,600,200,30);
    add(j5);

     j6=new JCheckBox("E-Statement");
    j6.setBackground(Color.WHITE);
    j6.setFont(new Font("Raleway",Font.BOLD,16));
    j6.setBounds(350,600,200,30);
    add(j6);

     j7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
    j7.setBackground(Color.WHITE);
    j7.setFont(new Font("Raleway",Font.BOLD,12));
    j7.setBounds(100,680,600,30);
    add(j7);

    submit=new JButton("Submit");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.setFont(new Font("Raleway",Font.BOLD,14));
    submit.setBounds(250, 720, 100, 30);
    submit.addActionListener(this);
    add(submit);

    cancel=new JButton("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("Raleway",Font.BOLD,14));
    cancel.setBounds(550, 720, 100, 30);
    cancel.addActionListener(this);
    add(cancel);
    
    getContentPane().setBackground(Color.WHITE);

    setSize(850,820);
    setLocation(350,0);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
       String acctype=null;
       if(r1.isSelected()){
        acctype="Savings";
       }
       else if(r2.isSelected()){
        acctype = "Fixed Deposit Account";
       }
       else if(r3.isSelected()){
        acctype="Current Account";
       }
       else if(r4.isSelected()){
        acctype="Recurring Deposit Account";
       }
      Random random=new Random();
      String cardnumber="" + Math.abs((random.nextLong()%90000000L)+5040936000000000L);

      String pinnumber="" + Math.abs((random.nextLong()%9000L)+1000L);

      String services="";
      if(j1.isSelected()){
        services+="ATM card";
      }
      else if(j2.isSelected()){
        services+="Internet Banking";
      }
      else if(j3.isSelected()){
        services+="Mobile Banking";
      }
      else if(j4.isSelected()){
        services+="Email & SMS alerts";
      }
      else if(j5.isSelected()){
        services+="Cheque Book";
      }
      else if(j6.isSelected()){
        services += "E-Statement";
      }

      try{
       if(acctype.equals("")){
        JOptionPane.showMessageDialog(null,"Account Type is required");
       }
       else{
        conn conn1=new conn();
        String query="insert into signup3 values('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+services+"')";
         String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
        conn1.s.executeUpdate(query);
        conn1.s.executeUpdate(query2);

        JOptionPane.showMessageDialog(null,"Card Number " + cardnumber + "\n Pin Number " + pinnumber);

        setVisible(false);
        new deposit(pinnumber).setVisible(true);
       }
      }catch(Exception e){
        System.out.println(e);
      }
    }
    else if(ae.getSource()==cancel){
        setVisible(false);
        new login().setVisible(true);
    }
  }
    public static void main(String[] args) {
        new signup3("");
    }
}

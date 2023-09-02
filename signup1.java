import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signup1 extends JFrame implements ActionListener{

    long random;
    JTextField nametext,fnametext,dobtext,emailtext,addresstext,citytext,statetext,pincodetext;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    signup1(){
        setLayout(null);

        Random ran=new Random();
        long random =Math.abs((ran.nextLong()%9000L)+1000L);
    JLabel formno= new JLabel("APPLICATION FORM NO. " + random);
    formno.setFont(new Font("Raleway",Font.BOLD,38));
    formno.setBounds(140,20,600,40);
    add(formno);
    
    JLabel personaldetails= new JLabel("Page 1: Personal Details");
    personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
    personaldetails.setBounds(290,80,400,30);
    add(personaldetails);

    JLabel name= new JLabel("Name: ");
    name.setFont(new Font("Raleway",Font.BOLD,20));
    name.setBounds(100,140,100,30);
    add(name);

    nametext=new JTextField();
    nametext.setFont(new Font("Raleway",Font.BOLD,14));
    nametext.setBounds(350, 140, 400, 30);
    add(nametext);

     JLabel fname= new JLabel("Father's Name: ");
    fname.setFont(new Font("Raleway",Font.BOLD,20));
    fname.setBounds(100,190,200,30);
    add(fname);

    fnametext=new JTextField();
    fnametext.setFont(new Font("Raleway",Font.BOLD,14));
    fnametext.setBounds(350, 190, 400, 30);
    add(fnametext);

      JLabel dob= new JLabel("Date of Birth: ");
    dob.setFont(new Font("Raleway",Font.BOLD,20));
    dob.setBounds(100,240,200,30);
    add(dob);

    dateChooser =new JDateChooser();
    dateChooser.setBounds(350, 240, 400, 30);
    dateChooser.setForeground(Color.BLACK);
    add(dateChooser);

     JLabel gender= new JLabel("Gender: ");
    gender.setFont(new Font("Raleway",Font.BOLD,20));
    gender.setBounds(100,290,200,30);
    add(gender);

    male =new JRadioButton("Male");
    male.setBounds(350, 290, 60, 30);
    male.setBackground(Color.WHITE);
    add(male);

    female =new JRadioButton("Female");
    female.setBounds(450, 290, 100, 30);
    female.setBackground(Color.WHITE);
    add(female);

    ButtonGroup gendergroup=new ButtonGroup();
    gendergroup.add(male);
    gendergroup.add(female);


    JLabel email= new JLabel("Email: ");
    email.setFont(new Font("Raleway",Font.BOLD,20));
    email.setBounds(100,340,200,30);
    add(email);

    emailtext=new JTextField();
    emailtext.setFont(new Font("Raleway",Font.BOLD,14));
    emailtext.setBounds(350, 340, 400, 30);
    add(emailtext);

    JLabel maritalstatus= new JLabel("Marital Status: ");
    maritalstatus.setFont(new Font("Raleway",Font.BOLD,20));
    maritalstatus.setBounds(100,390,200,30);
    add(maritalstatus);

    married =new JRadioButton("Married");
    married.setBounds(350, 390, 100, 30);
    married.setBackground(Color.WHITE);
    add(married);

    unmarried =new JRadioButton("Unmarried");
    unmarried.setBounds(470, 390, 100, 30);
    unmarried.setBackground(Color.WHITE);
    add(unmarried);

    other =new JRadioButton("Other");
    other.setBounds(590, 390, 100, 30);
    other.setBackground(Color.WHITE);
    add(other);

    ButtonGroup othergroup=new ButtonGroup();
    othergroup.add(married);
    othergroup.add(unmarried);
    othergroup.add(other);

     JLabel address= new JLabel("Address: ");
    address.setFont(new Font("Raleway",Font.BOLD,20));
    address.setBounds(100,440,200,30);
    add(address);

    addresstext=new JTextField();
    addresstext.setFont(new Font("Raleway",Font.BOLD,14));
    addresstext.setBounds(350, 440, 400, 30);
    add(addresstext);

     JLabel city= new JLabel("City: ");
    city.setFont(new Font("Raleway",Font.BOLD,20));
    city.setBounds(100,490,200,30);
    add(city);

    citytext=new JTextField();
    citytext.setFont(new Font("Raleway",Font.BOLD,14));
    citytext.setBounds(350, 490, 400, 30);
    add(citytext);

    JLabel state= new JLabel("State: ");
    state.setFont(new Font("Raleway",Font.BOLD,20));
    state.setBounds(100,540,200,30);
    add(state);

    statetext=new JTextField();
    statetext.setFont(new Font("Raleway",Font.BOLD,14));
    statetext.setBounds(350, 540, 400, 30);
    add(statetext);

    JLabel pincode= new JLabel("Pincode: ");
    pincode.setFont(new Font("Raleway",Font.BOLD,20));
    pincode.setBounds(100,590,200,30);
    add(pincode);

    pincodetext=new JTextField();
    pincodetext.setFont(new Font("Raleway",Font.BOLD,14));
    pincodetext.setBounds(350, 590, 400, 30);
    add(pincodetext);

    next=new JButton("Next ");
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Raleway",Font.BOLD,14));
    next.setBounds(620,660,80,30);
    next.addActionListener(this);
    add(next);

    getContentPane().setBackground(Color.WHITE);

     setSize(850,800);
     setLocation(350, 10);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       String formno="" + random;
       String name=nametext.getText();
       String fname=fnametext.getText();
       String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
       String gender=null;
       if(male.isSelected()){
        gender= "Male";
       }
       else if(female.isSelected()){
        gender="Female";
       }

       String email=emailtext.getText();
       String marital=null;
       if(unmarried.isSelected()){
        marital="Unmarried";
       }
       else if(married.isSelected()){
        marital="Married";
       }else if(other.isSelected()){
        marital="Other";
       }

       String address=addresstext.getText();
       String city=citytext.getText();
       String state=statetext.getText();
       String pin=pincodetext.getText();

       try{
         if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is Required");
         }
         else{
            conn c=new conn();
            String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query); 

            setVisible(false);
            new signup2(formno).setVisible(true);
         }
       }catch(Exception e){
        System.out.println(e);
       }


    }
    public static void main(String[] args) {
        new signup1();
    }
}

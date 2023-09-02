import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signup2 extends JFrame implements ActionListener{

    long random;
    JTextField ptext,atext;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religions,categorys,educations,incomes,occupations;
    String formno;
    signup2(String formno){
        this.formno=formno;
        setLayout(null);
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
    
    JLabel additionaldetails= new JLabel("Additional Details");
    additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
    additionaldetails.setBounds(290,80,400,30);
    add(additionaldetails);

    JLabel religion= new JLabel("Religion: ");
    religion.setFont(new Font("Raleway",Font.BOLD,20));
    religion.setBounds(100,140,100,30);
    add(religion);
     
    String valReligion[]={"Hindu","Muslim","Christian","Sikh","Other"};
    religions=new JComboBox(valReligion);
    religions.setBounds(350,140,400,30);
    religions.setBackground(Color.WHITE);
    add(religions);

     JLabel category= new JLabel("Category: ");
    category.setFont(new Font("Raleway",Font.BOLD,20));
    category.setBounds(100,190,200,30);
    add(category);

    String valcategory[]={"General","SC","ST","OBC"};
    categorys=new JComboBox(valcategory);
    categorys.setBounds(350, 190, 400, 30);
    categorys.setBackground(Color.WHITE);
    add(categorys);

    JLabel income= new JLabel("Income: ");
    income.setFont(new Font("Raleway",Font.BOLD,20));
    income.setBounds(100,240,200,30);
    add(income);

    String valincome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
    incomes=new JComboBox(valincome);
    incomes.setBounds(350, 240, 400, 30);
    incomes.setBackground(Color.WHITE);
    add(incomes);


     JLabel education= new JLabel("Educational");
    education.setFont(new Font("Raleway",Font.BOLD,20));
    education.setBounds(100,290,200,30);
    add(education);


    JLabel qualification= new JLabel("Qualification: ");
    qualification.setFont(new Font("Raleway",Font.BOLD,20));
    qualification.setBounds(100,315,200,30);
    add(qualification);

    String valeducation[]={"Non Graduate","Graduate","Post-Graduate","Doctorate","Others"};
    educations=new JComboBox(valeducation);
    educations.setBounds(350, 315, 400, 30);
    educations.setBackground(Color.WHITE);
    add(educations);

    JLabel maritalstatus= new JLabel("Occupation: ");
    maritalstatus.setFont(new Font("Raleway",Font.BOLD,20));
    maritalstatus.setBounds(100,390,200,30);
    add(maritalstatus);

    String valoccupation[]={"Salaried","Self-employed","Businessman","Student","Retired","Other"};
    occupations=new JComboBox(valoccupation);
    occupations.setBounds(350, 390, 400, 30);
    occupations.setBackground(Color.WHITE);
    add(occupations);

     JLabel pan= new JLabel("PAN Number: ");
    pan.setFont(new Font("Raleway",Font.BOLD,20));
    pan.setBounds(100,440,200,30);
    add(pan);

    ptext=new JTextField();
    ptext.setFont(new Font("Raleway",Font.BOLD,14));
    ptext.setBounds(350, 440, 400, 30);
    add(ptext);

     JLabel aadhar= new JLabel("Aadhar Number: ");
    aadhar.setFont(new Font("Raleway",Font.BOLD,20));
    aadhar.setBounds(100,490,200,30);
    add(aadhar);

    atext=new JTextField();
    atext.setFont(new Font("Raleway",Font.BOLD,14));
    atext.setBounds(350, 490, 400, 30);
    add(atext);

    JLabel senior= new JLabel("Senior Citizen: ");
    senior.setFont(new Font("Raleway",Font.BOLD,20));
    senior.setBounds(100,540,200,30);
    add(senior);

    syes=new JRadioButton("Yes");
    syes.setBounds(350, 540, 100, 30);
    syes.setBackground(Color.WHITE);
    add(syes);

    sno=new JRadioButton("No");
    sno.setBounds(460, 540, 200, 30);
    sno.setBackground(Color.WHITE);
    add(sno);

    ButtonGroup seniorgroup=new ButtonGroup();
    seniorgroup.add(syes);
    seniorgroup.add(sno);

    JLabel pincode= new JLabel("Existing Account: ");
    pincode.setFont(new Font("Raleway",Font.BOLD,20));
    pincode.setBounds(100,590,200,30);
    add(pincode);

    eyes=new JRadioButton("Yes");
    eyes.setBounds(350, 590, 100, 30);
    eyes.setBackground(Color.WHITE);
    add(eyes);

    eno=new JRadioButton("No");
    eno.setBounds(460, 590, 200, 30);
    eno.setBackground(Color.WHITE);
    add(eno);

    ButtonGroup existinggroup=new ButtonGroup();
    existinggroup.add(eyes);
    existinggroup.add(eno);

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
       String sreligion=(String)religions.getSelectedItem();
       String scategory=(String)categorys.getSelectedItem();
       String sincome=(String)incomes.getSelectedItem();
       String seducation=(String)educations.getSelectedItem();
       String soccupation=(String)occupations.getSelectedItem();
      
       String seniorc=null;
       if(syes.isSelected()){
        seniorc="Yes";
       }
       else if(sno.isSelected()){
        seniorc="No";
       }

       String existingc=null;
       if(eyes.isSelected()){
        existingc="Yes";
       }
       else if(eno.isSelected()){
        existingc="No";
       }

       String pan=ptext.getText();
       String aadhar=atext.getText();
       

       try{
            conn c=new conn();
            String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+seniorc+"','"+existingc+"')";
            c.s.executeUpdate(query); 

            setVisible(false);
            new signup3(formno).setVisible(true);;
         }
       catch(Exception e){
        System.out.println(e);
       }


    }
    public static void main(String[] args) {
        new signup2("");
    }
}

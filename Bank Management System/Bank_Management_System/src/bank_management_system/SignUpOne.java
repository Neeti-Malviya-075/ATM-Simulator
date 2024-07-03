
package bank_management_system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,AddressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    SignUpOne(){
        
        //frame
        setLayout(null);
        setSize(850,800);
        setVisible(true);
        setLocation(350,5);
        getContentPane().setBackground(Color.WHITE);
        
        //Application Number 
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel formno=new JLabel("Application Form no."+random);
        formno.setFont(new Font("raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        //personal detail one heading
        JLabel personalDetails=new JLabel("Personal Detail 1");
        personalDetails.setFont(new Font("raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        //Name subheading
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        
        //nameTextField
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        //fname
        JLabel fname=new JLabel("Father Name:");
        fname.setFont(new Font("raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        //fnameTextField
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        //dob
        JLabel dob=new JLabel("DOB:");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        //dateChooser
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        //gender
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        //genderRadioButton
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        add(female);
        
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        //email
        JLabel email=new JLabel("Email:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        //emailTextField
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        //marital status
        JLabel maritalStatus=new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("raleway",Font.BOLD,20));
        maritalStatus.setBounds(100,390,200,30);
        add(maritalStatus);
        
        //marital status radioButton
        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        add(married);
        
        unmarried=new JRadioButton("unmarried");
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
        
        other=new JRadioButton("other");
        other.setBounds(630,390,100,30);
        add(other);
        
        married.setBackground(Color.WHITE);
        unmarried.setBackground(Color.WHITE);
        
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        //Address
        JLabel Address=new JLabel("Address:");
        Address.setFont(new Font("raleway",Font.BOLD,20));
        Address.setBounds(100,440,200,30);
        add(Address);
        
        //AddressTextField
        AddressTextField=new JTextField();
        AddressTextField.setFont(new Font("raleway",Font.BOLD,14));
        AddressTextField.setBounds(300,440,400,30);
        add(AddressTextField);
        
        //city
        JLabel city=new JLabel("City:");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        //cityTextField
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        //state
        JLabel state=new JLabel("State:");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
       //stateTextField
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        //pincode
        JLabel pinCode=new JLabel("PinCode:");
        pinCode.setFont(new Font("raleway",Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);
        
         //pinTextField
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        //next button
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);
        
    }
    @Override 
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }else if(female.isSelected()){
            gender="female";
        }
        String email=emailTextField.getText();
        String maritalStatus=null;
        if(married.isSelected()){
            maritalStatus="married";
        }else if(unmarried.isSelected()){
            maritalStatus="unmarried";
        }else if(other.isSelected()){
            maritalStatus="other";
        }
        String Address=AddressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else{
                Conn c=new Conn();
               // String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+",'"+gender+"','"+email+"','"+maritalStatus+"','"+Address+"','"+city+"','"+state+"','"+pin+"');
                String query = "INSERT INTO signup (formno, name, fname, dob, gender, email, maritalStatus, Address, city, state, pin) VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + maritalStatus + "', '" + Address + "', '" + city + "', '" + state + "', '" + pin + "')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}

package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignUpThree extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignUpThree(String formno){
        this.formno=formno;
        setLayout(null);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
        //title
        JLabel l1=new JLabel("Page3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        //account type
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,120,200,30);
        add(type);
        
        //account type radio button
        r1=new JRadioButton("Saving Account");
        r1.setBackground(Color.white);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,160,250,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.white);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,160,250,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setBackground(Color.white);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,200,250,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Account");
        r4.setBackground(Color.white);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,200,250,20);
        add(r4);
        
        ButtonGroup ga=new ButtonGroup();
        ga.add(r1);
        ga.add(r2);
        ga.add(r3);
        ga.add(r4);
        
        //card number
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,250,200,30);
        add(card);
        
        //card detail
        JLabel cardDetail=new JLabel("your 16 digit card number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,280,200,30);
        add(cardDetail);
        
        //card text
        JLabel cardText=new JLabel("XXXX-XXXX-XXXX-4567");
        cardText.setFont(new Font("Raleway",Font.BOLD,22));
        cardText.setBounds(330,250,300,30);
        add(cardText);
        
        //pin number
        JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,320,200,30);
        add(pin);
        
        //pin details
        JLabel pinDetail=new JLabel("your 4 digit password");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100,350,200,30);
        add(pinDetail);
        
        
        //pin text
        JLabel pinText=new JLabel("XXXX");
        pinText.setFont(new Font("Raleway",Font.BOLD,22));
        pinText.setBounds(330,320,300,30);
        add(pinText);
        
        //services required
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,400,300,30);
        add(services);
        
        //various services
        c1=new JCheckBox("ATM card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,450,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,450,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,490,200,30);
        add(c3);
        
        c4=new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,490,200,30);
        add(c4);
        
        c5=new JCheckBox("Check Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,530,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,530,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declared that above details are correct to the best of my Knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,590,600,30);
        add(c7);
        
        //submit button
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(120,640,200,30);
        submit.addActionListener(this);
        add(submit);
        
        //cancel button        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(400,640,200,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            } else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r2.isSelected()){
                accountType="Current Account";
            }else if(r2.isSelected()){
                accountType="Recurring deposit Account";
            }
            Random random=new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5078693000000000L);
            
            String pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected()){
                facility=facility+"ATM Card";
            }else if(c2.isSelected()){
                facility=facility+"Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+"Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility+"Email and SMS Alert";
            }else if(c5.isSelected()){
                facility=facility+"Check Book";
            }else if(c6.isSelected()){
                facility=facility+"E-Statement";
            }
            try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null,"Account Type is required");
               } else{
                   Conn conn=new Conn();
                   String query1= "INSERT INTO signupthree (formno ,accountType, cardNumber, pinNumber, facility) VALUES ('"+formno+ "','"+ accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + facility +  "')";
                   String query2= "INSERT INTO login (formno , cardNumber, pinNumber) VALUES ('"+formno+ "','" + cardNumber + "', '" + pinNumber + "')";
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null, "CardNumber:"+cardNumber+"\nPinNumber:"+pinNumber);
                 
                   setVisible(false);
                   new Deposit(pinNumber).setVisible(true);
               
               }
            }catch(Exception e){
                
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }
    
}

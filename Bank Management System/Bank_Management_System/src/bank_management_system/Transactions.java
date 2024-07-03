package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,ms,pc,be,exit;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        
        //atm image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);  
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,950,600);
        add(image);
        
        //Atm inside text
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setBounds(235,170,400,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        //deposite button
        deposit=new JButton("Deposit");
        deposit.setBounds(190,260,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
       
        //Cash withdraw
        withdraw=new JButton("Cash Withdrawl");
        withdraw.setBounds(390,260,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        //fast cash
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(390,290,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        //ministatement button
        ms=new JButton("Mini Statement");
        ms.setBounds(190,290,150,30);
        ms.addActionListener(this);
        image.add(ms);
        
        //pinchange
        pc=new JButton("PIN change");
        pc.setBounds(190,320,150,30);
        pc.addActionListener(this);
        image.add(pc);
        
        //balance enquiry
        be=new JButton("Balance Enquiry");
        be.setBounds(390,320,150,30);
        be.addActionListener(this);
        image.add(be);
        
        //EXit 
        exit=new JButton("Exit");
        exit.setBounds(390,350,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setLayout(null);
        setSize(950,600);
        setLocation(100,0);
       // setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource()==pc){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource()==be){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource()==ms){
            
            new MiniStatement(pinNumber).setVisible(true);
        }
  
  
    }
    public static void main(String[] args) {
        new Transactions("");
    }
 
}

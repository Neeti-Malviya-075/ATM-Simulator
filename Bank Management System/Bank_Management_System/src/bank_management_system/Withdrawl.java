package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    JButton bk,wd;
    JTextField amount;
    String pinNumber;
    Withdrawl(String pinNumber){
        this.pinNumber=pinNumber;
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);  
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,950,600);
        add(image);
        
        //text
        JLabel text=new JLabel("Enter the Amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(200,170,700,30);
        image.add(text);
        
        //amounttextfield
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(200,210,300,30);
        image.add(amount);
        
        // deposit button
        wd=new JButton("Withdraw");
        wd.setBounds(395,300,100,30);
        wd.addActionListener(this);
        image.add(wd);
        
        // back button
        bk=new JButton("Back");
        bk.setBounds(395,340,100,30);
        bk.addActionListener(this);
        image.add(bk);
        
        setLayout(null);
        setSize(950,600);
        setLocation(100,0);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==wd){
           String number=amount.getText();
           Date date=new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null, "Amount is empty, Please Enter Amount");
               
           }else{
               try{
               Conn conn=new Conn();
               String query="insert into bank(pin,date,type,amount)values('"+pinNumber+"','"+date+"','Withdraw','"+number+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs'"+number+"' withdraw Successfully");
               setVisible(false);
               new Transactions(pinNumber).setVisible(true);
               
               }catch(Exception e){
                   
               }
        }
        }else if(ae.getSource()==bk){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
   
    public static void main(String[] args) {
        new Withdrawl("");
    }
}

    


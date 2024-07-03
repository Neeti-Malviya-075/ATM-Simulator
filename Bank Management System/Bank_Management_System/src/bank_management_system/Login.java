
package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login,signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        //frame settings
        setLayout(null);
        setSize(600,480);
        setVisible(true);
        setLocation(350,100);
        setTitle("Automatic Teller Machine");
        
        //Image settings
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        //heading text settings
        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Oswald", Font.BOLD, 40));
        text.setBounds(200,40,400,40);
        add(text);
        
        //cardno. text settings
        JLabel cardno=new JLabel("Cardno :");
        cardno.setFont(new Font("raleway",Font.BOLD,28));
        cardno.setBounds(120,150,400,30);
        add(cardno);
        
        //pin text settings
        JLabel pin=new JLabel("Pin :");
        pin.setFont(new Font("raleway",Font.BOLD,28));
        pin.setBounds(120,220,400,30);
        add(pin);
        
        //card textbox settings
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        add(cardTextField);
        
        //pin textbox settings
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        add(pinTextField);
        
        //login button settings
        login=new JButton("sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //clear button setttings
        clear=new JButton("clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        //sign up button settings
        signup=new JButton("sign up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
    }
    @Override 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardNumber=cardTextField.getText();
            String pinNumber=pinTextField.getText();
            String query="select * from login where cardNumber='"+cardNumber+"'and pin='"+pinNumber+"'";
            try{
              ResultSet rs=conn.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transactions(pinNumber).setVisible(true);
                  
              } else{
                  JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
              } 
            }catch(Exception e){
                
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
        
    }
    public static void main(String[] args) {
       new Login();
    }
    
}

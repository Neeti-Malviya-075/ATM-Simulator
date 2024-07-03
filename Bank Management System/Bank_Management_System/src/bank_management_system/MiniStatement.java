package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame {
    JLabel text,bank,card,balance;
    MiniStatement(String pinNumber){
        setLayout(null);
        setTitle("Mini Statement");
        
        text=new JLabel();
        add(text);
        
        bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,200,30);
        add(bank);
        
        card=new JLabel("card Number");
        card.setBounds(20,80,200,30);
        add(card);
        
        balance=new JLabel("card Number");
        balance.setBounds(20,400,300,30);
        add(balance);
        int bal=0;
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where pinNumber='"+pinNumber+"'");
            while(rs.next()){
                card.setText("CardNumber"+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
             }
            if(rs.getString("type").equals("deposit")){
                        bal+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal+=Integer.parseInt(rs.getString("amount"));
                    }
        }catch(Exception e){
            System.out.println(e);
        }
        
         try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from bank where pinNumber='"+pinNumber+"'");
            while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp&nbsp&nbsp&nbsp&nbsp"+rs.getString("type")+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+rs.getString("amount")+"<br><br>"+"<html>");
                        
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        text.setBounds(20,140,400,200);
        
        balance.setText("Your Current Balance is"+bal);
        setSize(400,600);
        setLocation(300,0);
        setBackground(Color.WHITE);
        setVisible(true);      
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}

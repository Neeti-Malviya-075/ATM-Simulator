package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinNumber;
    JLabel text;
    JButton back;
    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
    
        setLayout(null);
       
        //image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);  
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,950,600);
        add(image);
        
        //enter new pin
        text=new JLabel("Balance Enquiry");
        text.setForeground(Color.WHITE);
        text.setBounds(200,170,400,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
       
            Conn conn=new Conn();
            int balance=0;
            try{
                ResultSet rs=conn.s.executeQuery("select * from bank where pinNumber='"+pinNumber+"'");
               
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
            }catch(Exception e){
                        System.out.println(e);
                        }
         JLabel t=new JLabel("Your Current Balance is RS"+balance);
         t.setForeground(Color.WHITE);
         t.setBounds(200,250,300,30);
         image.add(t);
      
        //back button
        back=new JButton("back");
        back.setBounds(395,340,100,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(950,600);
        setLocation(100,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

   
    public static void main(String[] args) {
       new BalanceEnquiry("");
    }
    
}

package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
    JButton h,h_02,h5,t,t2,t10,back;
    String pinNumber;
    FastCash(String pinNumber){
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
        JLabel text=new JLabel("Please Select Your Withdrawl Amount");
        text.setForeground(Color.WHITE);
        text.setBounds(235,170,400,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        h=new JButton("Rs 100");
        h.setBounds(190,260,150,30);
        h.addActionListener(this);
        image.add(h);
       
        
        h_02=new JButton("Rs 200");
        h_02.setBounds(390,260,150,30);
        h_02.addActionListener(this);
        image.add(h_02);
        
        
        h5=new JButton("Rs 500");
        h5.setBounds(390,290,150,30);
        h5.addActionListener(this);
        image.add(h5);
        
        
        t=new JButton("Rs 1000");
        t.setBounds(190,290,150,30);
        t.addActionListener(this);
        image.add(t);
        
        
        t2=new JButton("Rs 5000");
        t2.setBounds(190,320,150,30);
        t2.addActionListener(this);
        image.add(t2);
        
        
        t10=new JButton("Rs 10000");
        t10.setBounds(390,320,150,30);
        t10.addActionListener(this);
        image.add(t10);
        
        //back
        back=new JButton("Exit");
        back.setBounds(390,350,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setLayout(null);
        setSize(950,600);
        setLocation(100,0);
       // setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn conn=new Conn();
            try{
                ResultSet rs=conn.s.executeQuery("select * from bank where pinNumber='"+pinNumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Amount Insufficiant");
                    return;
                }
                Date date=new Date();
                String query="insert into bank(pinNumber,date,type,amount)values('"+pinNumber+"','"+date+"','withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showConfirmDialog(null, "RS"+amount+"Debited Sucessfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        } 
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}

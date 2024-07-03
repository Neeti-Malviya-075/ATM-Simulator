package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField a,b;
    JLabel text,retext,atext;
    JButton back,change;
    String pinNumber;
    PinChange(String pinNumber){
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
        text=new JLabel("Change the PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(200,170,400,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        //atext
         //enter new pin
        atext=new JLabel("Enter New Pin:");
        atext.setForeground(Color.WHITE);
        atext.setBounds(200,210,150,35);
        atext.setFont(new Font("System",Font.BOLD,16));
        image.add(atext);
        
        //entering a means new pin
        a=new JPasswordField();
        a.setFont(new Font("Raleway",Font.BOLD,16));
        a.setBounds(350,210,150,30);
        image.add(a);
        
         //enter new pin
        retext=new JLabel("Re-Enter New Pin:");
        retext.setForeground(Color.WHITE);
        retext.setBounds(200,250,150,35);
        retext.setFont(new Font("System",Font.BOLD,16));
        image.add(retext);
        
        //entering a means new pin
        b=new JPasswordField();
        b.setFont(new Font("Raleway",Font.BOLD,16));
        b.setBounds(350,250,150,30);
        image.add(b);
        
        //change button
        change=new JButton("Change");
        change.setBounds(395,300,100,30);
        change.addActionListener(this);
        image.add(change);
        
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
        if(ae.getSource().equals(change)){
        try{
            String epin=a.getText();
            String repin=b.getText();
            
            if(!epin.equals(repin)){
                JOptionPane.showMessageDialog(null, "Incorrect PIN, Enter pin does not match");
                return;
            }
            else if(!epin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Your New PIN");
                return;
            }else if(!repin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-Enter Your New PIN");
                return;
            }
            Conn conn=new Conn();
            String query1="Update bank pinNumber='"+repin+"' where pinNumber='"+pinNumber+"'";
            String query2="Update login pinNumber='"+repin+"' where pinNumber='"+pinNumber+"'";
            String query3="Update signupthree pinNumber='"+repin+"' where pinNumber='"+pinNumber+"'";
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);        
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN change Successfull");
            
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
          setVisible(false);
          new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
    
}

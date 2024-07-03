package bank_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField panBox,adhaarBox;
    JButton next;
    JRadioButton yes,no;
    JComboBox religionBox,categoryBox,incomeBox,eduBox,occBox;
    String formno;
    
    SignUpTwo(String formno){
        this.formno=formno;
        //frame
        setLayout(null);
        setSize(850,800);
        setVisible(true);
        setLocation(350,5);
        getContentPane().setBackground(Color.WHITE);
        
        //Application title
        setTitle("NEW ACCOUNT APPLICATION FORM -- PAGE-2");
        
        //additional detail heading
        JLabel additionalDetails=new JLabel("Additional Detail 1");
        additionalDetails.setFont(new Font("raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        //Religion subheading
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("raleway",Font.BOLD,20));
        religion.setBounds(100,140,200,30);
        add(religion);
        
        //religionJComboBox
        String[] valReligion={"Hindu","Shikki","Christan","Muslim","other"};
        religionBox=new JComboBox(valReligion);
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.white);
        add(religionBox);
        
        //category
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        //categoryBox
        String[] categories={"General","OBC","SC","ST","other"};
        categoryBox=new JComboBox(categories);
        categoryBox.setBounds(300,190,400,30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        
        //income
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        //incomebox
        String[] incomeVal={"null","<1,50,000","<2,50,000","<3,50,000","<5,00,000","<7,50,000","10,00,000 and above"};
        incomeBox=new JComboBox(incomeVal);
        incomeBox.setBounds(300,240,400,30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        
        //education qualification
        JLabel educational=new JLabel("Educational");
        educational.setFont(new Font("raleway",Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        //educationbox
        String[] eduVal={"Non-Graduation","Graduation","post-Graduation","PHD","other"};
        eduBox=new JComboBox(eduVal);
        eduBox.setBounds(300,315,400,30);
        eduBox.setBackground(Color.WHITE);
        add(eduBox);
        
        //occupation
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        //occupationbox
        String[] occVal={"salaried","self-employeed","Bussinessman","retired"};
        occBox=new JComboBox(occVal);
        occBox.setBounds(300,390,400,30);
        occBox.setBackground(Color.WHITE);
        add(occBox);
       
        //PAN NUMBER
        JLabel pan=new JLabel("PAN number:");
        pan.setFont(new Font("raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        //PANBox
        panBox=new JTextField();
        panBox.setFont(new Font("raleway",Font.BOLD,14));
        panBox.setBounds(300,440,400,30);
        add(panBox);
        
        //Aadhaar number
        JLabel aadhaar=new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("raleway",Font.BOLD,20));
        aadhaar.setBounds(100,490,200,30);
        add(aadhaar);
        
        //AadhaarBox
        adhaarBox=new JTextField();
        adhaarBox.setFont(new Font("raleway",Font.BOLD,14));
        adhaarBox.setBounds(300,490,400,30);
        add(adhaarBox);
        
        //account exist
        JLabel existing=new JLabel("Existing Account:");
        existing.setFont(new Font("raleway",Font.BOLD,20));
        existing.setBounds(100,540,200,30);
        add(existing);
        
       //account exist box
        yes=new JRadioButton("Yes");
        yes.setBounds(300,540,100,30);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(450,540,100,30);
        add(no);
        
        
        yes.setBackground(Color.WHITE);
        no.setBackground(Color.WHITE);
        
        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(yes);
        accountGroup.add(no);
       
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
        String sReligion=(String)religionBox.getSelectedItem();
        String sCategory=(String)categoryBox.getSelectedItem();
        String sIncome=(String)incomeBox.getSelectedItem();
        String sEdu=(String)eduBox.getSelectedItem();
        String sOcc=(String)occBox.getSelectedItem();
        String sPan=panBox.getText();
        String sAdhaar=adhaarBox.getText();
        String sExist=null;
        if(yes.isSelected()){
            sExist="Yes";
        }else if(no.isSelected()){
            sExist="No";
        }
        
        try{
            if(sPan.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else{
                Conn c=new Conn();
                String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, PAN_no, aadhaar_no, existing_account) VALUES ('" + formno + "', '" + sReligion + "', '" + sCategory + "', '" + sIncome + "', '" + sEdu + "', '" + sOcc + "', '" + sPan + "', '" + sAdhaar + "', '" + sExist + "')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}

    


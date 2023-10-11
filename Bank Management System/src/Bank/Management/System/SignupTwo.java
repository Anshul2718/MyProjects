package Bank.Management.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField, addharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno, other;
    JComboBox<String> religionCombBox, categoryComboBox, incomeComboBox, eduQualifComboBox,occupComboBox;
    String formno;

    SignupTwo(String formno){
        this.formno = formno;

        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionDetails = new JLabel("Page 2: Additional Details");
        additionDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionDetails.setBounds(290,80,300,30);
        add(additionDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,200,30);
        add(religion);
        
        String valReligion [] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionCombBox  = new JComboBox<>(valReligion);
        religionCombBox.setBounds(300,140,400,30);
        religionCombBox.setFont(new Font("Raleway",Font.BOLD,14));
        religionCombBox.setBackground(Color.WHITE);
        add(religionCombBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String valCategory [] = {"General","OBC","SC","ST","Other"};
        categoryComboBox = new JComboBox<>(valCategory);
        categoryComboBox.setBounds(300,190,400,30);
        categoryComboBox.setFont(new Font("Raleway",Font.BOLD,14));
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valIncome [] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomeComboBox = new JComboBox<>(valIncome);
        incomeComboBox.setBounds(300,240,400,30);
        incomeComboBox.setFont(new Font("Raleway",Font.BOLD,14));
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String valEduQualif [] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        eduQualifComboBox = new JComboBox<>(valEduQualif);
        eduQualifComboBox.setFont(new Font("Raleway",Font.BOLD,14));
        eduQualifComboBox.setBounds(300,315,400,30);
        eduQualifComboBox.setBackground(Color.WHITE);
        add(eduQualifComboBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,365,200,30);
        add(occupation);

        String valOccup [] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupComboBox = new JComboBox<>(valOccup);
        occupComboBox.setFont(new Font("Raleway",Font.BOLD,14));
        occupComboBox.setBounds(300,365,400,30);
        occupComboBox.setBackground(Color.WHITE);
        add(occupComboBox);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,415,200,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,415,400,30);
        add(panTextField);

        JLabel addhar = new JLabel("Addhar Number:");
        addhar.setFont(new Font("Raleway",Font.BOLD,20));
        addhar.setBounds(100,465,200,30);
        add(addhar);

        addharTextField = new JTextField();
        addharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addharTextField.setBounds(300,465,400,30);
        add(addharTextField);

        JLabel senCitz = new JLabel("Senior Citizen:");
        senCitz.setFont(new Font("Raleway",Font.BOLD,20));
        senCitz.setBounds(100,515,200,30);
        add(senCitz);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,515,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,515,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup senCitzGroup = new ButtonGroup();
        senCitzGroup.add(syes);
        senCitzGroup.add(sno);
        
        JLabel eAccount = new JLabel("Exisiting Account:");
        eAccount.setFont(new Font("Raleway",Font.BOLD,20));
        eAccount.setBounds(100,565,200,30);
        add(eAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,565,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,565,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup eAcctGroup = new ButtonGroup();
        eAcctGroup.add(syes);
        eAcctGroup.add(sno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,650,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        String religion = (String)religionCombBox.getSelectedItem();
        String category = (String)categoryComboBox.getSelectedItem();
        String income = (String)incomeComboBox.getSelectedItem();
        String eduQualif = (String)eduQualifComboBox.getSelectedItem();
        String occupation = (String)occupComboBox.getSelectedItem();
        String pan = panTextField.getText();
        String adhhar = addharTextField.getText();
        String senCitz = null;
        if(syes.isSelected()) senCitz = "Yes";
        else if(sno.isSelected()) senCitz = "No";
        String eAccount = null;
        if(eyes.isSelected()) eAccount = "Yes";
        else if(eno.isSelected()) eAccount = "No";

        try{
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null, "Religion is Required");
            }else if(category.equals("")){
                JOptionPane.showMessageDialog(null,"Category is Required");
            }else if(income.equals("")){
                JOptionPane.showMessageDialog(null,"Income is Required");
            }else if(eduQualif.equals("")){
                JOptionPane.showMessageDialog(null,"Edu.Qualification is Required");
            }else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null,"Occupation is Required");
            }else if(pan.equals("")){
                JOptionPane.showMessageDialog(null,"Pan Card No. is Required");
            }else if(adhhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Card No. is Required");
            }else if(senCitz.equals("")){
                JOptionPane.showMessageDialog(null,"Senior Citizen Status is Required");
            }else if(eAccount.equals("")){
                JOptionPane.showMessageDialog(null,"Exisiting Account Status is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into singuptwo values ('"+formno+"','"+religion+"','"+category+"','"+income+"','"+eduQualif+"','"+occupation+"','"+pan+"','"+adhhar+"','"+senCitz+"','"+eAccount+"')";
                c.s.executeUpdate(query);

                //Signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
    
}

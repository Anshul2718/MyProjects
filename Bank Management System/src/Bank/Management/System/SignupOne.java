package Bank.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{

    JTextField nameTextField, fnameTextField, emailTextField, addTextField, cityTextField, 
    stateTextField, pinCTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, other;

    Random ran = new Random();
    Long random = Math.abs((ran.nextLong()%9000L)+1000L);


    SignupOne(){

        setLayout(null);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,250,30);
        add(personDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(male);
        gendeGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600,390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);
        marriedGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addTextField.setBounds(300,440,400,30);
        add(addTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinCTextField = new JTextField();
        pinCTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinCTextField.setBounds(300,590,400,30);
        add(pinCTextField);

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
        String formno = ""+random; // long
        String name = nameTextField.getText(); //setText
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) gender = "Male";
        else if(female.isSelected()) gender = "Female";
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()) marital = "Married";
        else if(unmarried.isSelected()) marital = "Unmarried";
        else if(other.isSelected()) marital = "Other";
        String address = addTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinCTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father Name is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender is Required");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }else if(marital.equals("")){
                JOptionPane.showMessageDialog(null,"Marital Status is Required");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"city is Required");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into singup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                Conn conn = new Conn();
                conn.s.close();
            }catch (Exception e){
                System.out.println(e);

            }

        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }
    
}

package Bank.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{

    JButton fc100,fc500,fc1000,fc2000,fc5000,fc10000,exit;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        image.add(text);

        fc100 = new JButton("Rs.100");
        fc100.setBounds(160,455,150,30);
        fc100.addActionListener(this);
        image.add(fc100);

        fc500 = new JButton("Rs.500");
        fc500.setBounds(360,455,150,30);
        fc500.addActionListener(this);
        image.add(fc500);

        fc1000 = new JButton("Rs.1000");
        fc1000.setBounds(160,490,150,30);
        fc1000.addActionListener(this);
        image.add(fc1000);

        fc2000 = new JButton("Rs.2000");
        fc2000.setBounds(360,490,150,30);
        fc2000.addActionListener(this);
        image.add(fc2000);

        fc5000 = new JButton("Rs.5000");
        fc5000.setBounds(160,525,150,30);
        fc5000.addActionListener(this);
        image.add(fc5000);

        fc10000 = new JButton("Rs.10000");
        fc10000.setBounds(360,525,150,30);
        fc10000.addActionListener(this);
        image.add(fc10000);

        exit = new JButton("Back");
        exit.setBounds(360,560,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select*from bank where pin ='"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!= exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Sucessfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
                
            }finally {
                try {
                    conn.s.close();
                }catch (Exception e){
                    System.out.println(e);

                }

            }
        }

    }
    public static void main(String[] args) {
        new FastCash("");
    }
}


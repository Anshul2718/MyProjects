package Bank.Management.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdrawal,fastCash,mStatement,pinchange,bEnquiery,exit;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215,320,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(160,455,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash withdrawal");
        withdrawal.setBounds(360,455,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160,490,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        mStatement = new JButton("Mini Statement");
        mStatement.setBounds(360,490,150,30);
        mStatement.addActionListener(this);
        image.add(mStatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(160,525,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        bEnquiery = new JButton("Balance Enquiry");
        bEnquiery.setBounds(360,525,150,30);
        bEnquiery.addActionListener(this);
        image.add(bEnquiery);

        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==bEnquiery){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==mStatement){
            new MiniStatement(pinnumber).setVisible(true);
        }


    }
    public static void main(String[] args) {
        new Transactions("");
    }
    
}

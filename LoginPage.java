package Employee_management;

import javax.swing.JFrame;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    LoginPage(){
        f=new JFrame("Login");
        f.setSize(600,250);
        f.setVisible(true);
        f.setBackground(Color.WHITE);
        f.setLayout(null); 

        l1=new JLabel("UserName");
        l1.setBounds(40, 20, 100,30);
        f.add(l1);

        l2=new JLabel("Password");
        l2.setBounds(40, 70, 100,30);
        f.add(l2);

        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Employee_management/icon/lock.jfif"));
        Image i2=i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel l3=new JLabel(i3);
        l3.setBounds(360, 20, 150, 150);
        f.add(l3);

        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,140,120,30);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Close");
        b2.setBackground(Color.BLACK);
        b2.setBounds(180,140,120,30);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        f.add(b2);
      
       

       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
         try{
            ConnectionClass obj=new ConnectionClass();
            String name=t1.getText();
            String pass=t2.getText();
            String q="select * from Logindata where username='"+name+"' and password='"+pass+"'";
            ResultSet rs=obj.stm.executeQuery(q);
            if(rs.next()){
               new HomePage().setVisible(true);
               this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"You have entered wrong username and password !");
                f.setVisible(false);
                f.setVisible(true);
            }
        }
        catch(Exception exception){
         exception.getMessage();
        }
    }
       if(e.getSource()==b2){
          f.setVisible(false);
        }
       }

    public static void main(String[] args) {
        new LoginPage();
    }

    
    
}

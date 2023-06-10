package Employee_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class View_Employee  extends JFrame implements ActionListener{

    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;
    View_Employee(){
        f=new JFrame("View Employee");
        f.setBackground(Color.GREEN);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0, 0, 500, 300);
        l1.setLayout(null);

      ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_management/icon/5.png"));
      Image i1=img.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i1);
      l1.setIcon(i3);
      f.add(l1);

      l2=new JLabel("Employee Id");
      l2.setVisible(true);
      l2.setBounds(40, 60, 250, 30);
      l2.setBackground(Color.BLACK);
      Font f1=new Font("Airal",Font.BOLD,30);
      l2.setFont(f1);
      l1.add(l2);
      f.add(l1);

      t=new JTextField();
      t.setBounds(240, 60, 220, 30);
      l1.add(t);
     
      b=new JButton("Search");
      b.setBounds(140, 150, 100, 30);
      b.addActionListener(this);
      l1.add(b);

      b2=new JButton("Cancel");
      b2.setBackground(Color.red);
      b2.setForeground(Color.white);
      b2.setBounds(260,150,100,30);
      b2.addActionListener(this);
      l1.add(b2);


      f.setSize(500, 300);
      f.setLocation(400,100);
      f.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b){
          f.setVisible(false);
         new View_Employee_Data(Integer.parseInt(t.getText()));

       }
       if(e.getSource()==b2){
        f.setVisible(false);
        new HomePage();
       }
    }
    public static void main(String[] args) {
        new View_Employee();
    }
    

    
}

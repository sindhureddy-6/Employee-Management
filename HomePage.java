package Employee_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f,f1,f2;
    JPanel p1;

    HomePage()
    {
        super("Employee Home Page");
        setLocation(0,0);
        setSize(1550,800);

        f=new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,18);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Employee_management/icon/home.jpg"));
        Image img=ic.getImage().getScaledInstance(1550, 800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);

        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Profile");
        JMenuItem ment1=new JMenuItem("Complete Profile");
        JMenuItem ment2=new JMenuItem("View Profile");
        men1.add(ment1);
        men1.add(ment2);

        JMenu men2=new JMenu("Manage");
        JMenuItem ment3=new JMenuItem("Update Details");
        men2.add(ment3);

        JMenu men3=new JMenu("Attendance");
        JMenuItem ment5=new JMenuItem("Take Attendance");
        JMenuItem ment6=new JMenuItem("View Attendance");
        men3.add(ment5);
        men3.add(ment6);

        JMenu men4=new JMenu("Leave");
        JMenuItem ment7=new JMenuItem("Apply Leave");
        JMenuItem ment8=new JMenuItem("View Leaves");
        men4.add(ment7);
        men4.add(ment8);
        
        JMenu men5=new JMenu("Salary");
        JMenuItem ment9=new JMenuItem("Add Salary");
        JMenuItem ment10=new JMenuItem("Generate Salary Slip");
        men5.add(ment9);
        men5.add(ment10);

        JMenu men7=new JMenu("Delete");
        JMenuItem ment12=new JMenuItem("Delete Employee");
        men7.add(ment12);

        JMenu men6=new JMenu("Exit");
        JMenuItem ment11=new JMenuItem("Logout");
        men6.add(ment11);

        m1.add(men1); 
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men7);
        m1.add(men6);
         

        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);

        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment11.setFont(f1);
        ment12.setFont(f1);
         
        m1.setBackground(Color.BLACK);

        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men6.setForeground(Color.RED);
        men7.setForeground(Color.GRAY);
        
        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment7.setBackground(Color.BLACK);
        ment8.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment10.setBackground(Color.BLACK);
        ment11.setBackground(Color.BLACK);
        ment12.setBackground(Color.BLACK);

        ment1.setForeground(Color.GREEN);
        ment2.setForeground(Color.GREEN);
        ment3.setForeground(Color.GREEN);
        ment5.setForeground(Color.GREEN);
        ment6.setForeground(Color.GREEN);
        ment7.setForeground(Color.GREEN);
        ment8.setForeground(Color.GREEN);
        ment9.setForeground(Color.GREEN);
        ment10.setForeground(Color.GREEN);
        ment11.setForeground(Color.GREEN);
        ment12.setForeground(Color.GREEN);

        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        ment12.addActionListener(this);

         setJMenuBar(m1);
         add(l1);
         setVisible(true);
 }
    @Override
    public void actionPerformed(ActionEvent e) {

        String comnd=e.getActionCommand();
        if(comnd.equals("Complete Profile")){
            new Add_Employee();
         
        }
        else if(comnd.equals("View Profile")){
            new View_Employee();
        }
        else if(comnd.equals("Update Details")){
            new Update_Details_Data().setVisible(true);
        }
        else if(comnd.equals("Take Attendance")){
            new Employee_Attendance().setVisible(true);
        }
        else if(comnd.equals("View Attendance")){
            new View_Attendance().setVisible(true);
        }
        else if(comnd.equals("Apply Leave")){
            new Apply_Leave().setVisible(true);
        }
        else if(comnd.equals("View Leaves")){
            new View_Leaves().setVisible(true);
        }
        else if(comnd.equals("Add Salary")){
            new Salary().setVisible(true);
        }
        else if(comnd.equals("Generate Salary Slip")){
            new Generate_PaySlip().setVisible(true);
        }
        else if(comnd.equals("Delete Employee")){
            new Delete_Employee().setVisible(true);
        }
        else if(comnd.equals("Logout")){
             System.exit(0);
        }
    }

    
    public static void main(String[] args) {
        new HomePage().setVisible(true);

    }


}

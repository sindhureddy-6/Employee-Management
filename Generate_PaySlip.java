package Employee_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Generate_PaySlip extends JFrame implements ActionListener {

    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextArea ta;
    Choice ch1,ch2,ch3;
    JPanel p1;
    Font f;
    
    Generate_PaySlip(){
        super("Generate Pay Slip");
        setSize(500,500);
        setLocation(100,100);
        setResizable(false);
        f=new Font("arial",Font.BOLD,16);

        l1=new JLabel("Employee Id");
        l2=new JLabel("Month");
        l3=new JLabel("Year");

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);

        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();


        try {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from employee";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch1.add(rest.getString("Eid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        ch2.add("January");
        ch2.add("Febraury");
        ch2.add("March");
        ch2.add("April");
        ch2.add("May");
        ch2.add("June");
        ch2.add("July");
        ch2.add("August");
        ch2.add("September");
        ch2.add("October");
        ch2.add("November");
        ch2.add("December");

        ch3.add("2016");
        ch3.add("2017");
        ch3.add("2018");
        ch3.add("2019");
        ch3.add("2020");
        ch3.add("2021");
        ch3.add("2022");
        ch3.add("2023");

        ch1.setFont(f);
        ch2.setFont(f);
        ch3.setFont(f);
        b1=new JButton("Print");
        b2=new JButton("Close");

        b1.setFont(f);
        b2.setFont(f);

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b1.setForeground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(4,2,10,10));
        p1.add(l1);
        p1.add(ch1);
        p1.add(l2);
        p1.add(ch2);
        p1.add(l3);
        p1.add(ch3);
        p1.add(b1);
        p1.add(b2);


ta=new JTextArea();
JScrollPane sp=new JScrollPane(ta);
ta.setEditable(false);
ta.setFont(f);

setLayout(new BorderLayout());
add(sp,"Center");
add(p1,"South");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1){
         ta.setText("-----------------Pay Slip-------------------");
         try {
            ConnectionClass obj1=new ConnectionClass();
            String id=ch1.getSelectedItem();
            String month_year=ch2.getSelectedItem()+" "+ch3.getSelectedItem();
            String q1="select * from employee where Eid='"+id+"'";
            ResultSet rest1=obj1.stm.executeQuery(q1);
            while(rest1.next()){
                ta.append("\n\nEmployee ID : "+Integer.parseInt(rest1.getString("Eid")));
                ta.append("\nEmployee Name : "+rest1.getString("name"));
                ta.append("\nEmployee Email : "+rest1.getString("email"));
                ta.append("\n------------------------------------------------\n");
             }
         String q2="select * from Salary where month_year='"+month_year+"' and Eid='"+id+"'";
         ResultSet rest2=obj1.stm.executeQuery(q2);
         //ResultSet rest3=obj1.stm.executeQuery(q2);

         if(rest2.next()==false){
            ta.append("\n------------------------------------------------\n\n");
            ta.append("Records not found of this month and year.\n");
            ta.append("\n------------------------------------------------\n\n");
            ta.append("Please add the salary of this month and year for this record.\n");
         }
         else{
            do{
                ta.append("\n\nHRA : "+Float.parseFloat(rest2.getString("hra")));
                ta.append("\nDA : "+Float.parseFloat(rest2.getString("da")));
                ta.append("\nMID : "+Float.parseFloat(rest2.getString("hra")));
                ta.append("\nPF : "+Float.parseFloat(rest2.getString("pf")));
                ta.append("\nBASIC SALARY : "+Float.parseFloat(rest2.getString("Basic")));
             
             ta.append("\n----------------------------------------------\n");
             float gross_salary=Float.parseFloat(rest2.getString("hra"))+Float.parseFloat(rest2.getString("da"))+Float.parseFloat(rest2.getString("mid"))+Float.parseFloat(rest2.getString("pf"))+Float.parseFloat(rest2.getString("Basic"));
             double tax=(gross_salary*2.1)/100;
             ta.append("\nGross Salary : "+gross_salary+"");
             ta.append("\nTotal : "+gross_salary+"");
             ta.append("\nTax 2.1% of Salary : "+tax+"");
             ta.append("\n----------------------------------------------\n");

            }
             while(rest2.next()) ;
        }
        }


          catch (Exception e1) {
           e1.printStackTrace();
         }
       }
       if(e.getSource()==b2){
        JOptionPane.showMessageDialog(null,"Are you sure?");
        setVisible(false);
       }
    }

    public static void main(String[] args) {
        new Generate_PaySlip().setVisible(true);
    }
    
}

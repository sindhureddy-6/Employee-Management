package Employee_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_Attendance_Single extends JFrame  {
    JTable t;
    String x[]={"Employee ID","Name","Email","First Half","Second Half","date" };
    String y[][]=new String [20][6];
    int i=0,j=0;
    Font f,f1;
    int count=0;
    View_Attendance_Single(String eid){
        super("Particular Employee Attendance Records");
        setSize(1480,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);

        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select * from attendance where Id='"+eid+"'";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                count++;
                y[i][j++]=rest.getString("Id");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("first_half");
                y[i][j++]=rest.getString("second_half");
                y[i][j++]=rest.getString("date");
                i++;
                j=0;
                
            }
            if(count==0){
                JOptionPane.showMessageDialog(null,"No Records Found");
                this.setVisible(false);

            }
            else{
                t=new JTable(y,x);
                t.setBackground(Color.BLACK);
                t.setForeground(Color.WHITE);
                t.setFont(f);
                setSize(1480, 400);
                setLocation(0,10);
                JScrollPane js=new JScrollPane(t);
                add(js);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
  
}

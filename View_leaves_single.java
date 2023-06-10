package Employee_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_leaves_single extends JFrame  {
    JTable t;
    String x[]={"Employee ID","Name","Email","Start Date","End Date","Reason","Apply Date" };
    String y[][]=new String [20][7];
    int i=0,j=0;
    Font f,f1;
    int count=0;
    View_leaves_single(String eid){
        super("Particular Employee Leave Records");
        setSize(1480,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);

        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select * from Apply_Leave where Eid='"+eid+"'";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                count++;
                y[i][j++]=rest.getString("Eid");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("start_date");
                y[i][j++]=rest.getString("end_date");
                y[i][j++]=rest.getString("reason");
                y[i][j++]=rest.getString("apply_date");

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

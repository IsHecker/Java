package Project;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class app extends javax.swing.JFrame {
    TableShit tab=new TableShit();
    
    public app(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(460,200);
        setVisible(true); 
        setTitle("jTable Column Header Frame");
    }
}
public class SetColumnHeader  {
    public static void main(String args[]){
        
        app a=new app();
    }
}
 class TableShit{
  
    Connection connect;
    Statement stat;
    ResultSet rs;
    DefaultTableModel model;
    
  public TableShit()
  {
    JPanel panel = new JPanel();
    String col[] = {"ISBN","title","booktype","pcount","price"};
    model = new DefaultTableModel(null,col);
    JTable table = new JTable(5,5);
    table.setModel(model);
    JTableHeader header = table.getTableHeader();
    header.setBackground(Color.yellow);
    JScrollPane pane = new JScrollPane(table);
    panel.add(pane);
    DataBaseConnection("Books");
  }
  public void DataBaseConnection(String tableName){
        
        String path="jdbc:sqlserver://localhost;databaseName=DBConnection;";
        String user="mohamed";
        String pass="football";
        
        try{
            connect= DriverManager.getConnection(path,user,pass);
            stat= connect.createStatement();
            rs=stat.executeQuery("select * from "+tableName+"");
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt("ISBN"),rs.getString("title"),rs.getString("booktype"),rs.getInt("pcount"),rs.getInt("price")});
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
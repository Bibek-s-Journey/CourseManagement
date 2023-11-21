import java.sql.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

import java.lang.Exception;;

public class Enrolled_Course {
    private static JFrame frame = new JFrame();
    private int user__ID;
    private JTable jt = new JTable();
    private boolean isloggedIn = false;
    public Enrolled_Course(boolean logged,int User_Id) {
        this.user__ID = User_Id;
        this.isloggedIn = logged;
        JMenuBar menubar = new JMenuBar();

        menubar.add(new CourseMenu(this.isloggedIn, this.user__ID).CourseList());
        menubar.add(new My_DashBoard().Profile(this.isloggedIn, this.user__ID));
        menubar.add(new User_Home().HomePage(this.isloggedIn, this.user__ID));
        frame.setTitle("Enrolled Details");
        frame.setLocation(500, 100);
        frame.setSize(500, 500);


        jt.setBounds(200, 300, 200, 300);
        jt.setVisible(true);
        JScrollPane sp = new JScrollPane(jt);
        frame.add(sp);

        frame.setJMenuBar(menubar);
        frame.setTitle("My Details");
        frame.setBounds(20, 10, 800, 580);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            Connection con = Database.Connect();
            String query = Query.Read_courses();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            DefaultTableModel model = (DefaultTableModel) jt.getModel();
            String column[] = { "Code", "Courses" };
            model.setColumnIdentifiers(column);
            while (rs.next()) {
                int Current_UserId = rs.getInt(1);
                if (Current_UserId == this.user__ID) {
                    String Course_code = rs.getString(2);
                    String courses = rs.getString(3);
                    String[] row = { Course_code, courses };
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Enrolled_Course(true, 1);
    }
}

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.lang.Exception;;

class User_Home implements ActionListener {
    private int ID;
    private boolean isloggedin = false;
    public JMenu HomePage(boolean logged_in,int User_id) {
        this.isloggedin = logged_in;
        this.ID = User_id;
        JMenu Dashborad = new JMenu("Dashboard");
        JMenuItem dash = new JMenuItem("Home page");
        dash.addActionListener(this);
        Dashborad.setFont(new Font("Arial", Font.BOLD, 16));
        Dashborad.add(dash);
        return Dashborad;
    }

    public void actionPerformed(ActionEvent e) {
        new User_DashBoard(isloggedin,ID);
    }
}
public class UserDetails {
    private static JFrame frame = new JFrame();
    private int user__ID;
    private boolean isloggedin = false;

    public UserDetails(boolean logged, int User_Id) {
        this.isloggedin = logged;
        this.user__ID = User_Id;
        try {
            Connection con = Database.Connect();
            String query = Query.Read();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int Current_UserId = rs.getInt(1);
                if (Current_UserId == User_Id) {
                    String User_Fullname = rs.getString(2);
                    String Username = rs.getString(3);
                    String User_email = rs.getString(4);
                    String Gender = rs.getString(6);
                    Display_Details(User_Fullname, Username, User_email, Gender);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Display_Details(String Fullname, String Username, String user_email, String Gender) {
        JMenuBar menubar = new JMenuBar();

        menubar.add(new CourseMenu(this.isloggedin,this.user__ID).CourseList());
        menubar.add(new My_DashBoard().Profile(this.isloggedin,this.user__ID));
        menubar.add(new User_Home().HomePage(this.isloggedin,this.user__ID));
        
        frame.setTitle("User Details");
        frame.setLocation(500, 100);
        frame.setSize(500, 500);
        frame.setLayout(null);

        Font font = new Font("Arial", Font.ITALIC, 20);
        Font text_font = new Font("Arial", Font.BOLD, 16);
        Container c = frame.getContentPane();
        c.setLayout(null);

        JLabel Sign_up = new JLabel("My Details");
        Sign_up.setFont(new Font("Arial",Font.BOLD,25));
        Sign_up.setBounds(140,20,200,50);
        c.add(Sign_up);

        // Name section
        JLabel name = new JLabel(Fullname);
        JLabel FullName = new JLabel("Full Name");
        FullName.setBounds(80, 75, 100, 50);
        FullName.setFont(font);
        c.add(FullName);
        name.setBounds(200, 85, 150, 30);
        name.setFont(text_font);
        name.setVisible(true);
        c.add(name);

        // Gender section
        JLabel user_Gender = new JLabel(Gender);
        user_Gender.setBounds(200, 130, 82, 30);
        user_Gender.setVisible(true);
        c.add(user_Gender);
        JLabel gender = new JLabel("Gender");
        gender.setBounds(80, 120, 100, 50);
        gender.setFont(font);
        c.add(gender);
        
        

        // username section
        JLabel text = new JLabel(Username);
        JLabel label1 = new JLabel("Username");
        label1.setBounds(80, 165, 100, 50);
        label1.setFont(font);
        label1.setOpaque(true);
        c.add(label1);
        text.setBounds(200, 175, 150, 30);
        text.setFont(text_font);
        text.setVisible(true);
        c.add(text);
        
        
        // Email section
        JLabel email = new JLabel(user_email);
        JLabel Email = new JLabel("Email");
        Email.setFont(font);
        Email.setBounds(80,210,100,50);
        c.add(Email);
        email.setBounds(200,220,150,30);
        email.setFont(text_font);
        email.setVisible(true);
        c.add(email);


        frame.setJMenuBar(menubar);
        frame.setTitle("My Details");
        frame.setBounds(20, 10, 800, 580);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

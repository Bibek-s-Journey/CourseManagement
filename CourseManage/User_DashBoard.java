import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class My_DashBoard implements ActionListener{
    private JMenuItem user_Details = null;
    private JMenuItem user_EnrolledCourse = null;
    private int My_ID;
    private boolean IsloggedIn = false;
    public JMenu Profile(boolean logged,int User_id) {
        this.My_ID = User_id;
        this.IsloggedIn = logged;
        JMenu Courses = new JMenu("Profile");
        Courses.setFont(new Font("Arial", Font.BOLD, 16));
        user_Details = new JMenuItem("Your Details");
        user_Details.addActionListener(this);
        user_EnrolledCourse = new JMenuItem("Enrolled Courses");
        user_EnrolledCourse.addActionListener(this);
        Courses.add(user_Details);
        user_Details.addActionListener(this);
        Courses.add(user_EnrolledCourse);
        user_EnrolledCourse.addActionListener(this);
        return Courses;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.user_Details) {
            new UserDetails(this.IsloggedIn,this.My_ID);
        }else{
            new Enrolled_Course(this.IsloggedIn, this.My_ID);
        }
    }
}
public class User_DashBoard{
    JFrame frame = new JFrame();
    private int My_ID;
    private boolean IsloggedIn = false;

    public User_DashBoard(boolean loggedIn,int User_id) {
        this.My_ID = User_id;
        this.IsloggedIn = loggedIn;

        JMenuBar menubar = new JMenuBar();

        menubar.add(new CourseMenu(this.IsloggedIn,this.My_ID).CourseList());
        menubar.add(new My_DashBoard().Profile(this.IsloggedIn,this.My_ID));
        frame.setJMenuBar(menubar);

        //Image of Home page
        ImageIcon img = new ImageIcon(
                "C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\Dashborad.png");
        frame.add(new JLabel(img));
        frame.pack();

        frame.setTitle("Student Home Page");
        frame.setBounds(20, 10, 800, 580);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

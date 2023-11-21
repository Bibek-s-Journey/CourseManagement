import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CourseMenu implements ActionListener {
    JMenuItem item = null;
    JMenuItem item1 = null;
    private int user_id;
    private boolean isloggedin = false;

    public CourseMenu(boolean logged, int id) {
        this.user_id = id;
        this.isloggedin = logged;
    }
    public JMenu CourseList() {
        JMenu Courses = new JMenu("Courses");
        Courses.setFont(new Font("Arial", Font.BOLD, 16));
        item = new JMenuItem("Available Courses");
        item1 = new JMenuItem("Upcomming Courses");
        Courses.add(item);
        item.addActionListener(this);
        Courses.add(item1);
        item1.addActionListener(this);
        return Courses;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item) {
            new AvailableCourses(this.isloggedin,this.user_id);
        } else {
            new Upcomming_Courses();
        }
    }

}

class LogMenu implements ActionListener {
    public JMenu LogOption() {
        JMenu LogIn = new JMenu("LogIn");
        LogIn.setFont(new Font("Arial", Font.BOLD, 16));
        JMenuItem google = new JMenuItem("Google");
        JMenuItem Facebook = new JMenuItem("Facebook");
        JMenuItem Normal_log = new JMenuItem("Username");
        LogIn.add(Normal_log);
        LogIn.add(google);
        LogIn.add(Facebook);
        Normal_log.addActionListener(this);
        return LogIn;
    }
    public void actionPerformed(ActionEvent e) {
        LoginForm Lf = new LoginForm();
    }
    
}

class SignMenu implements ActionListener {
    public JMenu SignUp_Option() {
        JMenu SignUp = new JMenu("SignUp");
        SignUp.setFont(new Font("Arial", Font.BOLD, 16));
        JMenuItem google = new JMenuItem("Google");
        JMenuItem Facebook = new JMenuItem("Facebook");
        JMenuItem Normal_log = new JMenuItem("Username");
        SignUp.add(Normal_log);
        SignUp.add(google);
        SignUp.add(Facebook);
        Normal_log.addActionListener(this);
        return SignUp;
    }
    public void actionPerformed(ActionEvent e) {
        SignUp S = new SignUp();
    }
    
}
public class HomePage{
    JFrame frame = new JFrame();
    private int user_id;
    private boolean isloggedin = false;

    public HomePage(boolean logged, int Id) {
        this.isloggedin = logged;
        this.user_id = Id;
        JMenuBar menubar = new JMenuBar();

        menubar.add(new CourseMenu(this.isloggedin, this.user_id).CourseList());
        menubar.add(new LogMenu().LogOption());
        menubar.add(new SignMenu().SignUp_Option());
        frame.setJMenuBar(menubar);

        //Image of Home page
        ImageIcon img = new ImageIcon(
                "C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\home.png");
        frame.add(new JLabel(img));
        frame.pack();

        frame.setTitle("Student Home Page");
        frame.setBounds(20, 10, 895, 650);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        new HomePage(false, 0);
    }
}


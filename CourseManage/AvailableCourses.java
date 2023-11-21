import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AvailableCourses{
    private static JFrame frame = new JFrame();
    private static Font Course_Font = new Font("Arial", Font.BOLD, 18);
    private static Font Button_Font = new Font("Arial", Font.BOLD, 15);
    private static Container c = frame.getContentPane();
    private static JButton app_btn = null;
    private static JButton game_btn = null;
    private static JButton Iot_btn = null;
    private static JButton Java_btn = null;
    private static JButton aws_btn = null;
    private static JButton ai_btn = null;
    private static JButton virtual_btn = null;
    private static JButton web_btn = null;
    private int User_Id;
    private boolean IsLoggedIn = false;
    public AvailableCourses(boolean logIn, int Id) {
        this.IsLoggedIn = logIn;
        this.User_Id = Id;
        c.setLayout(null);

        frame.setTitle("Available Course Page");

        App_Development();
        Game_Development();
        Internet_things();
        Java_Developer();
        AWS();
        Artificial_Intelligence();
        virtual_Reality();
        Web_Development();
        // frame section
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void App_Development() {
        String code = "100";
        JLabel App_dev = new JLabel("App Development");
        App_dev.setFont(Course_Font);
        App_dev.setBounds(180, 30, 200, 50);
        c.add(App_dev);
        JLabel img1 = new JLabel(
                new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\download (1).jpg"));
        img1.setBounds(90, 50, 300, 250);
        img1.setVisible(true);
        c.add(img1);
        app_btn = new JButton("Enrolled Now");
        app_btn.setBounds(180, 290, 150, 30);
        app_btn.setFont(Button_Font);
        app_btn.setVisible(true);
        app_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "App Development");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in App Development Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(app_btn);
    }

    private void Game_Development() {
        String code = "101";
        JLabel mobile_dev = new JLabel("Game Development");
        mobile_dev.setFont(Course_Font);
        mobile_dev.setBounds(500, 30, 200, 50);
        c.add(mobile_dev);
        JLabel img2 = new JLabel(
                new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\download (2).jpg"));
        img2.setBounds(440, 50, 300, 250);
        img2.setVisible(true);
        c.add(img2);
        game_btn = new JButton("Enrolled Now");
        game_btn.setBounds(520, 290, 150, 30);
        game_btn.setFont(Button_Font);
        game_btn.setVisible(true);
        game_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "Game Development");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in Game Development Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(game_btn);
    }

    private void Internet_things() {
        String code = "102";
        JLabel Iot_dev = new JLabel("Internet Of Things");
        Iot_dev.setFont(Course_Font);
        Iot_dev.setBounds(840, 30, 200, 50);
        c.add(Iot_dev);
        JLabel img3 = new JLabel(
                new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\download (3).jpg"));
        img3.setBounds(790, 50, 300, 250);
        img3.setVisible(true);
        c.add(img3);
        Iot_btn = new JButton("Enrolled Now");
        Iot_btn.setBounds(860, 290, 150, 30);
        Iot_btn.setFont(Button_Font);
        Iot_btn.setVisible(true);
        Iot_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "Internet Of Things");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in Internet Of Things Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(Iot_btn);
    }

    private void Java_Developer() {
        String code = "103";
        JLabel Java_dev = new JLabel("Java Developer");
        Java_dev.setFont(Course_Font);
        Java_dev.setBounds(1220, 30, 200, 50);
        c.add(Java_dev);
        JLabel img4 = new JLabel(
                new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\download.jpg"));
        img4.setBounds(1140, 50, 300, 250);
        img4.setVisible(true);
        c.add(img4);
        Java_btn = new JButton("Enrolled Now");
        Java_btn.setBounds(1225, 290, 150, 30);
        Java_btn.setFont(Button_Font);
        Java_btn.setVisible(true);
        Java_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "Java Developer");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in Java Developer Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(Java_btn);
    }

    private void AWS() {
        String code = "104";
        JLabel Aws_dev = new JLabel("AWS and Cloud Computing");
        Aws_dev.setFont(Course_Font);
        Aws_dev.setBounds(130, 405, 280, 50);
        c.add(Aws_dev);
        JLabel img5 = new JLabel(
                new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\download.png"));
        img5.setBounds(90, 410, 300, 250);
        img5.setVisible(true);
        c.add(img5);
        aws_btn = new JButton("Enrolled Now");
        aws_btn.setBounds(170, 640, 150, 30);
        aws_btn.setFont(Button_Font);
        aws_btn.setVisible(true);
        aws_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "Aws and Cloud Computing");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in Aws and Cloud Computing Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(aws_btn);
    }

    private void Artificial_Intelligence() {
        String code = "105";
        JLabel Ai_dev = new JLabel("Artificail Inteligence");
        Ai_dev.setFont(Course_Font);
        Ai_dev.setBounds(500, 405, 280, 50);
        c.add(Ai_dev);
        JLabel img6 = new JLabel(
                new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\images.jpg"));
        img6.setBounds(440, 410, 300, 250);
        img6.setVisible(true);
        c.add(img6);
        ai_btn = new JButton("Enrolled Now");
        ai_btn.setBounds(520, 640, 150, 30);
        ai_btn.setFont(Button_Font);
        ai_btn.setVisible(true);
        ai_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "Artificial Intelligence");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in Artificial Intelligence Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(ai_btn);
    }

    private void virtual_Reality() {
        String code = "106";
        JLabel virtual_dev = new JLabel("Virtual Reality");
        virtual_dev.setFont(Course_Font);
        virtual_dev.setBounds(860, 405, 280, 50);
        c.add(virtual_dev);
        JLabel img7 = new JLabel(new ImageIcon(
                "C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\virtual_reality.jpg"));
        img7.setBounds(790, 410, 300, 250);
        img7.setVisible(true);
        c.add(img7);
        virtual_btn = new JButton("Enrolled Now");
        virtual_btn.setBounds(860, 640, 150, 30);
        virtual_btn.setFont(Button_Font);
        virtual_btn.setVisible(true);
        virtual_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "Virtual Reality");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in Virtual Reality Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(virtual_btn);
    }

    private void Web_Development() {
        String code = "107";
        JLabel Web_dev = new JLabel("Web Development");
        Web_dev.setFont(Course_Font);
        Web_dev.setBounds(1220, 405, 280, 50);
        c.add(Web_dev);
        JLabel img8 = new JLabel(new ImageIcon(
                "C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\Web_development.jpg"));
        img8.setBounds(1140, 410, 300, 250);
        img8.setVisible(true);
        c.add(img8);
        web_btn = new JButton("Enrolled Now");
        web_btn.setBounds(1225, 640, 150, 30);
        web_btn.setFont(Button_Font);
        web_btn.setVisible(true);
        web_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (IsLoggedIn) {
                    try{
                        Connection con = Database.Connect();
                        String query = Query.Insert_Course();
                        PreparedStatement pstm = con.prepareStatement(query);
                        pstm.setInt(1, User_Id);
                        pstm.setString(2, code);
                        pstm.setString(3, "Web Development");
                        pstm.execute();
                        JOptionPane.showMessageDialog(frame, "You are Enrolled in Web Development Course",
                        "Enrolled Successful message", JOptionPane.ERROR_MESSAGE);
                        pstm.close();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are not Logged In!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(web_btn);
    }
}

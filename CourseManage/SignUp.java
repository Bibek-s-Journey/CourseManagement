
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.Exception;;
public class SignUp implements ActionListener{
    private JFrame frame = new JFrame();
    private JTextField text = new JTextField();
    private JPasswordField pass = new JPasswordField();
    private JTextField name = new JTextField();
    private JTextField email = new JTextField();
    private JRadioButton radioFemale = null;
    private JRadioButton radioMale = null;
    private ButtonGroup genderGroup = null;
    public SignUp() {

        frame.setTitle("Sign Up Form");
        frame.setLocation(500, 100);
        frame.setSize(500, 500);
        frame.setLayout(null);

        Font font = new Font("Arial", Font.ITALIC, 20);
        Font text_font = new Font("Arial", Font.BOLD, 16);
        Container c = frame.getContentPane();
        c.setLayout(null);

        JLabel Sign_up = new JLabel("Sign Up Form");
        Sign_up.setFont(new Font("Arial",Font.BOLD,25));
        Sign_up.setBounds(140,20,200,50);
        c.add(Sign_up);

        // Name section
        JLabel FullName = new JLabel("Full Name");
        FullName.setBounds(80, 75, 100, 50);
        FullName.setFont(font);
        c.add(FullName);
        name.setBounds(200, 85, 150, 30);
        name.setFont(text_font);
        name.setVisible(true);
        c.add(name);

        // Gender section
        JLabel gender = new JLabel("Gender");
        gender.setBounds(80, 120, 100, 50);
        gender.setFont(font);
        c.add(gender);
        radioFemale = new JRadioButton("Female");
        radioMale = new JRadioButton("Male");
        radioMale.setBounds(200, 130, 82, 30);
        radioMale.setSelected(true);
        radioMale.setFont(new Font("arial", Font.PLAIN, 20));
        c.add(radioMale);
        radioFemale.setBounds(280, 130, 110, 30);
        radioFemale.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(radioFemale);
        genderGroup = new ButtonGroup();
        genderGroup.add(radioFemale);
        genderGroup.add(radioMale);
        

        // username section
        JLabel label1 = new JLabel("Username");
        label1.setBounds(80, 165, 100, 50);
        label1.setFont(font);
        label1.setOpaque(true);
        c.add(label1);
        text = new JTextField();
        text.setBounds(200, 175, 150, 30);
        text.setFont(text_font);
        text.setVisible(true);
        c.add(text);
        

        // password Section
        JLabel label2 = new JLabel("Password");
        label2.setBounds(80, 250, 100, 50);
        label2.setFont(font);
        c.add(label2);
        pass = new JPasswordField();
        pass.setBounds(200, 260, 150, 30);
        c.add(pass);
        
        // Email section
        JLabel Email = new JLabel("Email");
        Email.setFont(font);
        Email.setBounds(80,210,100,50);
        c.add(Email);
        email.setBounds(200,220,150,30);
        email.setFont(text_font);
        email.setVisible(true);
        c.add(email);

        // Sign Up Button
        JButton btn = new JButton("SignUp");
        btn.setBounds(160, 330, 100, 30);
        c.add(btn);
        btn.addActionListener(this);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        String User_Fullname = name.getText();
        String User_Email = email.getText();
        String Username = text.getText();
        String User_password = String.valueOf(pass.getPassword());
        String User_Gender = null;
        if (radioFemale.isSelected()) {
            User_Gender = radioFemale.getText();
        } else {
            User_Gender = radioMale.getText();
        }

        if (Username.isEmpty() || User_password.isEmpty() || User_Email.isEmpty() || User_Fullname.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please ensure compliance!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Connection con = Database.Connect();
                String query = Query.Insert();
                
                String max_query = Query.Max_Query();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(max_query);
                int max_user = 0;
                if (rs.next()) {
                    max_user = rs.getInt(1);
                }
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setInt(1, max_user + 1);
                pstm.setString(2, User_Fullname);
                pstm.setString(3, User_Email);
                pstm.setString(4, Username);
                pstm.setString(5, User_password);
                pstm.setString(6, User_Gender);
                pstm.execute();
                con.close();
                JOptionPane.showMessageDialog(frame, "Your Details has been registered.",
                        "Sign Up successful", JOptionPane.ERROR_MESSAGE);
                frame.dispose();
                new HomePage(false,0);
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new SignUp();
    }
}

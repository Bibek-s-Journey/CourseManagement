
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.Exception;;

public class LoginForm implements ActionListener {
    public static boolean isFound = false;
    private JFrame frame = new JFrame();
    private JTextField text = new JTextField();
    private JPasswordField pass = new JPasswordField();
    private Container c = frame.getContentPane();
    public LoginForm() {

        frame.setTitle("Login Form");
        frame.setLocation(500, 100);
        frame.setSize(450, 450);
        frame.setLayout(null);
        Font font = new Font("Arial", Font.ITALIC, 20);
        c.setLayout(null);

        JLabel Login_text = new JLabel("LogIn Form");
        Login_text.setFont(new Font("Arial",Font.BOLD,24));
        Login_text.setBounds(150,20,200,100);
        Login_text.setVisible(true);
        c.add(Login_text);
        
        JLabel label1 = new JLabel("Username");
        JLabel label2 = new JLabel("Password");
        label1.setBounds(80, 100, 100, 50);
        label1.setFont(font);
        label1.setOpaque(true);
        label2.setBounds(80, 140, 100, 50);
        label2.setFont(font);
        c.add(label1);
        c.add(label2);

        text = new JTextField();
        text.setBounds(200, 110, 150, 30);
        text.setVisible(true);
        c.add(text);

        pass = new JPasswordField();
        pass.setBounds(200, 150, 150, 30);
        c.add(pass);

        JButton btn = new JButton("Login");
        btn.setBounds(180, 200, 100, 30);
        c.add(btn);
        btn.addActionListener(this);

    
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String User = text.getText();
        String User_password = String.valueOf(pass.getPassword());
        if (User.isEmpty() || User_password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please ensure compliance!",
                    "Error message", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Connection con = Database.Connect();
                String query = Query.Read();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    if ((rs.getString(3).equals(User) || rs.getString(4).equals(User))
                            && rs.getString(5).equals(User_password)) {
                        isFound = true;
                        frame.dispose();
                        new User_DashBoard(isFound, rs.getInt(1));
                    }
                }
                if (!isFound) {
                    JOptionPane.showMessageDialog(frame, "Username and Password mismatch!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                }
                con.close();
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new LoginForm();
    }
}

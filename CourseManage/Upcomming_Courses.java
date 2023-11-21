import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Upcomming_Courses {
    public Upcomming_Courses() {
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JLabel image = new JLabel(new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\JAVA\\CourseManagement\\Images\\come.png"));
        image.setBounds(2, 2,frame.getWidth(), frame.getHeight());
        frame.add(image);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

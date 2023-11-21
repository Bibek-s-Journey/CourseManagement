public class Query {
    public static String Insert() {
        String query = "INSERT INTO User_Details (user_ID,User_Fullname, User_Email,Username,User_password,Gender) VALUES (?,?,?,?,?,?)";
        return query;
    }

    public static String Insert_Course() {
        String query = "INSERT INTO Courses (User_id, course_Code, Course_name) VALUES (?,?,?)";
        return query;
    }

    public static String Max_Query() {
        String max_query = "SELECT MAX(user_ID) FROM User_Details";
        return max_query;
    }

    public static String Read() {
        String query = "Select * From User_Details";
        return query;
    }

    public static String Read_courses() {
        String query = "Select * From Courses";
        return query;
    }

}

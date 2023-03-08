import java.sql.*;


public class JDBC {
    public static void main(String[] args) {


    Connection conn = null;

try {
        // db parameters
    String url       = "jdbc:mysql://localhost:3306/newdb";
    String user      = "developer";
    String password  = "developer96";


        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);
        // more processing here

    String query = "CREATE TABLE IF NOT EXISTS `newdb`. `students`( " +
            " student_id INT(10) NOT NULL AUTO_INCREMENT, " +
            " last_name VARCHAR(30) NULL, " +
            " first_name VARCHAR (30) NULL, " +
            " CONSTRAINT students_pk PRIMARY KEY (student_id));";
            //" PRIMARY KEY ('student_id'));";
    //"add constraint students_pk PRIMARY KEY (student_id));";
    Statement statement = conn.createStatement();
    //statement.execute(query);

    String student1 = "INSERT INTO `newdb`.`students`(`last_name`,`first_name`) VALUES ('romeo','stella')";
    Statement statement2 = conn.createStatement();
    statement.execute(student1);

    String student2 = "INSERT INTO `newdb`.`students`(`last_name`,`first_name`) VALUES ('finozzi','carlo')";
    Statement statement3 = conn.createStatement();
    statement.execute(student2);

    String student3 = "INSERT INTO `newdb`.`students`(`last_name`,`first_name`) VALUES ('finozzi','anastasia')";
    Statement statement4 = conn.createStatement();
    statement.execute(student3);

    String student4 = "INSERT INTO `newdb`.`students`(`last_name`,`first_name`) VALUES ('finozzi','enea')";
    Statement statement5 = conn.createStatement();
    statement.execute(student4);


    String query3 = "ALTER TABLE students ADD column country VARCHAR(30) NOT NULL ";
    Statement stmt2 = conn.createStatement();
    stmt2.execute(query3);

    String query4= ("UPDATE students SET country = ? WHERE student_id in (?,?)");
    PreparedStatement preparedStatement = conn.prepareStatement(query4);

    preparedStatement.setString(1,"Italy");
    preparedStatement.setInt(2,1);
    preparedStatement.setInt(3, 2);
    preparedStatement.executeUpdate();

    preparedStatement.setString(1,"Germany");
    preparedStatement.setInt(2,3);
    preparedStatement.setInt(3,4);
    preparedStatement.executeUpdate();

} catch(SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        try{
            if(conn != null)
            conn.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

}
}
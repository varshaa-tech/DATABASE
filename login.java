import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class login {
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/mydatbase";
        String user="root";
        String password="Varsha@11";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection= DriverManager.getConnection(url,user,password);
        System.out.println("Connection successfully");

        String sql="INSERT INTO  login1 (id , password) VALUES(?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        Scanner sc=new Scanner(System.in);
        int id1;
        String p;
        System.out.println("ENTER THE ID:");
        id1=sc.nextInt();
        System.out.println("ENTER THE PASSWORD:");
        p=sc.nextLine();
        preparedStatement.setInt(1,id1);
        preparedStatement.setString(2,p);
        int rowsInserted =preparedStatement.executeUpdate();
        if (rowsInserted>0){
            System.out.println("A NEW ROW ADDED");
        }
        preparedStatement.close();

        connection.close();

    }
}

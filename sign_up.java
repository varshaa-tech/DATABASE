import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class sign_up {
    public static void main(String[] args)throws Exception {
        String url="jdbc:mysql://localhost:3306/VARSHA";
        String user="root";
        String password="Varsha@11";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection= DriverManager.getConnection(url,user,password);
        System.out.println("Connection successfully");

        String sql="INSERT INTO  LOGIN_FORM (NAME ,EMAIL,AGE,FATHER_NAME,PASSWORD,CONFIRM_PASSWORD) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        Scanner sc=new Scanner(System.in);
        int a;
        String n1,e1,f1,p1,cp1;
        System.out.println("ENTER THE NAME:");
        n1=sc.next();
        System.out.println("ENTER THE EMAIL:");
        e1=sc.next();
        System.out.println("ENTER THE AGE:");
        a=sc.nextInt();
        System.out.println("ENTER THE FATHER NAME:");
        f1=sc.next();
        System.out.println("ENTER THE PASSWORD:");
        p1=sc.next();
        System.out.println("ENTER THE CONFIRM PASSWORD:");
        cp1=sc.next();
        preparedStatement.setString(1,n1);
        preparedStatement.setString(2,e1);
        preparedStatement.setInt(3,a);
        preparedStatement.setString(4,f1);
        preparedStatement.setString(5,p1);
        if(p1.equals(cp1)){
            preparedStatement.setString(6,cp1);
        }
        else {
            System.out.println("PASSWORD IS NOT MATCH!!!");
        }
        int rowsInserted =preparedStatement.executeUpdate();
        if (rowsInserted>0){
            System.out.println("A NEW ROW ADDED");
        }
        preparedStatement.close();

        connection.close();

    }
}

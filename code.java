import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class code {

    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/mydatbase";
        String user="root";
        String password="Varsha@11";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection=DriverManager.getConnection(url,user,password);
        System.out.println("Connection successfully");

        String sql="INSERT INTO STUDENT (name,rollno,Hindi,English,Science,Sst,Math,TOTAL_MARKS,STATUS,PERCENTAGE) VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        String n="GFFHJKJHFG";
        int r2=2;
        int h1=53;
        int e1=64;
        int s1=65;
        int ss1=82;
        int m1=90;
        int total=h1+e1+s1+ss1+m1;
        float percentage=(total/5);
        String status;
        if(total>165){
            status="PASS";
        }
        else {
            status="FAIL";
        }


        preparedStatement.setString(1,n);
        preparedStatement.setInt(2,r2);
        preparedStatement.setInt(3,h1);
        preparedStatement.setInt(4, e1);
        preparedStatement.setInt(5,s1);
        preparedStatement.setInt(6,ss1);
        preparedStatement.setInt(7,m1);
        preparedStatement.setInt(8,total);
        preparedStatement.setString(9,status);
        preparedStatement.setFloat(10,percentage);
        int rowsInserted =preparedStatement.executeUpdate();
        if (rowsInserted>0){
            System.out.println("A NEW ROW ADDED");
        }
         preparedStatement.close();

         connection.close();

    }
}

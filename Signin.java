//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.Scanner;
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Signin extends JFrame{
//    private static final String url="jdbc:mysql://localhost:3306/VARSHA";
//    private static final String user="root";
//    private static final String password="Varsha@11";
//
//    JFrame frame=new JFrame();
//
//    JLabel name= new JLabel("NAME:");
//    JLabel password=new JLabel("PASSWORD:");
//    JTextField x1=new JTextField(20);
//    JTextField x2=new JTextField(20);
//    JButton button=new JButton("SUBMIT");
//
//        frame.setLayout(new java.awt.FlowLayout());
//        frame.add(name);
//        frame.add(x1);
//        frame.add(password);
//        frame.add(x2);
//
//        frame.add(button);
//
//        button.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection connection= DriverManager.getConnection(url,user,password);
//            System.out.println("Connection successfully");
//
//            String sql="INSERT INTO  LOGIN_FORM (NAME ,EMAIL,AGE,FATHER_NAME,PASSWORD,CONFIRM_PASSWORD) VALUES(?,?,?,?,?,?)";
//            PreparedStatement preparedStatement=connection.prepareStatement(sql);
//            Scanner sc=new Scanner(System.in);
//            preparedStatement.setString(1, x1.getText());
//            preparedStatement.setString(2,x2.getText());
//            int rowsInserted =preparedStatement.executeUpdate();
//            if (rowsInserted>0){
//                System.out.println("A NEW ROW ADDED");
//            }
//            preparedStatement.close();
//
//            connection.close();
//        }
//    });
//        frame.setSize(400,350);
//        frame.setVisible(true);
//
//
//}
//
//
//}

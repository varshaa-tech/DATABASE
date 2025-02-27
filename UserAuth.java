import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAuth extends JFrame {
    private static final String url = "jdbc:mysql://localhost:3306/VARSHA";
    private static final String user = "root";
    private static final String dbPassword = "Varsha@11";
    private JTextField x1 = new JTextField(20);
    private JPasswordField x2 = new JPasswordField(20); // Use JPasswordField for password input
    private JFrame frame = new JFrame();
    private JLabel name = new JLabel("NAME:");
    private JLabel passwordfield = new JLabel("PASSWORD:");
    private JButton button = new JButton("SUBMIT");

    public UserAuth() {
        frame.setTitle("USER AUTHENTICATION");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        frame.setLayout(new FlowLayout());
        frame.add(name);
        frame.add(x1);
        frame.add(passwordfield);
        frame.add(x2);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    handleSubmit();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }

    public void handleSubmit() throws SQLException {
        String username = x1.getText();
        String password = new String(x2.getPassword()); // Get password from JPasswordField

        try (Connection connection = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO signin (name, password) VALUES (?, ?)")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(frame, "A NEW ROW ADDED");
            } else {
                JOptionPane.showMessageDialog(frame, "FAILED!!!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UserAuth swing = new UserAuth();
                swing.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}

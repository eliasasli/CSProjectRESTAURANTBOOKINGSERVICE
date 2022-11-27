import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegistrationForm extends JDialog{
    private JPanel registerPanel;
    private JTextField tffname;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JTextField tfAddress;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JTextField tflname;

    public RegistrationForm(JFrame parent) {
        super(parent);
        setTitle("create a new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registerUser();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


    }
        private void registerUser() {
            String name1 = tffname.getText();
            String name2 = tflname.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();
            String address = tfAddress.getText();
            String password = String.valueOf(pfPassword.getPassword());
            String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

            if (name1.isEmpty() || name2.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() ||password.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "1 or more fields are empty",
                        "Please Try Again",
                        JOptionPane.ERROR_MESSAGE );
                return;

            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this,
                        "Your passwords do not match",
                        "Please Try Again",
                        JOptionPane.ERROR_MESSAGE );
                return;
            }




            try {

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Eldaem03!");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM jdbc.user;");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name1"));


                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }}
package ym;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class ContactController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private TextArea messageField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization logic if needed
    }

    @FXML
    private void handleSubmit() {
        String email = emailField.getText();
        String message = messageField.getText();

        // Save to database
        saveToDatabase(email, message);

        // Clear the form fields after submission
        emailField.clear();
        messageField.clear();
    }

    private void saveToDatabase(String email, String message) {
        String sql = "INSERT INTO contacts (email, message) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, message);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

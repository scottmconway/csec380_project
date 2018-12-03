package auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.security.SecureRandom; 
import java.lang.String;

@RestController
public class HomeController {
    private Connection conn = null;

    @GetMapping(path="/")
    public String index() {
        return "Welcome to the home page!";
    }

    @GetMapping(path="/createUser")
    public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://database/skitter", "root", "skitteradmin");
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = null; 
            // See if this email is already registered
            // using prepared statements to avoid SQL injection
            String query = "SELECT email FROM user WHERE email=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
            if (rs.next()) {
                return "Error - email is already registered!";
            }
            
            if (!(name.matches("^[a-zA-Z0-9]*$"))) {
                return "Error - username is not alphanumeric!";
            }

            System.out.println("Registering new user");
                            

            SecureRandom rand = new SecureRandom(); 
            int userID = rand.nextInt(10000);
            int sessionID = rand.nextInt(10000);
                
            query = "SELECT user_id FROM user WHERE user_id=" + String.valueOf(userID);
            rs = stmt.executeQuery(query);

            // Make sure that the user and session IDs do not already exist in the table
            while (rs.next()) {
                userID = rand.nextInt(10000);
                query = "SELECT user_id FROM user WHERE user_id=" + String.valueOf(userID);
                rs = stmt.executeQuery(query);
            }
            
            query = "SELECT user_id FROM user WHERE session_id=" + String.valueOf(sessionID);
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                sessionID = rand.nextInt(10000);
                query = "SELECT user_id FROM user WHERE session_id=" + String.valueOf(sessionID);
                rs = stmt.executeQuery(query);
            }

            query = "INSERT INTO user (user_id, username, displayname, email, password, session_id)VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userID);
            pstmt.setString(2, name);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setInt(6, sessionID);

            pstmt.executeUpdate();
            return String.valueOf(sessionID);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}

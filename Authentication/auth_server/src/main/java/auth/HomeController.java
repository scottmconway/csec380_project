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
import java.sql.ResultSet;

@RestController
public class HomeController {
    private Connection conn = null;

    @GetMapping(path="/")
    public String index() {
        return "Welcome to the home page!";
    }

    @GetMapping(path="/createUser")
    public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

        /*User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);    // TODO Replace with hashing, once I figure out how that works here
        
        userRepository.save(n);
        return "Registered successfully?";*/
        
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://database/skitter", "root", "skitteradmin");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("DESCRIBE user");

            // First find if a user exists with that email
            // if so, return error
            // Then make the user
            // Generate session token

            return rs.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}

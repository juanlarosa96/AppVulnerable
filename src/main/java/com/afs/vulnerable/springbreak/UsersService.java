package com.afs.vulnerable.springbreak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@Component
public class UsersService {
    @Autowired
    CookieRepository repository;
    String myUrl = "jdbc:mysql://localhost:3306/vulnerableApp";

    Connection conn;

    public User getUser(String id) {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(myUrl, "root", "abc123");
            }

            String query = "SELECT * FROM USERS WHERE id = " + id;
            ResultSet result = conn.createStatement().executeQuery(query);
            if(result.next()){
                User user = new User();
                user.setId(id);
                user.setName(result.getString("name"));
                user.setLastname(result.getString("lastname"));
                user.setEmail(result.getString("email"));
                return user;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new User();
    }
}

/*
*
 create our mysql database connection
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/test";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");

        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM users";

        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultset
        while (rs.next())
        {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Date dateCreated = rs.getDate("date_created");
        boolean isAdmin = rs.getBoolean("is_admin");
        int numPoints = rs.getInt("num_points");

        // print the results
        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
        }
        st.close();
        }
*/

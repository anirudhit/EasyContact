package com.banirudh.db.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {        
    static Connection con=null;
    static String dbUrl, dbName, dbUser, dbPassword;
    public static Connection getConnection()
    {
        if (con != null) return con;
        
        // Getting database, user, password from properties file
        String configPath = "com/banirudh/properties/config.properties";
        
        try (InputStream input = DbConnection.class.getClassLoader().getResourceAsStream(configPath)) {
        	
        	// Loading properties file
            Properties prop = new Properties();
            prop.load(input);

            // Getting the property values
            dbUrl = prop.getProperty("db.url");
            dbName = prop.getProperty("db.name");
            dbUser = prop.getProperty("db.user");
            dbPassword = prop.getProperty("db.password");
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return getConnection(dbUrl,dbName, dbUser, dbPassword);
    }

    private static Connection getConnection(String dbUrl, String dbName, String dbUser, String dbPassword)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+dbUrl+"/"+dbName+"?user="+dbUser+"&password="+dbPassword);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;        
    }
} 
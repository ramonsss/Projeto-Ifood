/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes_de_conexao;

import java.sql.*;


/**
 *a
 * @author Ramon Souza
 */
public class Conexao {
    
    public static Connection faz_conexao() throws SQLException {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://db-senhas.mysql.uhserver.com:3306/db_senhas", "ramon14020", "Tuavodecueca12@");
            
        } catch (ClassNotFoundException e) {
            
            throw new SQLException(e.getException());
            
        }
        
    }
    
    
}


 
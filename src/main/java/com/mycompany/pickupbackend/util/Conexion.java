/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pickupbackend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author minay
 */
public class Conexion 

{

    private static final String URL = "jdbc:mysql://localhost:3306/pick_up";  
    private static final String USER = "root";  
    private static final String PASSWORD = "admin";  

    public static Connection getConnection() 
    {
        try 
        {
           
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) 
        
        {
            
            return null;
        }
    }
    
    public static void main(String[] args) {
    Connection connection = Conexion.getConnection();
    if (connection != null) {
        System.out.println("Conexión exitosa a la base de datos.");
    } else {
        System.out.println("Error al conectar a la base de datos.");
    }
}
    
}

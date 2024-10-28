/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pickupbackend.Modelo;

/**
 *
 * @author minay
 */
public class Usuario 
{
 
    private int id;
    private String nombre;
    private String email;
    private String password;
    private String direccion;
    private String telefono;
    
    public Usuario() { }

    public Usuario(String nombre, String email, String password, String direccion, String telefono) 
    {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public int getId() 
        {
        return id;
        }

        public void setId(int id) 
        {
        this.id = id;
        }

        public String getNombre()
        {
        return nombre;
        }

        public void setNombre(String nombre)
        {
        this.nombre = nombre;
        }

        public String getEmail()
        {
        return email;
        }

        public void setEmail(String email)
        {
        this.email = email;
        }

        public String getPassword()
        {
        return password;
        }

        public void setPassword(String password) 
        {
        this.password = password;
        }

        public String getDireccion()
        {
        return direccion;
        }

        public void setDireccion(String direccion) 
        {
        this.direccion = direccion;
        }

    
        public String getTelefono() 
        {
        return telefono;
        }

        public void setTelefono(String telefono) 
        {
        this.telefono = telefono;
        }
}
    


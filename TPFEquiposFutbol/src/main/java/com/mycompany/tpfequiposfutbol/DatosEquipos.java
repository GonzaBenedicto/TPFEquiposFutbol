/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpfequiposfutbol;

import java.util.*;
import java.sql.*;
/**
 *
 * @author GonzaloBenedicto
 * ¡¡¡Tuve algunas dudas y problemas con la implementacion de algunos metodos para que generen las consultas y que muestren primero los listados de equipos y luego seleccionar los datos de un equipo en especifico, asi que termine optando por algo sencillo y mas directo en su funcionamiento.!!!
 */
public class DatosEquipos {
        
    public static void main (String [] args) {
        try{
            
            //Conexion con la base de datos
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/equiposfutbol","root","");




//Sentencia para mostrar todos los equipos
Statement stmt=con.createStatement();
ResultSet rs = stmt.executeQuery("select * FROM equipos"); 
while(rs.next()) {
    System.out.println("Posicion en el Ranking: "+rs.getInt(1)+" | "+ "Equipo: "+rs.getString(2));}






//Sentencia para pedir por medio de un Scanner datos de un equipo especifico basado en el ranking.
//Utilizacion de un bucle while para que el programa siga ejecutandose y pueda hacer varias consultas.
System.out.println();
System.out.println("Ingrese la posicion del ranking para ver la informacion del equipo. Desde posicion 1 a 28. Escriba \"salir\" para terminar el programa");
System.out.println();
Scanner input = new Scanner (System.in);
int inputInt = input.nextInt();

if (inputInt > 28) {
    System.out.println("Incorrecto. Ingrese un numero correcto. Desde posicion 1 a 28.");
}else if (inputInt<1) {
System.out.println("Incorrecto. Ingrese un numero correcto. Desde posicion 1 a 28.");
};

PreparedStatement ps = null;
 ps = con.prepareStatement("SELECT * FROM equipos WHERE IdEquipo =?");
 ps.setInt(1, inputInt);
 rs = ps.executeQuery();
 
 while(rs.next()) {
    System.out.println("Posicion en el Ranking: "+rs.getInt(1)+" | "+ "Equipo: "+rs.getString(2)+" | "+ "Titulares: "+rs.getInt(3)+ " | "+"Suplentes: "+rs.getInt(4)+ " | "+ "DT: "+rs.getString(5)+ " | "+"Puntos: "+rs.getInt(6)+ " | "+"Partidos Jugados: "+rs.getInt(7));}

 

 //cierre de conexion con la base de datos
con.close();
} catch(Exception e){ System.out.println(e);}
        }
    
}

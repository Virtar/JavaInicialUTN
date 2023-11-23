package Domain;

import java.sql.*;


public class Base {

	private static Connection conexion;
	private static Statement sentencia;
	private static ResultSet resultado;
	
	public static Connection conectarDB() {
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");	
		conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/tp3", "root", "");	
		
			
		
		} catch (Exception e) {
		System.out.println(e);
		}
	
		return conexion;
		
	}	
	
	
	public static int consultarDBTotalDePronosticos() {
		
		int cantidadPronosticos=0;
		try
		{
		conectarDB();
		sentencia=conexion.createStatement();
		resultado=sentencia.executeQuery("SELECT count(*) FROM `pronostico`");
		resultado.next();
	    cantidadPronosticos = resultado.getInt(1);
	   
		} catch (Exception e) {
		System.out.println(e);
		}
	
		return cantidadPronosticos;
		
	}

	
	public static ResultSet consultarDBPronosticos(Participante persona) {
		
		try
		{
		conectarDB();
		sentencia=conexion.createStatement();
		resultado=sentencia.executeQuery("SELECT * FROM `pronostico` WHERE persona=\""+persona.getNombre()+"\"");

		} catch (Exception e) {
		System.out.println(e);
		}
	
		return resultado;
		
	}
	

	public static ResultSet consultarDBParticipantes() {
		
		try
		{
		conectarDB();
		sentencia=conexion.createStatement();
		resultado=sentencia.executeQuery("SELECT DISTINCT persona FROM `pronostico`");
		
		} catch (Exception e) {
		System.out.println(e);
		}
	
		return resultado;
		
	}

	
	public static void desconectarDB() {
		
		try
		{
		conexion.close();	
		} catch (Exception e) {
		System.out.println(e);
		}
		
	}
	
	
}

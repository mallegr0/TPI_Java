package data;

import java.sql.*;
import entidades.*;
import utilidades.*;

public class DataPersonaje {
	
	public DataPersonaje(){
		
	}
	
	public void altaPersonaje(Personaje p){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt=Conexion.getInstancia().getConn().prepareStatement("INSERT INTO personajes" +
					"(idPersonaje, nombrePersonaje, puntosPersonaje, vidaPersonaje, energiaPersonaje, defensaPersonaje, evasionPersonaje) "
					+ "VALUES(?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNombre());
			stmt.setInt(3, p.getPtosTotales());
			stmt.setInt(4, p.getVida());
			stmt.setInt(5, p.getEnergia());
			stmt.setInt(6, p.getDefensa());
			stmt.setInt(7, p.getEvasion());
			
			stmt.execute();
			
			//DEVUELVE EL SIGUIENTE ID EN LA FILA DE LA TABLA DE LA BD
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void modificaPersonaje(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt= Conexion.getInstancia().getConn().prepareStatement(
					"update personas set dni=?, nombre=?, apellido=?, habilitado=?"+
					" where id=?");
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPtosTotales());
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void eliminaPersonaje(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = Conexion.getInstancia().getConn().prepareStatement(
					"delete from personas where id=?");
			stmt.setInt(1, p.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public Personaje consultaPersonaje(Personaje per){
		Personaje p = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = Conexion.getInstancia().getConn().prepareStatement(
					"SELECT * FROM personajes WHERE idPersonaje = ?;", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, per.getId());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p = new Personaje();
				p.setId(rs.getInt("idPersonaje"));
				p.setNombre(rs.getString("nombrePersonaje"));
				p.setVida(rs.getInt("vidaPersonaje"));
				p.setDefensa(rs.getInt("defensaPersonaje"));
				p.setPtosTotales(rs.getInt("puntosPersonaje"));
				p.setEvasion(rs.getInt("evasionPersonaje"));
				p.setEnergia(rs.getInt("energiaPersonaje"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
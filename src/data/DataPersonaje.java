package data;

import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import entidades.Personaje;
import utilidades.ApplicationException;

public class DataPersonaje {
	
	public DataPersonaje(){
		
	}
	
	public int devuelveID(){
		int elID = 1;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		try {
			stmt = Conexion.getInstancia().getConn().prepareStatement("SELECT * FROM personajes", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				while (rs.next())
				elID++;
			}
			return elID;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
		return elID;
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
			stmt= Conexion.getInstancia().getConn().prepareStatement("update personajes set " +
					"nombrePersonaje = ?, puntosPersonaje = ?, vidaPersonaje = ?, " +
					"energiaPersonaje = ?, defensaPersonaje = ?, evasionPersonaje = ? " +
					"WHERE idPersonaje = ?");
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getPtosTotales());
			stmt.setInt(3, p.getVida());
			stmt.setInt(4, p.getEnergia());
			stmt.setInt(5, p.getDefensa());
			stmt.setInt(6, p.getEvasion());
			stmt.setInt(7, p.getId());
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

	@SuppressWarnings("rawtypes")
	public ArrayList<String> listarPersonajes(){
		ArrayList<String> listado = new ArrayList<>();
		PreparedStatement decPrep = null;
		ResultSet conjResult = null;
		
		try {
			decPrep = Conexion.getInstancia().getConn().prepareStatement("SELECT * FROM personajes", PreparedStatement.RETURN_GENERATED_KEYS);
			conjResult = decPrep.executeQuery();
			if(conjResult!=null && conjResult.next()){
				while(conjResult.next()){
					String p = new String();
					p = conjResult.getString("nombrePersonaje");
					listado.add(p);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(conjResult!=null)conjResult.close();
				if(decPrep!=null)decPrep.close();
				Conexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Problemas de conexión con la Base de Datos al intentar listar los personajes");
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		int i;		
		for(i=0; i<= listado.size(); i++){
			System.out.println(listado.get(i));
		}
		
		return listado;
	}
	
}
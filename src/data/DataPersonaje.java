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
		//ResultSet rs=null;
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
			
			/*DEVUELVE EL SIGUIENTE ID EN LA FILA DE LA TABLA DE LA BD
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
			}*/
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
	
	public static Personaje[] buscaPersonajes()
	{	Personaje[] per=null;
	ResultSet res=null;
		try {
		    Class.forName("com.mysql.jdbc.Driver");;
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabajojava?useSSL=false","root","password"); 
			Statement st;
			Statement nu=connection.createStatement();
		 st= connection.createStatement();
		 res = st.executeQuery("SELECT idpersonaje, nombre, atk, def, ene, eva, hp FROM trabajojava.personajes;");
		 ResultSet numero = nu.executeQuery("SELECT count(*) from trabajojava.personajes;");
		 numero.next();
		 int num = numero.getInt(1);
		 per = new Personaje[num];
		 int i=0;
		while (res.next()){
			Personaje p= new Personaje(res.getInt("idpersonaje"), res.getInt("hp"),res.getInt("def"), res.getInt("eva"), res.getInt("atk"), res.getInt("ene"), res.getString("nombre"));
			per[i]=p;
			i++;
			System.out.println(p);
		};
		res.close();
		numero.close();
		 	} 
		catch (SQLException e) {
			;
			 System.out.println("SQLException \t"+ e.getMessage());
		}
		catch (ClassNotFoundException e) {System.out.println("CLASSException");}; 
		return per;
	};		
	
}
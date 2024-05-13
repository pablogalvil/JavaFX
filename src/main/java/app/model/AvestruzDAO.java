package app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvestruzDAO {
	public static ArrayList<AvestruzDO> cargarAvestruz(Connection con) {
		try {
			String query = "SELECT * FROM AVESTRUZ";

			PreparedStatement pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			ArrayList<AvestruzDO> listaTemp = new ArrayList<AvestruzDO>();

			while (rs.next()) {
				AvestruzDO temp = new AvestruzDO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7));

				listaTemp.add(temp);
			}

			return listaTemp;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean insertAvestruz(AvestruzDO avestruz, Connection con) {
		try {
			String query = "UPDATE AVESTRUZ SET nombre=?, nickGuerra=?, edad=?, altura=?, nivelMalaLeche=?, numHuevos=? WHERE idAvestruz=?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, avestruz.getNombre());
			pstmt.setString(2, avestruz.getNickGuerra());
			pstmt.setInt(3, avestruz.getEdad());
			pstmt.setInt(4, avestruz.getAltura());
			pstmt.setInt(5, avestruz.getNivelMalaLeche());
			pstmt.setInt(6, avestruz.getNumHuevos());
			pstmt.setInt(7, avestruz.getIdAvestruz());

			int numAff = pstmt.executeUpdate();

			if (numAff == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<KoalaDO> cargarKoala(int idAvestruz, Connection con) {
		try {
			// Hacemos la query con la condicion de que tenga el id de avestruz dado
			String query = "SELECT * FROM KOALA WHERE avestruz_idAvestruz = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			// Metemos el id en el prepared statement
			pstmt.setInt(1, idAvestruz);

			// Creamos la lista que devolveremos
			ArrayList<KoalaDO> koalas = new ArrayList<KoalaDO>();

			ResultSet rs = pstmt.executeQuery();

			// Hacemos un bucle que pasara siempre que haya algo en el resultset
			while (rs.next()) {
				// Creamos un koala con los datos que da actualmente el resultset
				KoalaDO koala = new KoalaDO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
						rs.getInt(11));
				// Añadimos el koala a la lista de koalas
				koalas.add(koala);
			}
			return koalas;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<KoalaDO> cargarInfoKoala(String nombre, Connection con) {
		try {

			String query = "SELECT idAvestruz FROM avestruz WHERE nombre = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String query1 = "SELECT * FROM koala WHERE Avestruz_idAvestruz = ?";
				PreparedStatement pstmt1 = con.prepareStatement(query1);
				pstmt1.setInt(1, id);
				ResultSet rs1 = pstmt1.executeQuery();

				ArrayList<KoalaDO> listaTemp = new ArrayList<KoalaDO>();

				while (rs1.next()) {
					KoalaDO temp = new KoalaDO(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getInt(4),
							rs1.getString(5), rs1.getInt(6), rs1.getInt(7), rs1.getInt(8), rs1.getInt(9),
							rs1.getInt(10), rs1.getInt(11));

					listaTemp.add(temp);
				}

				return listaTemp;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

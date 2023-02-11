package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.js.dto.Vechile;

public class VechileCRUD {
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String adress = "jdbc:mysql://localhost:3306/jdbc_vechile?user=root&password=Paru@65";
 static Connection c;
	public int insertVechile(Vechile b) {
		try {
			Class.forName(path);
			 c= DriverManager.getConnection(adress);
			PreparedStatement ps = c.prepareStatement("insert into vechile values(?,?,?,?,?)");
			ps.setInt(1, b.getVechileid());
			ps.setString(2, b.getVechilebrand());
			ps.setString(3, b.getVechilename());
			ps.setString(4, b.getVechiletype());
			ps.setInt(5, b.getVechileprice());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int DeleteVechileById(int Id) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(adress);
			PreparedStatement ps=c.prepareStatement("delete from vechile where vechileid=?");
			ps.setInt(1, Id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
		e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		}
	public Vechile GetVechileById(int Id) {
		Vechile b=null;
		try {
			Class.forName(path);
			c=DriverManager.getConnection(adress);
			PreparedStatement ps=c.prepareStatement("select * from vechile where vechileid=?");
			ps.setInt(1, Id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
		 b=new Vechile();
			b.setVechileid(rs.getInt(1));
			b.setVechilebrand(rs.getString(2));
			b.setVechilename(rs.getString(3));
			b.setVechiletype(rs.getString(4));
			b.setVechileprice(rs.getInt(5));
			return b;
		}
		
		else {
			return b;
		}
		
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
		e.printStackTrace();
}finally {
	try {
		c.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
		return b;
		
	}
	public int UpdateVechileById(int id,Vechile b) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(adress);
			PreparedStatement ps=c.prepareStatement("update bike set vechilebrand=?,vechilename=?,vechiletype=?,vechileprice=? where vechileid=?");
			ps.setString(1, b.getVechilebrand());
			ps.setString(2, b.getVechilename());
			ps.setString(3, b.getVechiletype());
			ps.setInt(4, b.getVechileprice());
			ps.setInt(5,id);
			return ps.executeUpdate();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public ArrayList<Vechile> getAllVechile(){
		ArrayList<Vechile> al=new ArrayList<Vechile>();
		try {
			Class.forName(path);
			c=DriverManager.getConnection(adress);
			PreparedStatement ps=c.prepareStatement("select * from vechile");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Vechile b=new Vechile();
				b.setVechileid(rs.getInt(1));
				b.setVechilebrand(rs.getString(2));
				b.setVechilename(rs.getString(3));
				b.setVechiletype(rs.getString(4));
				b.setVechileprice(rs.getInt(5));
				al.add(b);
			}
		return al;
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	
	}		
	
}


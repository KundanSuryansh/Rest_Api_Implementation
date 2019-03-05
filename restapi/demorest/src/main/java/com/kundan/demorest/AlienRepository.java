package com.kundan.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienRepository {

	Connection conn=null;
	
	public AlienRepository()
	{
	String url="jdbc:mysql://localhost:3306/restdb";
	String user="root";
	String password= "";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url, user, password);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	
		
	}
	public List<Alien> getAliens()
	{
		List<Alien> aliens =new ArrayList<>();
		String sql="select * from alien";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				Alien a=new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return aliens;
	}
	
	public Alien getAlien(int id)
	{
		String sql="select * from alien where id="+id;
		Statement st;
		Alien a=null;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				a=new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}
	public  void create(Alien a1) {
		// TODO Auto-generated method stub
		String sql="insert into alien values(?,?,?)";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void update(Alien a1) {
		// TODO Auto-generated method stub
		String sql="update alien set name=?,points=? where id=?";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(3, a1.getId());
			st.setString(1, a1.getName());
			st.setInt(2, a1.getPoints());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		
		String sql="delete from alien where id=?";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

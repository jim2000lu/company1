package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //member m0=new member("AS","AS23","000","台北","44","123");
        //new implMember().add(m0);
        
		//System.out.println(new implMember().queryAll1());
		//System.out.println(new implMember().queryAll2());
		List<member> l=new implMember().queryAll2();
		
		
		for(member o:l)
		{
			System.out.println(o.getId()+"\t'"+o.getUsername() + "'\t'"+o.getPassword() + "'");
		}
		
		System.out.println("Size:" + l.size());
		
		System.out.println("=======================");
		//System.out.println(new implMember().queryId(6));
		//System.out.println(new implMember().queryMember("99", "889"));
		
		/*
		member m=new implMember().queryId(6);
		m.setPassword("1234");
		*/
		//new implMember().update(m);
		//new implMember().delete(8);
		
		
		/*member m=new implMember().queryId(6);
		m.setPassword("Awe123");
		
		new implMember().update(m);*/
		
		//new implMember().delete(9);		
		
		System.out.println(new implMember().queryUser("abc"));

		
		
	}

	@Override
	public void add(member m) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDB();
		String sQL="insert into member(name,username,password,address,mobile,phone) "
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String queryAll1() {
		// TODO Auto-generated method stub
		// return null;
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				show=show+"id:"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\t地址:"+rs.getString("address")+
						"\t行動:"+rs.getString("mobile")+
						"\t電話:"+rs.getString("phone")+"\n";
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return show;
		
	}

	@Override
	public List<member> queryAll2() {

		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		List<member> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				member m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
				l.add(m);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return l;
	}

	@Override
	public member queryId(int id) {
		// TODO Auto-generated method stub

		/*
		 * 1.連線->Connection
		 * 2.SQL-->where id=?
		 * 3.ResultSet
		 * 4.if->rs.next()
		 * 5.true-->rs-->new member()
		 * 6.false-->null
		 */
		
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where id=?";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				 m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return m;
		
	}

	@Override
	public member queryMember(String username, String password) {
		// TODO Auto-generated method stub
		/*
		 * 1.先連線-->Connection
		 * 2.SQL-->where username=? and password=?
		 * 3.if(rs.next())
		 * 4.true--->new member()-->rs填入
		 * 5.false-->null
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=? and password=?";
		member m=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				 	m=new member();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setAddress(rs.getString("address"));
					m.setMobile(rs.getString("mobile"));
					m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		return m;
	}

	@Override
	public void update(member m) {
		// TODO Auto-generated method stub
		/*
		 * 1.先連線
		 * 2.SQL-->update 全部內容 where id=?
		 * 3.preparedStatement執行
		 */
		
		Connection conn=DbConnection.getDB();
		String SQL="update member set name=?,username=?,password=?,address=?,mobile=?,phone=?"
				+ " where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5,m.getMobile());
			ps.setString(6, m.getPhone());
			ps.setInt(7, m.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		/*
		 * 1.連線
		 * 2.sql-->where id=?
		 * 3.prep-->執行 
		 */
		Connection conn=DbConnection.getDB();
		String SQL="delete from member where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean queryUser(String username) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=?";
		boolean m=false;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) m=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}
	
    
	

}
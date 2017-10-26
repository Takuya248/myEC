package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.dto.UserInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class UserInfoUpdateDAO {

	public UserInfoDTO userInfoDTO = new UserInfoDTO();
	private DBConnector db = new DBConnector();
	private Connection conn = db.getConnection();
	public int num = 0;

	public String sql = "UPDATE user_info SET ? = ? WHERE ? = ?";

	public int userInfoUpdate(String dbUpdateField, String dbUpdateValue, String setValue){

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dbUpdateField);
			ps.setString(2, setValue);
			ps.setString(3, dbUpdateField);
			ps.setString(4, dbUpdateValue);
			num = ps.executeUpdate();

			System.out.println(num);



		}catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}

}




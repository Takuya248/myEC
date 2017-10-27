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


	public int userInfoUpdate(String dbUpdateField, String newValue, String oldValue){

		System.out.println(dbUpdateField+newValue+oldValue);
		try{


				String sql = "UPDATE user_info SET " + dbUpdateField + " = ? WHERE " + dbUpdateField + " = ?";

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, newValue);
				ps.setString(2, oldValue);
				num = ps.executeUpdate();

				System.out.println(num);

		}catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}

}




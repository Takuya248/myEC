package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.dto.UserInfoDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class UserInfoUpdateDAO {

	public UserInfoDTO userInfoDTO = new UserInfoDTO();
	private DBConnector db = new DBConnector();
	private Connection conn = db.getConnection();
	public DateUtil dateUtil = new DateUtil();

	public int num = 0;


	public int userInfoUpdate(String dbUpdateField, String newValue, String loginId, String loginPassword){

		System.out.println(dbUpdateField+newValue);

		try{

			String sql = "UPDATE user_info SET " + dbUpdateField + " = ? , updeted_date = ? WHERE login_id = ? AND login_pass = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newValue);
			ps.setString(2, dateUtil.getDate());
			ps.setString(3, loginId);
			ps.setString(4, loginPassword);

			num = ps.executeUpdate();

			System.out.println(num);


		}catch(SQLException e){
			e.printStackTrace();
		}
		return num;
	}

}




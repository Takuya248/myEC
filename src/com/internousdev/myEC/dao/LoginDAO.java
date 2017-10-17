package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.DBConnector;

public class LoginDAO {

	private LoginDTO loginDTO = new LoginDTO();
	private DBConnector dbConn = new DBConnector();
	private Connection conn = dbConn.getConnection();


	public LoginDTO getLoginUserInfo(String loginId,String loginPassword){

		String sql = "SELECT * FROM login_user_info where login_id = ? AND login_pass = ?";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPassword);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setLoginFlg(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return loginDTO;


	}
	public LoginDTO getLoginDTO(){
		return loginDTO;
	}

}

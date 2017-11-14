package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.DBConnector;

public class LoginDAO {

	private LoginDTO loginDTO = new LoginDTO();



	public LoginDTO getLoginUserInfo(String loginId,String loginPassword){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "SELECT * FROM user_info where login_id = ? AND login_pass = ?";
		//String sql = "SELECT login_id , CONVERT(AES_DECRYPT(UNHEX(login_pass),'test') USING utf8) as login_pass FROM user_info where login_id = ? AND login_pass = HEX(AES_ENCRYPT( ? ,'test'))";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, loginPassword);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setId(resultSet.getInt("user_id"));
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setMailAddress(resultSet.getString("mail_add"));
				loginDTO.setPhoneNumber(resultSet.getString("phone_number"));
				loginDTO.setRegiDate(resultSet.getString("insert_date"));
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

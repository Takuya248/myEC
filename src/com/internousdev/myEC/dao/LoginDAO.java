package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginId,String loginPassword){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		 LoginDTO loginDTO = new LoginDTO();

		String sql = "SELECT user_id, login_id FROM user_info WHERE login_id = ? AND login_pass = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, loginPassword);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setId(resultSet.getInt("user_id"));
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginFlg(true);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return loginDTO;


	}

	public LoginDTO getLoginUserInfo(int userId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		 LoginDTO loginDTO = new LoginDTO();

		String sql = "SELECT user_id, login_id FROM user_info WHERE user_id = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setId(resultSet.getInt("user_id"));
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginFlg(true);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return loginDTO;


	}

}

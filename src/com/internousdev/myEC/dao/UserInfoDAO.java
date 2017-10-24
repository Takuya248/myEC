package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.UserInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class UserInfoDAO implements SessionAware{

	private Map<String,Object> session;
	private UserInfoDTO userInfoDTO = new UserInfoDTO();
	public DBConnector dbConnector = new DBConnector();
	public Connection connection = dbConnector.getConnection();

	public UserInfoDTO getUserInfo(){

		String sql = "SELECT * FROM user_info where login_id = ? AND login_pass = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.get("loginId").toString());
			preparedStatement.setString(2, session.get("loginPassword").toString());
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				userInfoDTO.setUserName(resultSet.getString("user_name"));
				userInfoDTO.setLoginId(resultSet.getString("login_id"));
				userInfoDTO.setUserMailAddress(resultSet.getString("mail_add"));
				userInfoDTO.setUserPhoneNumber(resultSet.getString("phone_number"));
				userInfoDTO.setRegistrationDate(resultSet.getString("insert_date"));
			}

		}

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}

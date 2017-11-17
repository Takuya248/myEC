package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.UserInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class UserInfoDAO implements SessionAware{

	public Map<String,Object> session;
	private UserInfoDTO userInfoDTO = new UserInfoDTO();
	public DBConnector dbConnector = new DBConnector();
	public Connection connection = dbConnector.getConnection();

	public UserInfoDTO getUserInfo(){

		String sql = "SELECT * FROM user_info where login_id = ? AND login_pass = ?";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, session.get("loginId").toString());
			ps.setString(2, session.get("loginPassword").toString());
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				userInfoDTO.setUserName(rs.getString("user_name"));
				userInfoDTO.setLoginId(rs.getString("login_id"));
				userInfoDTO.setUserMailAddress(rs.getString("mail_add"));
				userInfoDTO.setUserPhoneNumber(rs.getString("phone_number"));
				userInfoDTO.setRegistrationDate(rs.getString("insert_date"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return userInfoDTO;
	}



	public UserInfoDTO getPaymentUserInfo(int userId){

		String sql = "SELECT * FROM user_info where user_id = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.get("loginId").toString());
			preparedStatement.setString(2, session.get("loginPassword").toString());
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				userInfoDTO.setUserName(resultSet.getString("user_name"));
				userInfoDTO.setUserMailAddress(resultSet.getString("mail_add"));
				userInfoDTO.setUserPhoneNumber(resultSet.getString("phone_number"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return userInfoDTO;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}

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
	public DBConnector dbConnector = new DBConnector();
	public Connection connection = dbConnector.getConnection();

	public UserInfoDTO getUserInfo(int userId){

		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT login_id, user_name, mail_add, insert_date FROM user_info WHERE user_id = ?";

		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				userInfoDTO.setUserName(rs.getString("user_name"));
				userInfoDTO.setLoginId(rs.getString("login_id"));
				userInfoDTO.setUserMailAddress(rs.getString("mail_add"));
				userInfoDTO.setRegistrationDate(rs.getString("insert_date"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return userInfoDTO;
	}



	public UserInfoDTO getPaymentUserInfo(int userId){

		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info where user_id = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				userInfoDTO.setUserName(resultSet.getString("user_name"));
				userInfoDTO.setUserMailAddress(resultSet.getString("mail_add"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return userInfoDTO;
	}


	public boolean getAddressFlg(int userId){

		boolean addressRegiFlg = false;

		String sql = "SELECT addres_regi_flag FROM user_info WHERE user_id = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				addressRegiFlg = resultSet.getBoolean("address_regi_flag");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return addressRegiFlg;
	}





	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}

package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class UserAddressDAO {

	public void insertDB(UserAddressDTO userAddressDTO){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();

		try{

			String sql = "UPDATE user_info SET phone_number = ?, state = ?, city = ?, street = ?, building = ?, zip_code = ?, update_date = ? WHERE user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, userAddressDTO.getPhoneNumber());
			preparedStatement.setString(2, userAddressDTO.getState());
			preparedStatement.setString(3, userAddressDTO.getCity());
			preparedStatement.setString(4, userAddressDTO.getStreet());
			preparedStatement.setString(5, userAddressDTO.getBuilding());
			preparedStatement.setInt(6, userAddressDTO.getZipCode());
			preparedStatement.setString(7, dateUtil.getDate());
			preparedStatement.setInt(8, userAddressDTO.getUserId());
			preparedStatement.execute();

		}catch(SQLException e){
			e.printStackTrace();

		}

	}


	public UserAddressDTO getUserAddress(int userId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		UserAddressDTO userAddressDTO = new UserAddressDTO();

		try{

			String sql = "SELECT phone_number, state, city, street, building, zip_code FROM user_info WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				userAddressDTO.setPhoneNumber(resultSet.getString("phone_number"));
				userAddressDTO.setState(resultSet.getString("state"));
				userAddressDTO.equals(resultSet.getString("city"));
				userAddressDTO.setStreet(resultSet.getString("street"));
				userAddressDTO.setBuilding(resultSet.getString("building"));
				userAddressDTO.setZipCode(resultSet.getInt("zip_code"));
			}


		}catch(SQLException e){
			e.printStackTrace();

		}

		return userAddressDTO;
	}

}

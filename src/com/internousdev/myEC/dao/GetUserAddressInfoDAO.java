package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.util.DBConnector;

public class GetUserAddressInfoDAO {


	public UserAddressDTO getAddressInfo(int userId){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserAddressDTO userAddressDTO = new UserAddressDTO();

		try{

			String sql = "SELECT * FROM user_address WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				userAddressDTO.setState(resultSet.getString("state"));
				userAddressDTO.setCity(resultSet.getString("city"));
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

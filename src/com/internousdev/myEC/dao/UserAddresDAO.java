package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.dto.UserAddressDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class UserAddresDAO {

	public void insertDB(UserAddressDTO userAddressDTO){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();

		try{

			String sql = "INSERT INTO user_address(user_id, state, city, street, building, zip_code, insert_date )VALUES(?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userAddressDTO.getUserId());
			preparedStatement.setString(2, userAddressDTO.getState());
			preparedStatement.setString(3, userAddressDTO.getCity());
			preparedStatement.setString(4, userAddressDTO.getStreet());
			preparedStatement.setString(5, userAddressDTO.getBuilding());
			preparedStatement.setInt(6, userAddressDTO.getZipCode());
			preparedStatement.setString(7, dateUtil.getDate());
			preparedStatement.execute();

		}catch(SQLException e){
			e.printStackTrace();

		}

	}


}

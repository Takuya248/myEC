package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

			String sql = "UPDATE user_info SET state = ?, city = ?, street = ?, building = ?, zip_code = ?, update_date = ? WHERE user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, userAddressDTO.getState());
			preparedStatement.setString(2, userAddressDTO.getCity());
			preparedStatement.setString(3, userAddressDTO.getStreet());
			preparedStatement.setString(4, userAddressDTO.getBuilding());
			preparedStatement.setInt(5, userAddressDTO.getZipCode());
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.setInt(7, userAddressDTO.getUserId());
			preparedStatement.execute();

		}catch(SQLException e){
			e.printStackTrace();

		}

	}


}

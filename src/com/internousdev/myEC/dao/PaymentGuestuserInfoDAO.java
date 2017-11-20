package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.dto.PaymentUserInfoDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class PaymentGuestuserInfoDAO {

	public void insertInfo(PaymentUserInfoDTO paymentUserInfoDTO){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();

		try{
			String sql = "INSERT INTO payment_guestuser_info (user_id, user_name, mail_address, phone_number, state, city, street, building, zip_code, insert_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, paymentUserInfoDTO.getUserId());
			preparedStatement.setString(2, paymentUserInfoDTO.getUserName());
			preparedStatement.setString(3, paymentUserInfoDTO.getUserMailAddress());
			preparedStatement.setString(4, paymentUserInfoDTO.getUserPhoneNumber());
			preparedStatement.setString(5, paymentUserInfoDTO.getState());
			preparedStatement.setString(6, paymentUserInfoDTO.getCity());
			preparedStatement.setString(7, paymentUserInfoDTO.getStreet());
			preparedStatement.setString(8, paymentUserInfoDTO.getBuilding());
			preparedStatement.setInt(9, paymentUserInfoDTO.getZipCode());
			preparedStatement.setString(10, dateUtil.getDate());

			preparedStatement.execute();

			connection.close();
		}catch(SQLException e){
			e.printStackTrace();

		}
	}
}

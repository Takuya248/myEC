package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.dto.PaymentUserInfoDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class PaymentUserInfoDAO {

	public void insertInfo(PaymentUserInfoDTO paymentUserInfoDTO){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();

		try{
			String sql = "INSERT INTO guestuser_info (user_id, cart_id, user_name, mail_address, phone_number, state, city, street, building, zip_code, selected_payment, insert_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, paymentUserInfoDTO.getUserId());
			preparedStatement.setInt(2, paymentUserInfoDTO.getCartId());
			preparedStatement.setString(3, paymentUserInfoDTO.getUserName());
			preparedStatement.setString(4, paymentUserInfoDTO.getUserMailAddress());
			preparedStatement.setString(5, paymentUserInfoDTO.getUserPhoneNumber());
			preparedStatement.setString(6, paymentUserInfoDTO.getState());
			preparedStatement.setString(7, paymentUserInfoDTO.getCity());
			preparedStatement.setString(8, paymentUserInfoDTO.getStreet());
			preparedStatement.setString(9, paymentUserInfoDTO.getBuilding());
			preparedStatement.setInt(10, paymentUserInfoDTO.getZipCode());
			preparedStatement.setString(11, paymentUserInfoDTO.getSelectedPayment());
			preparedStatement.setString(12, dateUtil.getDate());

			preparedStatement.execute();

			connection.close();
		}catch(SQLException e){
			e.printStackTrace();

		}
	}
}

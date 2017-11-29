package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class PaymentCompletedCartDAO {

	public void insetCartInfo(int userId, int orderId, ArrayList<CartItemDTO> cart, String howToPay){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();
		try{
			for(CartItemDTO cartItemDTO : cart){

				String sql = "INSERT INTO order_list (user_id, order_id, item_id, item_count, select_payment, insert_date ) VALUES (?,?,?,?,?,?)";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userId);
				preparedStatement.setInt(2, orderId);
				preparedStatement.setInt(3, cartItemDTO.getItemId());
				preparedStatement.setInt(4, cartItemDTO.getItemCount());
				preparedStatement.setString(5, howToPay);
				preparedStatement.setString(6, dateUtil.getDate());

				preparedStatement.execute();
			}

		}catch(SQLException e){
			e.printStackTrace();

		}
	}
}

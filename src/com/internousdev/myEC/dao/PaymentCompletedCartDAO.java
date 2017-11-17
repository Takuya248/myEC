package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.CartItemDTO;
import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class PaymentCompletedCartDAO {

	public void insetCartInfo(ArrayList<CartItemDTO> cart){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		DateUtil dateUtil = new DateUtil();

		for(CartItemDTO cartItemDTO : cart){
				try{


					String sql = "INSERT INTO comfirmed_cart (guestuser_id, cart_id, item_id, item_count, insert_date ) VALUE (?,?,?,?,?)";

					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, cartItemDTO.);
					preparedStatement.setInt(2, cartItemDTO);
					preparedStatement.setInt(3, cartItemDTO);
					preparedStatement.setInt(4, cartItemDTO);
					preparedStatement.setString(5, dateUtil.getDate());
				}
				}catch(SQLException e){
					e.printStackTrace();

				}

	}

}

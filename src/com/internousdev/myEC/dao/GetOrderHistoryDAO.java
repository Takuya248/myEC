package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.OrderListDTO;
import com.internousdev.myEC.util.DBConnector;

public class GetOrderHistoryDAO {

	public ArrayList<OrderListDTO> getOrderList(int userId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<OrderListDTO> orderList = new ArrayList<OrderListDTO>();

		try{

			String sql = "SELECT order_id, item_id, item_count, select_payment, DATE_FORMAT(insert_date, '%Y%m%d%H%i%s') as insert_date FROM order_list WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				OrderListDTO orderListDTO = new OrderListDTO();

				orderListDTO.setOrderId(resultSet.getInt("order_id"));
				orderListDTO.setItemId(resultSet.getInt("item_id"));
				orderListDTO.setItemCount(resultSet.getInt("item_count"));
				orderListDTO.setSelectPayment(resultSet.getString("select_payment"));
				orderListDTO.setInsertDate(resultSet.getString("insert_date"));

				orderList.add(orderListDTO);
			}

			connection.close();


		}catch(SQLException e){

			e.printStackTrace();

		}

		return orderList;
	}

	public ArrayList<OrderListDTO> getOrderInfo(int userId, int orderId){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<OrderListDTO> orderList = new ArrayList<OrderListDTO>();

		try{

			String sql = "SELECT order_id, item_id, item_count, select_payment, DATE_FORMAT(insert_date, '%Y%m%d%H%i%s') as insert_date FROM order_list WHERE user_id = ? AND order_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				OrderListDTO orderListDTO = new OrderListDTO();

				orderListDTO.setOrderId(resultSet.getInt("order_id"));
				orderListDTO.setItemId(resultSet.getInt("item_id"));
				orderListDTO.setItemCount(resultSet.getInt("item_count"));
				orderListDTO.setSelectPayment(resultSet.getString("select_payment"));
				orderListDTO.setInsertDate(resultSet.getString("insert_date"));

				orderList.add(orderListDTO);
			}

			connection.close();


		}catch(SQLException e){

			e.printStackTrace();

		}

		return orderList;
	}

}

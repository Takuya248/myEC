package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.OrderListDTO;
import com.internousdev.myEC.util.DBConnector;

public class GetOrderItemInfoListDAO {

	public ArrayList<OrderListDTO> getItemInfo(ArrayList<OrderListDTO> orderList){

		ArrayList<OrderListDTO> orderItemInfoList = new ArrayList<OrderListDTO>();

		try{
			for(OrderListDTO orderListDTO : orderList){
				DBConnector dbConnector = new DBConnector();
				Connection connection = dbConnector.getConnection();


				String sql = "SELECT * FROM item_info WHERE id = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, orderListDTO.getItemId());
				ResultSet resultSet = preparedStatement.executeQuery();

				if(resultSet.next()){
					OrderListDTO orderListDTO2 = new OrderListDTO();

					orderListDTO2.setItemId(resultSet.getInt("id"));
					orderListDTO2.setItemName(resultSet.getString("item_name"));
					orderListDTO2.setItemPrice(resultSet.getInt("item_price"));
					orderListDTO2.setOrderId(orderListDTO.getOrderId());
					orderListDTO2.setItemCount(orderListDTO.getItemCount());
					orderListDTO2.setSelectPayment(orderListDTO.getSelectPayment());
					orderListDTO2.setInsertDate(orderListDTO.getInsertDate());

					orderItemInfoList.add(orderListDTO2);
				}

				connection.close();
			}




		}catch(SQLException e){

			e.printStackTrace();
		}

		return orderItemInfoList;

	}
}

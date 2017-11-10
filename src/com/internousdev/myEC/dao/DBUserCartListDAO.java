package com.internousdev.myEC.dao;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.CartDataConvert;
import com.internousdev.myEC.util.DBConnector;

public class DBUserCartListDAO implements Serializable{




	public void newCartData(int user_id){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		CartDataConvert cartDataConvert = new CartDataConvert();

		try{
			byte[] newArrayListBytes = null;
			newArrayListBytes = cartDataConvert.getByte(new ArrayList<ItemInfoDTO>());
			//newArrayListBytes = cartDataConvert.getByte(newArrayList);

			String sql = "INSERT INTO usercart_data ( user_id , cart_data ) VALUE ( ? , ? )";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, user_id);
			preparedStatement.setBinaryStream(2, new ByteArrayInputStream(newArrayListBytes),newArrayListBytes.length);
			preparedStatement.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
		connection.close();

		} catch(SQLException e) {
			e.printStackTrace();
        }
	}


	@SuppressWarnings("unchecked")
	public ArrayList<ItemInfoDTO> getCartData(int user_id){
		ArrayList<ItemInfoDTO> cartList = null;

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		try{


			String sql = "SELECT cart_data FROM usercart_data WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){


				//byteから戻す
				@SuppressWarnings("unused")
				byte[] testBytes = resultSet.getBytes("cart_data");
				Object object  = (ArrayList<ItemInfoDTO>)CartDataConvert.getObject(resultSet.getBytes("cart_data"));
				cartList = (ArrayList<ItemInfoDTO>)object;

			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return cartList;

	}


	public void updateCartData(ArrayList<ItemInfoDTO> cartItemInfoList, int user_id){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		CartDataConvert cartDataConvert = new CartDataConvert();

		try{
			byte[] cartItemInfoListBytes = null;
			cartItemInfoListBytes = cartDataConvert.getByte(cartItemInfoList);

			String sql = "UPDATE usercart_data SET cart_data = ? WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBinaryStream(1, new ByteArrayInputStream(cartItemInfoListBytes),cartItemInfoListBytes.length);
			preparedStatement.setInt(2, user_id);
			preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			connection.close();

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}


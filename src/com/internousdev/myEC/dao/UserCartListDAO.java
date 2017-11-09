package com.internousdev.myEC.dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.CartDataConvert;
import com.internousdev.myEC.util.DBConnector;

public class UserCartListDAO{

	public DBConnector dbConnector = new DBConnector();
	public Connection connection = dbConnector.getConnection();
	public CartDataConvert cartDataConvert = new CartDataConvert();

	public void cartDBInsert(ArrayList<ItemInfoDTO> cartItemInfoList){

		try{

			byte[] cartItemInfoListBytes = null;
			cartItemInfoListBytes = cartDataConvert.getByte(cartItemInfoList);

			String sql = "INSERT INTO usercart_data ( user_id , cart_data ) VALUE ( ? , ? )";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, 1);
			preparedStatement.setBinaryStream(2, new ByteArrayInputStream(cartItemInfoListBytes),cartItemInfoListBytes.length);

			preparedStatement.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}



	}




}

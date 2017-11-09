package com.internousdev.myEC.dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.CartDataConvert;
import com.internousdev.myEC.util.DBConnector;

public class UserCartListDAO implements SessionAware{

	public DBConnector dbConnector = new DBConnector();
	public Connection connection = dbConnector.getConnection();
	public CartDataConvert cartDataConvert = new CartDataConvert();
	public Map<String, Object> session;

	@SuppressWarnings("static-access")
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



	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.DBConnector;

public class UserCartListDAO implements SessionAware{

	public Map<String, Object> session;

	public void cartDBInsert(ArrayList<ItemInfoDTO> cartItemInfoList){

		try{


			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();


			for(ItemInfoDTO itemInfoDTO: cartItemInfoList){
				String sql = "INSERT INTO user_cart_info ( user_id , item_id , item_stack ) VALUE ( ? , ? , ? )";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setInt(1, ((LoginDTO)session.get("loginDTO")).getId());
				preparedStatement.setInt(2, Integer.parseInt(itemInfoDTO.getItemId()));
				preparedStatement.setInt(3, Integer.parseInt(itemInfoDTO.getItemId()));

				preparedStatement.execute();
			}

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

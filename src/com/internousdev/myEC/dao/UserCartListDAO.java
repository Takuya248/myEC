package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.util.DBConnector;

public class UserCartListDAO implements SessionAware{

	public DBConnector dbConnector = new DBConnector();
	public Connection connection = dbConnector.getConnection();
	public Map<String, Object> session;

	public void cartDBInsert(ArrayList<ItemInfoDTO> cartItemInfoList){

		try{





			for(ItemInfoDTO itemInfoDTO: cartItemInfoList){
				String sql = "INSERT INTO user_cart_info ( user_id , item_id , item_stack ) VALUE ( ? , ? , ? )";

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setInt(1, ((LoginDTO)session.get("loginDTO")).getId());
				preparedStatement.setInt(2, itemInfoDTO.getItemId());
				preparedStatement.setInt(3, itemInfoDTO.getItemId());

				preparedStatement.execute();
			}

		}catch(SQLException e){
			e.printStackTrace();
		}



	}

	public ArrayList<ItemInfoDTO> cartItemSelect(String loginId){

		ArrayList<ItemInfoDTO> cartItemInfoList = new ArrayList<>();

		try{
			String sql ="SELECT * FROM user_cart_info WHERE user_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ((LoginDTO)session.get("loginDTO")).getId());
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ItemInfoDTO itemInfoDTO = new ItemInfoDTO();

				itemInfoDTO.setItemId(resultSet.getInt("item_id"));
				itemInfoDTO.setCartItemStack(resultSet.getInt("item_stack"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return cartItemInfoList;
	}



	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

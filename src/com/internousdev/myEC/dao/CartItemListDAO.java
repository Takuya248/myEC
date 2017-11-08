package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class CartItemListDAO {

	public ItemInfoDTO getItemInfo(int buyItemId){

		DBConnector dbConnector = new DBConnector();
		Connection conn = dbConnector.getConnection();
		ItemInfoDTO itemInfoDTO = new ItemInfoDTO();

		try{
			String sql = "SELECT * FROM item_info WHERE id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, buyItemId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){

				itemInfoDTO.setItemId(rs.getInt("id"));
				itemInfoDTO.setCategoryId(rs.getString("category_id"));
				itemInfoDTO.setItemName(rs.getString("item_name"));
				itemInfoDTO.setItemPrice(rs.getString("item_price"));
				itemInfoDTO.setItemStock(rs.getString("item_stock"));
			}
		}catch(SQLException e){
			e.printStackTrace();

		}
		return itemInfoDTO;

	}


}

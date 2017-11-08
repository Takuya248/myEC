package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class ItemListDAO{

	public ArrayList<ItemInfoDTO> getItemInfo(String category){

		DBConnector dbConnector = new DBConnector();
		Connection conn = dbConnector.getConnection();
		ArrayList<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

		try{
			String sql = "SELECT * FROM item_info WHERE category_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemInfoDTO itemInfoDTO = new ItemInfoDTO();



				itemInfoDTO.setItemId(rs.getInt("id"));
				itemInfoDTO.setCategoryId(rs.getString("category_id"));
				itemInfoDTO.setItemName(rs.getString("item_name"));
				itemInfoDTO.setItemPrice(rs.getString("item_price"));
				itemInfoDTO.setItemStock(rs.getString("item_stock"));

				itemList.add(itemInfoDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();

		}
		return itemList;

	}


}

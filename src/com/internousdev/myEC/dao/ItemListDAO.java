package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.myEC.dto.ItemInfoDTO;
import com.internousdev.myEC.util.DBConnector;

public class ItemListDAO{

	public List<ItemInfoDTO> getItemInfo(String category){

		DBConnector dbConnector = new DBConnector();
		Connection conn = dbConnector.getConnection();
		List<ItemInfoDTO> itemList = new ArrayList<ItemInfoDTO>();

		try{
			String sql = "SELECT * FROM item_info WHERE category_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				itemList.add(new ItemInfoDTO(rs.getString("category_id"),rs.getString("item_name"),rs.getString("item_price"),rs.getString("item_price")));
			}

		}catch(SQLException e){
			e.printStackTrace();

		}
		return itemList;

	}


}

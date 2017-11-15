package com.internousdev.myEC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.myEC.util.DBConnector;
import com.internousdev.myEC.util.DateUtil;

public class AddressEditDAO {

	DateUtil dateUtil = new DateUtil();

	public void newInsertAddres(String state, String city, String street, String building, String zip_code){

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		try{
			String sql = "INSERT INTO user_address( state, city, street, building, zip_code, insert_date ) VALUE ( ?, ? ,? ,?, ?, ? )";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, state);
			preparedStatement.setString(2, city);
			preparedStatement.setString(3, street);
			preparedStatement.setString(4, building);
			preparedStatement.setString(5, zip_code);
			preparedStatement.setString(6, dateUtil.getDate());
			preparedStatement.execute();



		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}

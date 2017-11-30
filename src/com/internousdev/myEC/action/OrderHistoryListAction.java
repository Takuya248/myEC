package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.GetOrderHistoryDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.OrderListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class OrderHistoryListAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public ArrayList<OrderListDTO> orderHistoryList = new ArrayList<OrderListDTO>();

	public String execute(){

		ArrayList<OrderListDTO> orderList = new ArrayList<OrderListDTO>();

		GetOrderHistoryDAO getOrderHistoryDAO = new GetOrderHistoryDAO();


		orderList = getOrderHistoryDAO.getOrderList(((LoginDTO)session.get("loginUser")).getId());

		int lastOrderId = 0;
		for(OrderListDTO orderListDTO: orderList){


			if(orderListDTO.getOrderId() == lastOrderId){

				lastOrderId = orderListDTO.getOrderId();


			}else{
				orderHistoryList.add(orderListDTO);
				lastOrderId = orderListDTO.getOrderId();
			}

		}

		for(OrderListDTO orderListDTO: orderHistoryList){

			String yyyy = orderListDTO.getInsertDate().substring(0, 4);
			String mm = orderListDTO.getInsertDate().substring(4, 6);
			String dd = orderListDTO.getInsertDate().substring(6, 8);

			orderListDTO.setInsertDate(yyyy + "年" + mm + "月" + dd + "日");
		}


		String result = SUCCESS;
		return result;

	}





	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}





	public ArrayList<OrderListDTO> getOrderHistoryList() {
		return orderHistoryList;
	}





	public void setOrderHistoryList(ArrayList<OrderListDTO> orderHistoryList) {
		this.orderHistoryList = orderHistoryList;
	}




}

package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.myEC.dao.GetOrderHistoryDAO;
import com.internousdev.myEC.dao.GetOrderItemInfoListDAO;
import com.internousdev.myEC.dto.LoginDTO;
import com.internousdev.myEC.dto.OrderListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class OrderHistoryAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public ArrayList<OrderListDTO> orderItemInfoList = new ArrayList<OrderListDTO>();

	public String execute(){

		ArrayList<OrderListDTO> orderList = new ArrayList<OrderListDTO>();

		GetOrderHistoryDAO getOrderHistoryDAO = new GetOrderHistoryDAO();
		GetOrderItemInfoListDAO getOrderItemInfoListDAO = new GetOrderItemInfoListDAO();

		orderList = getOrderHistoryDAO.getOrderList(((LoginDTO)session.get("loginUser")).getId());
		orderItemInfoList = getOrderItemInfoListDAO.getItemInfo(orderList);




		String result = SUCCESS;
		return result;
	}




	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public ArrayList<OrderListDTO> getOrderItemInfoList() {
		return orderItemInfoList;
	}


	public void setOrderItemInfoList(ArrayList<OrderListDTO> orderItemInfoList) {
		this.orderItemInfoList = orderItemInfoList;
	}




}

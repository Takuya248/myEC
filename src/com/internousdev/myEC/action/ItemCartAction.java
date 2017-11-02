package com.internousdev.myEC.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCartAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public String result;
	public String buyItemId;

	public ArrayList<String> cartValue = new ArrayList<>();


	//@SuppressWarnings("unchecked")

	public String execute(){

		result = SUCCESS;

/*
		if(session.get("cartValueSession") != null){
			cartValue = (ArrayList<String>)session.get("cartValueSession");
		}

		cartValue.add(buyItemId);

		session.put("cartValueSession", cartValue);



		if(((LoginDTO)session.get("loginDTO")).getLoginFlg()){

			//DAOからLISTでカートの中身持ってくる

			//持ってきたDAOのListにSessionのListを足す

			//sessionに戻す

		}
*/
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	public String getBuyItemId() {
		return buyItemId;
	}



	public void setBuyItemId(String buyItemId) {
		this.buyItemId = buyItemId;
	}



}


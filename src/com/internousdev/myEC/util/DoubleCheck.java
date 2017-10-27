package com.internousdev.myEC.util;

import com.internousdev.myEC.dao.DoubleCheckDAO;

public class DoubleCheck {

	public boolean idDoubleCheck(String loginId){

		DoubleCheckDAO doubleCheckDAO = new DoubleCheckDAO();

		boolean exist = doubleCheckDAO.idSelect(loginId);

		System.out.println(exist);



		/*if(exist){
			checkFlg = true;
		}else{
			checkFlg = false;
		}
		 */
		return exist;


	}

}

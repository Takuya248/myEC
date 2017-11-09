package com.internousdev.myEC.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.internousdev.myEC.dto.ItemInfoDTO;

public class CartDataConvert implements Serializable{

	public byte[] getByte(ArrayList<ItemInfoDTO> cartList){

		Object object = cartList;
		byte[] objectByte = null;

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;

		try{
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);


			objectOutputStream.writeObject(object);

			objectOutputStream.close();
			byteArrayOutputStream.close();

			objectByte = byteArrayOutputStream.toByteArray();



		}catch(IOException e){
			e.printStackTrace();
		}
		return objectByte;
	}




	public static Object getObject(byte[] bytes){
		Object object = null;

		try{
			ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);

			byteInputStream.close();
			objectInputStream.close();

			object = objectInputStream.readObject();

		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return object;


	}


}

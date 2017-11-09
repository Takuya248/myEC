package com.internousdev.myEC.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.internousdev.myEC.dto.ItemInfoDTO;

public class CartDataConvert implements Serializable{

	public static byte[] getByte(ArrayList<ItemInfoDTO> cartList){
		
		Object object = cartList;
		byte[] objectByte = null;

		try{


			ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);


			objectOutputStream.writeObject(object);

			objectOutputStream.close();
			byteOutputStream.close();

			objectByte = byteOutputStream.toByteArray();


		}catch(IOException e){
			e.printStackTrace();
		}
		return objectByte;
	}





	/*
	public static Object getObject(byte[] objectByte){

		Object object = null;

		try{
			ByteArrayInputStream byteInputStream = new ByteArrayInputStream(objectByte);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);

			object = objectInputStream.readObject();

			byteInputStream.close();
			objectInputStream.close();

		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}

		return object;

	}*/

}

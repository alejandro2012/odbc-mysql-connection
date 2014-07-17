package com.alex.odbctest;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alex.utils.DbConnection;
import com.alex.utils.ItemObject;

public class Main {
		
	public static void main(String args[] ) throws SQLException {

		DbConnection conn=null;
		ResultSet res=null;
		//list
		
		HashMap items = new HashMap();
		
		
		try {
			conn = new DbConnection("SELECT * FROM esc_alumno");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			res = conn.getResult();
			while(res.next()){
				items.put(res.getString("nombre") , new ItemObject(res.getString("nombre")));
				System.out.println(res.getString("nombre"));			
			}
		}
		
		
		Iterator it = items.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();
			System.out.println(pairs.getKey() + " = " + ((ItemObject)pairs.getValue()).getNombre()  );
			
		}
		
	}  
}

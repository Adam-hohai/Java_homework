package hhuc.jsonTransform;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * author:cenhelm
 * json工具类，转化Java对象到json
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
	private static Gson gson = null;
	private JsonUtils() {}
	static {
		GsonBuilder builder = new GsonBuilder();
		gson = builder.create();
	}
	
	//obj-->json字符串
	public static void saveToFile(String filePath, Object[] objs) {	
		try {
			OutputStream os = new FileOutputStream(filePath);
			for(Object obj : objs) {
				String str = gson.toJson(obj, obj.getClass());	
				os.write(str.getBytes());
			}
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

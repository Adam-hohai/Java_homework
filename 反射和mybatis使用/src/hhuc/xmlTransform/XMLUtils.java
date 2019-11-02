package hhuc.xmlTransform;

/*
 * author:cenhelm
 * xml工具类，转化Java对象到xml输出
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLUtils {
	private static XStream xStream = null;
	// 禁止实例化
	private XMLUtils() {}
	// 利用静态语句块初始化Xstream对象
	static {
		xStream = new XStream(new DomDriver("utf-8"));
	}
	//Object-->xml
	public static void saveToFile(String filePath, Object[] objs) {
		try {
			OutputStream os = new FileOutputStream(filePath);
			ObjectOutputStream out = xStream.createObjectOutputStream(os);
			for(Object obj : objs)
				out.writeObject(obj);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

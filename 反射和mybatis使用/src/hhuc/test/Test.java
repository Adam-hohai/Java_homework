package hhuc.test;

import java.lang.reflect.Method;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import hhuc.javabean.ClassInfo;
import hhuc.javabean.MethodInfo;
import hhuc.javabean.ParamInfo;
import hhuc.jsonTransform.JsonUtils;
import hhuc.mapper.HW01InfoMapper;
import hhuc.mybatis.MybatisUtils;
import hhuc.xmlTransform.XMLUtils;

public class Test {

	// 插入ClassInfo
	public void insertClassInfo(String className) {
		// 1-获取会话(连接)
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-获得映射器对象
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-创建图书对象，调用insert方法
		ClassInfo obj = new ClassInfo();
		obj.setClassName(className);
		mapper.insertClassInfo(obj);
		System.out.println("类" + obj.getClassName());
		// 4-提交数据修改
		session.commit();
		// 5-关闭会话
		session.close();
	}

	// 找到classId
	public long findClassId(String className) {
		// 1-获得一个会话
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-获得映射器对象
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-调用查询方法
		long id = mapper.findClassId(className);
		// 4-关闭会话
		session.close();
		return id;

	}

	// 插入MethodInfo
	public void insertMethodInfo(long classId, String methodName, String returnType) {
		// 1-获取会话(连接)
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-获得映射器对象
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-创建图书对象，调用insert方法
		MethodInfo obj = new MethodInfo();
		obj.setClassId(classId);
		obj.setMethodName(methodName);
		obj.setReturnType(returnType);
		mapper.insertMethodInfo(obj);
		System.out.println("方法" + obj.getClassId() + " " + obj.getMethodName() + " " + obj.getReturnType());
		// 4-提交数据修改
		session.commit();
		// 5-关闭会话
		session.close();
	}

	// 找到methodId
	public long findMethodId(String methodName) {
		// 1-获得一个会话
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-获得映射器对象
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-调用查询方法
		long id = mapper.findMethodId(methodName);
		// 4-关闭会话
		session.close();
		return id;

	}

	// 插入ParamInfo
	public void insertParamInfo(long methodId, int paramIndex, String paramType) {
		// 1-获取会话(连接)
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-获得映射器对象
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-创建图书对象，调用insert方法
		ParamInfo obj = new ParamInfo();
		obj.setMethodId(methodId);
		obj.setParamIndex(paramIndex);
		obj.setParamType(paramType);
		mapper.insertParamInfo(obj);
		System.out.println("参数" + obj.getMethodId() + " " + obj.getParamIndex() + " " + obj.getParamType());
		// 4-提交数据修改
		session.commit();
		// 5-关闭会话
		session.close();
	}

	// 查询ClassInfo表中所有数据
	public ClassInfo[] selectClassInfo() {
		SqlSession session = MybatisUtils.getSqlSession();
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		ClassInfo[] objs = mapper.selectClassInfo();
		return objs;
	}

	// 查询MethodInfo所有数据
	public MethodInfo[] selectMethodInfo() {
		SqlSession session = MybatisUtils.getSqlSession();
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		MethodInfo[] objs = mapper.selectMethodInfo();
		return objs;
	}

	// 查询ParamInfo中所有数据
	public ParamInfo[] selectParamInfo() {
		SqlSession session = MybatisUtils.getSqlSession();
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		ParamInfo[] objs = mapper.selectParamInfo();
		return objs;
	}

	// obj-->xml
	public void saveToXml(String filePath, Object[] infos) {
		XMLUtils.saveToFile(filePath, infos);
	}
	
	//obj-->json
	public void saveToJson(String filePath, Object[] infos) {
		JsonUtils.saveToFile(filePath, infos);
	}
	

	public static void main(String[] args) throws Exception {
		System.out.println("输入完整类名");
		Scanner scanner = new Scanner(System.in);
		String className = scanner.nextLine();
		scanner.close();
		Class cls = Class.forName(className);
		System.out.println("装载成功");
		System.out.println(cls);

		Test test = new Test();

		// 插入类名信息
		test.insertClassInfo(cls.getName());

		java.lang.reflect.Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			// 插入方法信息
			test.insertMethodInfo(test.findClassId(cls.getName()), method.getName(), method.getReturnType().getName());

			Class[] paramTypes = method.getParameterTypes();

			for (int i = 1; i <= paramTypes.length; i++) {
				// 插入方法参数信息
				test.insertParamInfo(test.findMethodId(method.getName()), i, paramTypes[i - 1].getName());
			}

		}

		// 存入xml和js
		ClassInfo[] classInfos = test.selectClassInfo();
		test.saveToXml("ClassInfos.xml", classInfos);
		test.saveToJson("ClassInfos.js", classInfos);

		MethodInfo[] methodInfos = test.selectMethodInfo();
		test.saveToXml("MethodInfos.xml", methodInfos);
		test.saveToJson("MethodInfos.js", methodInfos);
		
		ParamInfo[] paramInfos = test.selectParamInfo();
		test.saveToXml("ParamInfos.xml", paramInfos);
		test.saveToJson("ParamInfos.js", paramInfos);
		
		
		
	}

}

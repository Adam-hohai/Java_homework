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

	// ����ClassInfo
	public void insertClassInfo(String className) {
		// 1-��ȡ�Ự(����)
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-���ӳ��������
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-����ͼ����󣬵���insert����
		ClassInfo obj = new ClassInfo();
		obj.setClassName(className);
		mapper.insertClassInfo(obj);
		System.out.println("��" + obj.getClassName());
		// 4-�ύ�����޸�
		session.commit();
		// 5-�رջỰ
		session.close();
	}

	// �ҵ�classId
	public long findClassId(String className) {
		// 1-���һ���Ự
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-���ӳ��������
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-���ò�ѯ����
		long id = mapper.findClassId(className);
		// 4-�رջỰ
		session.close();
		return id;

	}

	// ����MethodInfo
	public void insertMethodInfo(long classId, String methodName, String returnType) {
		// 1-��ȡ�Ự(����)
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-���ӳ��������
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-����ͼ����󣬵���insert����
		MethodInfo obj = new MethodInfo();
		obj.setClassId(classId);
		obj.setMethodName(methodName);
		obj.setReturnType(returnType);
		mapper.insertMethodInfo(obj);
		System.out.println("����" + obj.getClassId() + " " + obj.getMethodName() + " " + obj.getReturnType());
		// 4-�ύ�����޸�
		session.commit();
		// 5-�رջỰ
		session.close();
	}

	// �ҵ�methodId
	public long findMethodId(String methodName) {
		// 1-���һ���Ự
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-���ӳ��������
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-���ò�ѯ����
		long id = mapper.findMethodId(methodName);
		// 4-�رջỰ
		session.close();
		return id;

	}

	// ����ParamInfo
	public void insertParamInfo(long methodId, int paramIndex, String paramType) {
		// 1-��ȡ�Ự(����)
		SqlSession session = MybatisUtils.getSqlSession();
		// 2-���ӳ��������
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		// 3-����ͼ����󣬵���insert����
		ParamInfo obj = new ParamInfo();
		obj.setMethodId(methodId);
		obj.setParamIndex(paramIndex);
		obj.setParamType(paramType);
		mapper.insertParamInfo(obj);
		System.out.println("����" + obj.getMethodId() + " " + obj.getParamIndex() + " " + obj.getParamType());
		// 4-�ύ�����޸�
		session.commit();
		// 5-�رջỰ
		session.close();
	}

	// ��ѯClassInfo������������
	public ClassInfo[] selectClassInfo() {
		SqlSession session = MybatisUtils.getSqlSession();
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		ClassInfo[] objs = mapper.selectClassInfo();
		return objs;
	}

	// ��ѯMethodInfo��������
	public MethodInfo[] selectMethodInfo() {
		SqlSession session = MybatisUtils.getSqlSession();
		HW01InfoMapper mapper = session.getMapper(HW01InfoMapper.class);
		MethodInfo[] objs = mapper.selectMethodInfo();
		return objs;
	}

	// ��ѯParamInfo����������
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
		System.out.println("������������");
		Scanner scanner = new Scanner(System.in);
		String className = scanner.nextLine();
		scanner.close();
		Class cls = Class.forName(className);
		System.out.println("װ�سɹ�");
		System.out.println(cls);

		Test test = new Test();

		// ����������Ϣ
		test.insertClassInfo(cls.getName());

		java.lang.reflect.Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			// ���뷽����Ϣ
			test.insertMethodInfo(test.findClassId(cls.getName()), method.getName(), method.getReturnType().getName());

			Class[] paramTypes = method.getParameterTypes();

			for (int i = 1; i <= paramTypes.length; i++) {
				// ���뷽��������Ϣ
				test.insertParamInfo(test.findMethodId(method.getName()), i, paramTypes[i - 1].getName());
			}

		}

		// ����xml��js
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

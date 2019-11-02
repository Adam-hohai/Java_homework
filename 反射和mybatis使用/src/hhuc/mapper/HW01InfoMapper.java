package hhuc.mapper;

import org.apache.ibatis.annotations.Mapper;

import hhuc.javabean.ClassInfo;
import hhuc.javabean.MethodInfo;
import hhuc.javabean.ParamInfo;

/*
 * ����ӳ��ӿ�(mapperΪmybatisִ�����ݿ�����Ľӿ���)
 */

@Mapper
public interface HW01InfoMapper {
	void insertClassInfo(ClassInfo obj);
	void insertMethodInfo(MethodInfo obj);
	void insertParamInfo(ParamInfo obj);
	long findClassId(String className);
	long findMethodId(String methodName);
	ClassInfo[] selectClassInfo();
	MethodInfo[] selectMethodInfo();
	ParamInfo[] selectParamInfo();
}

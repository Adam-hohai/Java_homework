package hhuc.mapper;

import org.apache.ibatis.annotations.Mapper;

import hhuc.javabean.ClassInfo;
import hhuc.javabean.MethodInfo;
import hhuc.javabean.ParamInfo;

/*
 * 定义映射接口(mapper为mybatis执行数据库操作的接口类)
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

package hhuc.javabean;

/*
 * author:cenhelm
 * homework01���ݿ�MethodInfo���ݿ�,javabean�淶
 */

public class MethodInfo {
	private String methodName;
	private String returnType;
	private long classId;
	public MethodInfo() {}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	
}

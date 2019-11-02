package hhuc.javabean;

/*
 * author:cenhelm
 * homework01数据库paramInfo表，javabean规范
 */

public class ParamInfo {
	private int paramIndex;
	private String paramType;
	private long methodId;
	public ParamInfo() {}
	public int getParamIndex() {
		return paramIndex;
	}
	public void setParamIndex(int paramIndex) {
		this.paramIndex = paramIndex;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	public long getMethodId() {
		return methodId;
	}
	public void setMethodId(long methodId) {
		this.methodId = methodId;
	}
	
}

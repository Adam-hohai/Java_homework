package hhuc.fclass;

/*
 * author:cenhelm
 * 定义抽象泛型类AbstractSort如下，
 * 包括：一个具体排序方法sort和一个抽象比较方法compare，要求具体sort方法调用抽象compare比较对象比较；
 */

public abstract class AbstractSort<T> {
	public void sort(T[] objs) {
		//冒泡排序
		for(int i = 0; i < objs.length - 1; i++) {
			for(int j = 0; j < objs.length - i - 1; j++) {
				T tempT;
				if(compare(objs[j], objs[j+1]) == 1) {
					tempT = objs[j+1];
					objs[j+1] = objs[j];
					objs[j] = tempT;
				}
			}
		}
		
	}
	
	protected abstract int compare(T o1, T o2);
}

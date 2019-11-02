package hhuc.fclass;

/*
 * author:cenhelm
 * �����������AbstractSort���£�
 * ������һ���������򷽷�sort��һ������ȽϷ���compare��Ҫ�����sort�������ó���compare�Ƚ϶���Ƚϣ�
 */

public abstract class AbstractSort<T> {
	public void sort(T[] objs) {
		//ð������
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

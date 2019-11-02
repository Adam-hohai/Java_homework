package hhuc.test;

import java.util.Date;
import java.util.Random;

import hhuc.cclass.IntegerSort;
import hhuc.cclass.UserInfo;
import hhuc.cclass.UserInfoSort;

public class Test {

	public static void main(String[] args) {
		//测试integersort类
		Integer[] array1 = new Integer[5]; 
		for(int i = 0; i < 5; i++) {
			Random random = new Random();
			array1[i] = random.nextInt(10);
		}
		IntegerSort integerSort = new IntegerSort();
		integerSort.sort(array1);
		for(Integer i : array1)
			System.out.println(i);
		
		//测试UserInfoSort类
		UserInfo u1 = new UserInfo(new Random().nextInt(1000), "张三", "男", new Date());
		UserInfo u2 = new UserInfo(new Random().nextInt(1000), "李四", "女", new Date());
		UserInfo u3 = new UserInfo(new Random().nextInt(1000), "王二", "女", new Date());
		UserInfo u4 = new UserInfo(new Random().nextInt(1000), "周大", "男", new Date());
		
		UserInfo[] array2 = new UserInfo[4];
		array2[0] = u1;
		array2[1] = u2;
		array2[2] = u3;
		array2[3] = u4;
		
		UserInfoSort userInfoSort = new UserInfoSort();
		userInfoSort.sort(array2);
		
		for(int i = 0; i < 4; i++) {
			System.out.println(array2[i].getUserId() + " " + array2[i].getUserName() + " " + 
					array2[i].getUserSex() + " " + array2[i].getBirthday().toString());
		}
	}

}

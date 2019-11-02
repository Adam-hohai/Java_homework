package hhuc.cclass;

import hhuc.fclass.AbstractSort;

public class UserInfoSort extends AbstractSort<UserInfo>{

	@Override
	protected int compare(UserInfo o1, UserInfo o2) {
		if(o1.getUserId() <= o2.getUserId())
			return 0;
		else
			return 1;
	}

}

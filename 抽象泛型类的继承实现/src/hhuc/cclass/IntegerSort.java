package hhuc.cclass;

import hhuc.fclass.AbstractSort;

public class IntegerSort extends AbstractSort<Integer>{

	@Override
	protected int compare(Integer o1, Integer o2) {
		if(o1 <= o2)
			return 0;
		else
			return 1;
	}

}

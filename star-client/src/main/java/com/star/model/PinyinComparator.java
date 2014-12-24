package com.star.model;

import java.util.Comparator;
/**
 * 按拼音比较
 * @ClassName: PinyinComparator.java 
 * @Description: TODO
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:59:32
 */
public class PinyinComparator implements Comparator<Person> {

	/**
	 * 将人员按拼音排序
	 */
	public int compare(Person o1, Person o2) {
		if (o1.getSortletter().equals("@")
				|| o2.getSortletter().equals("#")) {
			return -1;
		} else if (o1.getSortletter().equals("#")
				|| o2.getSortletter().equals("@")) {
			return 1;
		} else {
			return o1.getSortletter().compareTo(o2.getSortletter());
		}
	}

}

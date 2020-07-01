package com.model.comparator;

import java.util.Comparator;

import com.model.UserFile;

public class FileNameDescendingComparator implements Comparator<UserFile>{

	@Override
	public int compare(UserFile o1, UserFile o2) {
		return o2.getFilename().compareTo(o1.getFilename());
	}

}

package com.model.comparator;

import java.util.Comparator;

import com.model.UserFile;

public class FileNameAscendingComparator implements Comparator<UserFile>{

	@Override
	public int compare(UserFile o1, UserFile o2) {
		return o1.getFilename().compareTo(o2.getFilename());
	}

}

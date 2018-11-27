package com.ezdms.servlet.mobile;

import com.ezdms.bean.Folder;
import com.ezdms.util.PathUtils;

import java.util.Comparator;

public class FolderComparator implements Comparator<Folder> {
	private static final Comparator<Folder> INSTANCE = new FolderComparator();

	public static Comparator<Folder> getInstance() {
		return INSTANCE;
	}

	@Override
	public int compare(Folder arg0, Folder arg1) {
		String first = PathUtils.getName(arg0.getPath());
		String second = PathUtils.getName(arg1.getPath());
		return first.compareTo(second);
	}
}

package com.vshare.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StorageFileUtils {

	public static Set<Integer> getStorageFiles(String content) {

		Matcher m = Pattern.compile("<StorageFile.*?>([\\s\\S]*?)</StorageFile>").matcher(content);
		Set<Integer> set = new HashSet<Integer>();
		while (m.find()) {
			set.add(Integer.parseInt(m.group(1)));
		}
		return set;
	}

	public static String getStorageFileTag(Integer fileId) {
		return String.format("<StorageFile>%d</StorageFile>", fileId);
	}

	public static void main(String[] args) {

		Set<Integer> list = StorageFileUtils
				.getStorageFiles("<StorageFile>1</StorageFile><StorageFile>1</StorageFile>");
		System.out.println(list);
	}

	public static String getStorageFileImageTag(String filePath) {
		return String.format("<image src='%s' data-preview-src=\"\" data-preview-group=\"1\" ></image>", filePath);
	}
}

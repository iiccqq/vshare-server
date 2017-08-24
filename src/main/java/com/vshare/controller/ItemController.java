package com.vshare.controller;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.vshare.config.StoageConfig;
import com.vshare.dao.ItemDao;
import com.vshare.dao.ItemDetailDao;
import com.vshare.dao.StorageFileDao;
import com.vshare.model.Item;
import com.vshare.model.ItemDetail;
import com.vshare.model.StorageFile;
import com.vshare.util.StorageFileUtils;
import com.vshare.view.ItemDetailView;
import com.vshare.view.ItemView;


@RestController
@RequestMapping("/api")
public class ItemController {

	@Resource
	ItemDao itemDao;
	@Resource
	ItemDetailDao itemDetailDao;
	@Resource
	StorageFileDao storageFileDao;
	@Resource
	StoageConfig stoageConfig;
	@RequestMapping("items")
	public List<ItemView> itemList() {

		List<Item> list = itemDao.getItemsList();
		List<ItemView> views = Lists.newArrayList();
		for(Item item : list){
			ItemView v = new ItemView();
			try {
				BeanUtils.copyProperties(v, item);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			String filePath = stoageConfig.getImagePath() + File.separatorChar +  item.getIconPath();
			v.setIconPath(filePath);
			views.add(v);
		}
		return views;
	}
	
	@RequestMapping("items/{itemid}/detail")
	public ItemDetailView itemList(@PathVariable("itemid") String itemid) {
		ItemDetail itemDetail = itemDetailDao.getItemByItemid(itemid);
		String content = itemDetail.getContent();
		Set<Integer> fileIds = StorageFileUtils.getStorageFiles(content);
		List<StorageFile> fileList = storageFileDao.getFilesByIds(fileIds);
		String newContent = content;
		
		for (StorageFile sf : fileList) {
			Integer fileId = sf.getId();
			String oldStr = StorageFileUtils.getStorageFileTag(fileId);
			String filePath = stoageConfig.getImagePath() + File.separatorChar +   sf.getPath() + File.separatorChar + sf.getFileName();
			String imagePath = StorageFileUtils.getStorageFileImageTag(filePath);
			newContent = newContent.replace(oldStr, imagePath);
		}
		ItemDetailView itemDetailView = new ItemDetailView();
		String title = itemDetail.getTitle();
		itemDetailView.setTitle(title);
		itemDetailView.setContent(newContent);
		return itemDetailView;
	}
	@RequestMapping("items/{itemid}/images")
	public List<StorageFile> itemImageDetailt(String itemid) {
		ItemDetail itemDetail = itemDetailDao.getItemByItemid(itemid);
		String content = itemDetail.getContent();
		Set<Integer> fileIds = StorageFileUtils.getStorageFiles(content);
		List<StorageFile> fileList = storageFileDao.getFilesByIds(fileIds);		
		return fileList;
	}


	public static void main(String[] args) {
		String str = "<StorageFile>1</StorageFile>";
		Matcher m = Pattern.compile("<StorageFile.*?>([\\s\\S]*)</StorageFile>").matcher(str);
		while(m.find()){
			System.out.println(m.group(1));
		}
	}
}

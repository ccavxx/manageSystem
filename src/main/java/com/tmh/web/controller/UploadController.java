package com.tmh.web.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tmh.utils.DateUtils;

@Controller
public class UploadController {
	
	@RequestMapping(value="ajaxUpload/{fileId}")
	@ResponseBody
	public String ajaxCreate(@PathVariable("fileId")String fileId,MultipartHttpServletRequest request, HttpServletResponse response) throws IOException{
		String date =  DateUtils.date2String0(new Date());
		/** 构建图片保存的目录 **/
		String saveImagePath = "/images/"+date;
		/** 得到图片保存目录的真实路径 **/
		String logoRealPathDir = request.getSession().getServletContext()
				.getRealPath(saveImagePath);
		/** 根据真实路径创建目录 **/
		File logoSaveFile = new File(logoRealPathDir);
		if (!logoSaveFile.exists()) {
			logoSaveFile.mkdirs();
		}
		/** 页面控件的文件流 **/
		MultipartFile multipartFile = request.getFile(fileId);
		/** 获取文件的后缀 **/
		String suffix = multipartFile.getOriginalFilename().substring(
				multipartFile.getOriginalFilename().lastIndexOf("."));
		/** 使用UUID生成文件名称 **/
		String logImageName = UUID.randomUUID().toString() + suffix;
		/** 拼成完整的文件保存路径加文件 **/
		String fileName = logoRealPathDir + File.separator + logImageName;
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveImagePath + "/" + logImageName;
	}
	
}

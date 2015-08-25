package com.sitechasia.webx.web.util;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

public class WebxFileUploadUtil {

	@SuppressWarnings("unchecked")
	public static void doFileUpload(MultipartResolver multipartResolver,
			HttpServletRequest request) throws MultipartException {

		// 是否是multipart请求?
		if (!multipartResolver.isMultipart(request))
			return;

		MultipartHttpServletRequest multipartHttpServletRequest = multipartResolver
				.resolveMultipart(request);

		Iterator<String> fileIterator = multipartHttpServletRequest
				.getFileNames();

		while (fileIterator.hasNext()) {

			String fileName = fileIterator.next().toString();
			MultipartFile multipartFile = multipartHttpServletRequest
					.getFile(fileName);
			// 保存至request当中
			multipartHttpServletRequest.setAttribute(fileName, multipartFile);

		}

		request = multipartHttpServletRequest;
	}
}

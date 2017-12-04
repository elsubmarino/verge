package org.theverge.util;

import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {

	private FileOutputStream fos;

	public FileUploader(MultipartFile file, String path, String fileName) {
		System.out.println("fileUploader starting...");
		System.out.println(fileName+" fileName");
		try {
			byte fileData[] = file.getBytes();
			fos = new FileOutputStream(path + "\\" + fileName);
			fos.write(fileData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};
}

package com.springboot.blog.services.impl;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.blog.services.FileService;


@Service
public class FileServiceImpl implements FileService {

	@Override
	public String imageUpload(String path, MultipartFile file) throws IOException {
		
		String name = file.getOriginalFilename();
		
		String randomID = UUID.randomUUID().toString();
		String filename1 = randomID.concat(name.substring(name.lastIndexOf('.')));
		String filepath = path + File.separator + filename1; 
		
		File f = new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		System.out.println(filepath);
		Files.copy(file.getInputStream(), Paths.get(filepath));
		return filename1;
	}

	@Override
	public InputStream getResource(String path, String filename) throws FileNotFoundException {
		String fullpath = path + File.separator + filename;
		InputStream is = new FileInputStream(fullpath);
		return is;
	}
	
	

}

package com.example.sbb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;


@Service
public class S3Service {
	
	@Autowired
	private AmazonS3 amazonS3;
	
	@Value("hyeonji")
	private String bucketName;
	
	
	public void uploadFile(MultipartFile multipartfile, String fileName) throws IOException {
		
		//현재 서버에 사진 임시 저장
		File file = new File(multipartfile.getOriginalFilename());
		
		try(FileOutputStream fos = new FileOutputStream(file)){
			fos.write(multipartfile.getBytes());
		}
		
		//AWS에 전송-UUID 적용 버전
		amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file));
		
		//서버에서 사진 삭제
		file.delete();
		
	}

	

}

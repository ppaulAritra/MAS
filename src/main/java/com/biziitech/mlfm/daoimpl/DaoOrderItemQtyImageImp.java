package com.biziitech.mlfm.daoimpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.biziitech.mlfm.dao.DaoOrderItemQtyImage;
import com.biziitech.mlfm.model.ModelOrder;
import com.biziitech.mlfm.model.ModelOrderItemQtyImage;
import com.biziitech.mlfm.repository.OrderItemQtyImageRepository;
@Service
public class DaoOrderItemQtyImageImp implements DaoOrderItemQtyImage{

	@Autowired
	private OrderItemQtyImageRepository orderItemQtyImageRepository;
	@Override
	public ModelOrderItemQtyImage storeImage(MultipartFile file) {
		// TODO Auto-generated method stub
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		 

		ModelOrderItemQtyImage image=new ModelOrderItemQtyImage();
		try {
			image.setImageCaption(fileName);
			image.setActiveStatus(1);
			image.setItemImage(file.getBytes());
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp entryTime = new java.sql.Timestamp(date.getTime());
			image.setEntryTimestamp(entryTime);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderItemQtyImageRepository.save(image);
	}
	public List<ModelOrderItemQtyImage> retriveData(){
		List<String> imageName=new ArrayList<>();
		List<ModelOrderItemQtyImage>  imageDataToTable= new ArrayList<>();
		List<ModelOrderItemQtyImage> imageDataFromDatabase=orderItemQtyImageRepository.findAll();
		for(ModelOrderItemQtyImage imageData:imageDataFromDatabase) {
			if(imageData.getActiveStatus()==1)
			 { imageData.setsActive("Yes");
			   imageData.setActive(true);
			 }
			 
			 else
			 {	imageData.setsActive("NO");
			 	imageData.setActive(false);
			 }
			FileOutputStream fileOuputStream ;
			try {
				fileOuputStream = new FileOutputStream("src/main/resources/static/imageDesign/"+imageData.getImageCaption());
				imageName.add(imageData.getImageCaption());
				fileOuputStream.write(imageData.getItemImage());
				fileOuputStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		    catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			imageDataToTable.add(imageData);
			
		 }
		return imageDataToTable;
	}
	public void deleteImage(Long id) {
	   
		orderItemQtyImageRepository.deleteById(id);
	}

}

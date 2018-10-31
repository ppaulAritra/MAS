package com.biziitech.mlfm.dao;

import org.springframework.web.multipart.MultipartFile;

import com.biziitech.mlfm.model.ModelOrderItemQtyImage;

public interface DaoOrderItemQtyImage {
public ModelOrderItemQtyImage storeImage(MultipartFile file);
}

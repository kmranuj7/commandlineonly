package com.excel.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excel.api.entity.Product;
import com.excel.api.helper.ExcelHelper;
import com.excel.api.service.ExcelService;

@RestController
public class ProductController {
	
	@Autowired
	private ExcelService excelService;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
	{
		if(ExcelHelper.checkExcelFormat(file))
		{
			this.excelService.save(file);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload excel File");
		}
	}
	
	
	@GetMapping("/product")
	public List<Product> getAllProduct()
	{
		return this.excelService.getAllProducts();
	}

}

package com.ninestar.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testContorller {
	@RequestMapping("/Query/{name}")
	public String getName(@PathVariable String name){
		return name + "---  Product2" ;
	}
}

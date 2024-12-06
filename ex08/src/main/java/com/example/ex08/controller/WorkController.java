package com.example.ex08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex08.dao.IWorkDao;
import com.example.ex08.dto.WorkDto;
@RequestMapping("/work")
@Controller
public class WorkController {
	@Autowired
	IWorkDao workDao;
	@RequestMapping("/")
	public String root() {
		return "";
	}
	@RequestMapping("/workStart")
	public String workStart(WorkDto workDto) {
		System.out.println(workDto);
		workDao.regist(workDto);
		return "redirect:/work/getList";
	}
	@RequestMapping("/getList")
	public String getList(Model model) {
		List<WorkDto> list= workDao.getList();
		System.out.println(list);
		model.addAttribute("list",list);
		return "/work/list";
	}
	@RequestMapping("/getWork")
	public String getWork(@RequestParam("search-id")String id , Model model) {
		
		WorkDto work =workDao.getWork(id); 
		model.addAttribute("work",work);
		System.out.println(work);
		return "/work/result";
		
	}
	
	@RequestMapping("/update")
	public String update(WorkDto workDto) {
		workDao.update(workDto); 
		return "redirect:/work/getList";
	}
	

	
	
}

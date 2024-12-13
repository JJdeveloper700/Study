package com.example.sec05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sec05.dao.IMemberDao;
import com.example.sec05.dao.IProblemDao;
import com.example.sec05.entity.Problem;

@Controller
public class MainController {
	@Autowired
	IMemberDao memberDao;
	
	@Autowired
	IProblemDao problemDao;
	
	
	@GetMapping("/")
	public String root(Model model) {
		List<Problem> list = problemDao.getList();
		Problem p1 = list.get(0);
		Problem p2 = list.get(1);
	
		model.addAttribute("p1",p1);
		model.addAttribute("p2",p2);
		
		return "Quiz";
	}
	
	
	
	
	//@GetMapping("/registForm")
	//public String registForm() {
		
		//return "registForm";
	//}
	//@PostMapping("/registProc")
	//public String registProc(Member member) {
		//memberDao.regist(member); 
		
		//return "Quiz";
	
	 


}

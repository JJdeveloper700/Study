package com.example.ex03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex03.command.Student;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String root() {
	//root라는 함수를 만들었을때 매개변수는 HttpServlet  request와 Model타입의 model을 매개변수로 가진다. 	
	
		return "p1"; 	
	}
	
	@PostMapping("/p2")
	public String p2(@RequestParam("name")String name,@RequestParam("id")String id,Model model ) {  
		//
		model.addAttribute("name",name);
		model.addAttribute("id", id);
		return "p2"; 
		
	}
	@RequestMapping("/p3")
	public String p3(@ModelAttribute("s")Student student, Model model ) {
		System.out.println("p3...."+student);
		
		return "p3";
		
	}
	@RequestMapping("/p4/{name}/{sno}/{id}") // 
	public String p4(@PathVariable("name")String name,@PathVariable("sno")String sno,@PathVariable("id")String id, Model model) {
		
		model.addAttribute("name",name); 
		model.addAttribute("sno",sno); 
		model.addAttribute("id", id); 
		
		return "p4";
	}
	@RequestMapping("/p5")
	public @ResponseBody Student p5(){
		Student stu = new Student(); 
		stu.setName("aaa"); 
		stu.setSno(100);
		stu.setMathScore(60); 
		return stu;
		
	}
	
	
		
		
}
	
	


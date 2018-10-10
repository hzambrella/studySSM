package startSSM.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import startSSM.util.dto.Result;
import startSSM.model.Student;
import startSSM.service.IStudentService;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("/test")
public class TestController {
	@Resource(name="StudentService")
	IStudentService testService;
	
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("message","你好！SSM");
		return "index";
	}
	
	@RequestMapping("/studentInfo")
	@ResponseBody
	public String userInfo(@RequestParam("id")int id){
		Student student=testService.getStudentInfo(id);
		System.out.println(student.getScores());
		Result<Student> result=new Result<>(Result.Success,true,"",student);
		return JSON.toJSONString(result);
	}
}

package startSSM.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import startSSM.Model.User;
import startSSM.Service.IUser;

@Controller
@RequestMapping("/user")
public class UserCotroller {
	@Resource(name="userService")
	IUser userSerivce;
	
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(User user){
		int id=userSerivce.insertUser(user);
		HashMap<String,String> resultMap=new HashMap<>();
		resultMap.put("message","OK");
		resultMap.put("id",String.valueOf(id));
		return JSON.toJSONString(resultMap);
	}
}

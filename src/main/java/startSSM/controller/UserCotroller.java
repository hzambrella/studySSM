package startSSM.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import startSSM.model.User;
import startSSM.service.IUser;

@Controller
@RequestMapping("/user")
public class UserCotroller {
	@Resource(name="userService")
	IUser userService;
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(User user){
		int id=userService.insertUser(user);
		HashMap<String,String> resultMap=new HashMap<>();
		resultMap.put("message","OK");
		resultMap.put("id",String.valueOf(id));
		return JSON.toJSONString(resultMap);
	}
}

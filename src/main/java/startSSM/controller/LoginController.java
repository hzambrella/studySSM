package startSSM.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import startSSM.util.dto.Result;
import startSSM.model.User;
import startSSM.service.IUser;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("login")
public class LoginController {
	@Resource(name="userService")
	IUser userService;
	
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/index")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	@ResponseBody
	public String doLogin(HttpServletRequest request,@RequestParam("account")String account,@RequestParam("password")String password){
		Result<User> result=userService.login(account,password);
		
		if (result.getCode()==Result.Success){
			HttpSession session=request.getSession();
			session.setAttribute("user", result.getObj());
			result.getMap().put("requestUrl", session.getAttribute("requestUrl"));
			session.removeAttribute("requestUrl");
			session.setMaxInactiveInterval(30*60);//30分钟
		}
		
		return JSON.toJSONString(result);
	}
}

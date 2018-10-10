package startSSM.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;

import startSSM.dto.Cart;
import startSSM.model.Good;
import startSSM.model.User;
import startSSM.service.IGood;
import startSSM.util.dto.Result;

@Controller
@RequestMapping("/good")
public class GoodController {
	@Resource(name="GoodService")
	private IGood goodService;
	
	@RequestMapping("/getGoods")
	@ResponseBody
	public String getGoods(@RequestParam("shopId")int shopId){
		List<Good>goods=goodService.getGoodsByShopId(shopId);
		return JSON.toJSONString(goods);
	}
	
	@RequestMapping(value="/buyGoods",method = RequestMethod.POST)
	@ResponseBody
	public String buyGoods(HttpServletRequest request,@RequestBody Cart[] cart){
		//System.out.println(JSON.toJSONString(cart));
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		int userId=user.getId();
		
		Result<String> result=goodService.createOrder(userId, cart);
		return JSON.toJSONString(result);
	}
}

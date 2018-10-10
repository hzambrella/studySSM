package startSSM.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import startSSM.model.User;

public class loginInterceptors implements HandlerInterceptor {
	private  String loginUrl;
	private  String appUrl;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if (user!=null){
			return true;
		}
		
		String requestUrl=request.getRequestURI();
		if (requestUrl.equals(loginUrl)){
			requestUrl=appUrl;
		}
		session.setAttribute("requestUrl", requestUrl);
		
		response.sendRedirect(request.getContextPath()+loginUrl);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	
}
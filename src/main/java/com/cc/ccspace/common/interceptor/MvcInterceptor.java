package com.cc.ccspace.common.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class MvcInterceptor extends HandlerInterceptorAdapter{

	    /* 
	     * 利用正则映射到需要拦截的路径     
	      
	    private String mappingURL; 
	     
	    public void setMappingURL(String mappingURL) {     
	               this.mappingURL = mappingURL;     
	    }    
	  */  
	    /**  
	     * 在业务处理器处理请求之前被调用  
	     * 如果返回false  
	     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
	     * 如果返回true  
	     *    执行下一个拦截器,直到所有的拦截器都执行完毕  
	     *    再执行被拦截的Controller  
	     *    然后进入拦截器链,  
	     *    从最后一个拦截器往回执行所有的postHandle()  
	     *    接着再从最后一个拦截器往回执行所有的afterCompletion()  
	     */  
	   //easkBusiness拦截器
	    @Override    
	    public boolean preHandle(HttpServletRequest request,    
	            HttpServletResponse response, Object handler) throws Exception {    
	       /* if ("GET".equalsIgnoreCase(request.getMethod())) {  
	        	System.out.println("get request");
	        }  
	        else{
	        	System.out.println("post request");
	        }*/
	        String requestUri = request.getRequestURI();  
	        String contextPath = request.getContextPath();
	        String url = requestUri.substring(contextPath.length());    
	        HttpSession hs=request.getSession();
	        //开始
	        String  loginUserInfo =  (String) hs.getAttribute("edu.yale.its.tp.cas.client.filter.user");
			System.out.println("输出====preHandle");
			//String provinceCode=String.valueOf(result.get("provinceCode"));
			//ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()); 
			// app.getBean("jdbcTemplate");
			//String fr=ConfigCache.getConf("GROUP_ROOT");
	        
	        //结束
	      /*  UserInfoBean usb=(UserInfoBean) hs.getAttribute("USERINFO");
	        
	        //获取单点登录成功后返回来的人员信息
	        //做这一步的判断的意义在于，同一个账号同时登录多个系统后，从其中一个系统退出切换账号后其他系统可以自动切换用户，而不至于访问系统异常
	        if(usb==null&&loginUserInfo!=null){//通过单点登录验证，usb为null说明为首次登录或当前用户在另一系统已退出
	        
	         //跳转至当前工程首页（不是单点登录页面），重新走登录逻辑,更换session信息
            // request.getRequestDispatcher("/npage/include/jsvalidate.jsp").forward(request, response); 
	         return true;}*/

	        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext( request.getSession().getServletContext()); 
	        //app.getBean("jdbcTemplate");
	       /*   String dynamicDbSetMStr= ConfigCache.getConf("dataSourceConfigMap");
			  JSONObject dynamicDbSetMap = JSONObject.fromObject(dynamicDbSetMStr);
			  String dbType=(String) dynamicDbSetMap.get(usb.getProvinceCode());
	       // String dynamicDbSetMStr= "{\"hi\":\"dataSourceHI\",\"jx\":\"dataSourceJX\",\"cq\":\"dataSourceCQ\",\"sh\":\"dataSourceSH\"}";//new ConfigCache(app).getConf("dataSourceConfigMap");
		    DBContextHolder.setDBType(dbType);
		    //ConfigCache.refreshConf();
	        String username = usb.getUser_name();   
	        if(username == null){  
	            request.getRequestDispatcher("/npage/login/login.jsp").forward(request, response);  
	            return false;  
	        }else  
	            return true;     */
	       return true;
	    }    
	    
	    /** 
	     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作    
	     * 可在modelAndView中加入数据，比如当前时间 
	     */  
	    @Override    
	    public void postHandle(HttpServletRequest request,    
	            HttpServletResponse response, Object handler,    
	            ModelAndView modelAndView) throws Exception {  
	    	
	        if(modelAndView != null){  //加入当前时间    
	            modelAndView.addObject("var", "测试postHandle");    
	        }    
	    }    
	    
	    /**  
	     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   
	     *   
	     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()  
	     */    
	    @Override    
	    public void afterCompletion(HttpServletRequest request,    
	            HttpServletResponse response, Object handler, Exception ex)    
	            throws Exception {  
	    	
	    }   
}

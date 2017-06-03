package framework.core;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplication {

	public static ApplicationContext ctx;
	
	public static ServletContext sctx;
	
	public static String contextPath;
	
	public static boolean isDestroy = false;
}

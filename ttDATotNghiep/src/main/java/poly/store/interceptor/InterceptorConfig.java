package poly.store.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer{

	@Autowired
	Globaiinterceptor globaiinterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
	registry.addInterceptor(globaiinterceptor)
	.addPathPatterns("/**") // chay all
	.excludePathPatterns("/rest/**","/admin/**","/assets/**"); // trừ
	
	}
}

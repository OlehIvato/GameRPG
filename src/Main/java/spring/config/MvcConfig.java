package spring.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("D:/")
    private String path;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/info").setViewName("info");
        registry.addViewController("/test").setViewName("account/profile");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+path).setCachePeriod(Integer.MAX_VALUE);
    }
}

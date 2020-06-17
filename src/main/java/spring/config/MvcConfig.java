package spring.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Value("C:\\Users\\doc\\Desktop\\project\\src\\main\\resources\\heroImages\\")
    private String pathHeroImage;

    @Value("C:\\Users\\doc\\Desktop\\project\\src\\main\\resources\\avatars\\")
    private String pathAvatars;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/info").setViewName("info");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/heroImg/**").addResourceLocations("file:" + pathHeroImage).setCachePeriod(Integer.MAX_VALUE);
        registry.addResourceHandler("/ava/**").addResourceLocations("file:" + pathAvatars).setCachePeriod(Integer.MAX_VALUE);
    }
}

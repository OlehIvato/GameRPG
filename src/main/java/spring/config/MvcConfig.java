package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public static final String pathHeroImage = "C:\\Users\\doc\\Desktop\\project\\src\\main\\resources\\heroImages\\";
    public static final String pathAvatars = "C:\\Users\\doc\\Desktop\\project\\src\\main\\resources\\avatars\\";


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/welcome").setViewName("welcome");
        registry.addViewController("/index").setViewName("welcome");
        registry.addViewController("").setViewName("welcome");
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/info").setViewName("info");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/heroImg/**").addResourceLocations("file:" + pathHeroImage).setCachePeriod(Integer.MAX_VALUE);
        registry.addResourceHandler("/ava/**").addResourceLocations("file:" + pathAvatars).setCachePeriod(Integer.MAX_VALUE);
    }
}

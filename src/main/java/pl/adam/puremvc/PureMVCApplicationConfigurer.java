package pl.adam.puremvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by SkyNET on 2017-11-01
 *
 */
/*
Klasa służąca do inicjalizacji servletu.
Kolejnosc wywoływania metod
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!getRootConfigClasses
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!getServletConfigClasses()
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!getServletMappings()
*/
public class PureMVCApplicationConfigurer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected String[] getServletMappings() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!getServletMappings()");
        return new String[]{"/"};
    }

    protected Class<?>[] getRootConfigClasses() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!getRootConfigClasses");
        return new Class[]{PureMVCAppConfiguration.class, FreemarkerConiguration.class};
    }


    protected Class<?>[] getServletConfigClasses() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!getServletConfigClasses()");
        return new Class[]{PureMVCWebConfiguration.class};
//        return null;
    }
}
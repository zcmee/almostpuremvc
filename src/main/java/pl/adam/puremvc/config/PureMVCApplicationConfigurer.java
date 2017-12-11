package pl.adam.puremvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
        return new Class[]{PureMVCAppConfiguration.class, FreemarkerConiguration.class, DataBaseConfiguration.class, PureMVCWebSecurityConfiguration.class};
    }


    protected Class<?>[] getServletConfigClasses() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!getServletConfigClasses()");
        return new Class[]{PureMVCWebConfiguration.class};
//        return null;
    }
}
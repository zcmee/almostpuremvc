package pl.adam.puremvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by SkyNET on 2017-11-01 Klasa służąca do inicjalizacji servletu.
 *
 */
public class PureMVCApplicationConfigurer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{PureMVCWebConfiguration.class};
    }

    protected String[] getServletMappings() {
        System.out.println("JRJRJRJRJRJRJRJRJ");
        return new String[]{"/"};
    }
}

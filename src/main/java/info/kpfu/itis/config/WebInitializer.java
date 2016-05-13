package info.kpfu.itis.config;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.util.Assert;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Filter[] getServletFilters() {

        // if encoding has issues we need to add UTF-8 encoding filter

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        encodingFilter.setForceEncoding(true);

        encodingFilter.setEncoding("UTF-8");

        // encoding filter must be the first one

        return new Filter[]{encodingFilter,

                new DelegatingFilterProxy("springSecurityFilterChain"),

                new OpenEntityManagerInViewFilter()};

    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }


}

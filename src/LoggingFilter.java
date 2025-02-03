

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // Apply the filter to all URLs
public class LoggingFilter implements Filter {

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Preprocessing: Logging request details
        System.out.println("Request received at " + new java.util.Date());
        chain.doFilter(request, response); // Pass the request to the next filter or servlet
        
        // Postprocessing: Logging response details
        System.out.println("Response sent at " + new java.util.Date());
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}

	
	



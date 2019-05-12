package view.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Filter to modify request and response encoding. For correct interpretation
 * of Cyrillic characters transmitted with the request, the filter intercepts
 * the request and replaces its encoding.
 *
 * @author Stanislau Palaukou on 02.05.2019
 * @project TravelAgency
 */

@WebFilter(urlPatterns = { "/*" },
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param") })
public class EncodingFilter implements Filter {
    private String code;

    public void init(FilterConfig fConfig) {
        code = fConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String codeRequest = request.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(code);
            response.setCharacterEncoding(code);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        code = null;
    }

}

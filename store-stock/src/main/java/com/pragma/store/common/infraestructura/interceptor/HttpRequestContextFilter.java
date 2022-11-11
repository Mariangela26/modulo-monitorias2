package com.pragma.store.common.infraestructura.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class HttpRequestContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper((HttpServletRequest) request);
        String authorization = wrapper.getHeader("Authorization");

        try {
            if (StringUtils.isEmpty(authorization)) {
                HttpRequestContextHolder.setAuthorization(null);
            }
            else {
                HttpRequestContextHolder.setAuthorization(authorization);
            }
            chain.doFilter(request, response);
        }
        catch (Exception e) {
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void destroy() {
    }
}

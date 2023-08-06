package com.morandev.moviesapi.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ClientFilter implements Filter {
    @Value("${allowed.client}")
    private String ALLOWED_CLIENT;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Encabezado "User-Agent" del cliente
        String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");

        if (userAgent != null && userAgent.contains(ALLOWED_CLIENT)) {
            /**
             * Si el cliente está autorizado, continúa con la cadena de filtros
             */
            chain.doFilter(request, response);
        } else {
            /**
             * Si el cliente no está autorizado,
             * devuelve un código de error o un mensaje de error
             */
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Cliente no autorizado");
        }
    }
}

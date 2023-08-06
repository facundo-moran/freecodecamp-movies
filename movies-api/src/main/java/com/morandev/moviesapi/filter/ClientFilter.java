package com.morandev.moviesapi.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ClientFilter implements Filter {
    @Value("${client.allowed}")
    private String CLIENT_ALLOWED;
    private final String CLIENT_CUSTOM_HEADER = "custom-user-agent";
    private final String listaDeACHeaders = "Content-Type, Authorization, ".concat(CLIENT_CUSTOM_HEADER);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String customHeader = ((HttpServletRequest) request).getHeader(CLIENT_CUSTOM_HEADER);
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse  = (HttpServletResponse) response;

        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            /**
             *              En OPTIONS request
             *  configurar las cabeceras CORS y permitir el acceso
             */
            httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", listaDeACHeaders);
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(request, response);
        } else {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));

            if (customHeader != null && customHeader.contains(CLIENT_ALLOWED)) {
                /**
                 * Si el cliente está autorizado, continúa con la cadena de filtros
                 */
                chain.doFilter(request, response);
            } else {
                /**
                 * Si el cliente no está autorizado,
                 * devuelve un código de error o un mensaje de error
                 */

                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.getWriter().write("Cliente no autorizado");
            }
        }
    }
}

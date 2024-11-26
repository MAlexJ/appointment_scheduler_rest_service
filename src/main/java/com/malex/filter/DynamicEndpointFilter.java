package com.malex.filter;

import static com.malex.controller.FileRestController.FILE_REST_REQUEST_MAPPING;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class DynamicEndpointFilter extends OncePerRequestFilter {


    private static final String PATH_FORMATTER = "/%s/";

    private static final String PATH_TXT_FORMATTER = "/%s.txt";

    private static final String PATH_HTML_FORMATTER = "/%s.html";

    private final Set<String> allowedPaths;

    public DynamicEndpointFilter(@Value("${tests.performance.endpoint}") String path) {
        allowedPaths = Set.of(PATH_FORMATTER.formatted(path), PATH_TXT_FORMATTER.formatted(path),
                PATH_HTML_FORMATTER.formatted(path));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var requestURI = request.getRequestURI();
        if (allowedPaths.contains(requestURI)) {
            request = new HttpServletRequestWrapper(request) {
                @Override
                public String getRequestURI() {
                    return FILE_REST_REQUEST_MAPPING;
                }
            };
        }

        filterChain.doFilter(request, response);
    }
}

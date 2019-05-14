package com.revature.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author William Gentry
 */
@Service
public class TokenPresentFilter extends OncePerRequestFilter {

    private final TokenRegistry registry;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public TokenPresentFilter(TokenRegistry registry, ObjectMapper objectMapper) {
        this.registry = registry;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("{} Request going to {}", request.getMethod(), request.getRequestURI());

        // If the request is to login or to register, ignore as they would not have a token anyways
        if (request.getRequestURI().contains("login") || request.getRequestURI().contains("register")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get the token from the HTTP Request
        final String token = request.getHeader("My-Auth-Token");

        // Reject if token is not present
        if (token == null || token.equals("")) {
            // Set the HTTP Status to be Unauthorized (401)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            // Give the Response Body a JSON message detailing the 401
            Map<String, String> responseBodyJson = Collections.singletonMap("message", "You must log in to continue");

            response.getOutputStream().write(objectMapper.writeValueAsBytes(responseBodyJson));
            return;
        }

        // Use the TokenRegistry bean to find the user's information
        final User user = registry.findUserByToken(token);

        // Double check to make sure that token returned valid user
        if (user == null) {
            // Set the HTTP Status to be Unauthorized (401)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            // Give the Response Body a JSON message detailing the 401
            Map<String, String> responseBodyJson = Collections.singletonMap("message", "You must log in to continue");

            response.getOutputStream().write(objectMapper.writeValueAsBytes(responseBodyJson));
            return;
        }

        logger.info("{} authenticated by token successfully!", user.getUsername());

        // Pass the request along to the intended controller
        filterChain.doFilter(request, response);
    }
}

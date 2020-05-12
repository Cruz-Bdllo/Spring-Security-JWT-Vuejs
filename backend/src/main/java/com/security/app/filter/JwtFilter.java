package com.security.app.filter;

import com.security.app.security.service.MyUserDetailsService;
import com.security.app.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SignatureException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    /* ~ Properties
    ------------------------------------------------------------------------------------- */
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailsService userDetailsService;


    /* ~ Methods
    ------------------------------------------------------------------------------------- */

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Get header "Authorization" of request
        String header = request.getHeader("Authorization");

        String token = null;
        String username = null;

        // Validation the content of token
        if (header != null && header.startsWith("Bearer ")){
            token = header.substring(7);
            username = jwtUtil.extractUsername(token);
        }

        // is there token?
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // Get user of DB
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // There is token, the token is valid?
            if(jwtUtil.isValidToken(token, userDetails)){

                // We create the authentication with the values that gets in DB
                UsernamePasswordAuthenticationToken userPassAuth = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );

                // Set details the authentication
                userPassAuth.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // Set authentication with UsernamePasswordAuthenticationToken
                SecurityContextHolder.getContext().setAuthentication(userPassAuth);
            }
        } // end if


        // We send the request to next flow
        filterChain.doFilter(request, response);

    } // end method

} // end of filter for requests intercept

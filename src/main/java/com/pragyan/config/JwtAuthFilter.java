package com.pragyan.config;


import com.pragyan.repository.UserRepository;
import com.pragyan.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class JwtAuthFilter extends GenericFilter {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepo;
    public JwtAuthFilter(JwtUtil jwtUtil, UserRepository userRepo) { this.jwtUtil=jwtUtil; this.userRepo=userRepo; }

    @Override public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String h = req.getHeader("Authorization");
        if(h!=null && h.startsWith("Bearer ")) {
            String t = h.substring(7);
            if(jwtUtil.validate(t)) {
                String email = jwtUtil.getSubject(t);
                userRepo.findByEmail(email).ifPresent(user -> {
                    UserDetails principal = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password("").authorities(user.getRole()).build();
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(principal,null,principal.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                });
            }
        }
        chain.doFilter(request, response);
    }
}


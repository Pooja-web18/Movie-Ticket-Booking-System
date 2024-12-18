package com.Movie.Movie.Ticket.Booking.System.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.Movie.Movie.Ticket.Booking.System.security.jwt.SecurityConstants.JWT_KEY;

@Slf4j
@Component
public class JwtGeneratorFilter extends OncePerRequestFilter {

    private Object keys;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String jwt = generateToken(authentication);
            response.setHeader(SecurityConstants.JWT_HEADER, "Bearer " + jwt);
        }
        filterChain.doFilter(request, response);
    }
    public String generateToken(Authentication authentication) {
        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

        String jwt = Jwts.builder()
                .setIssuer("Movie-Ticket-Booking-System")
                .setSubject(authentication.getName())
                .claim("roles", getRole(authentication.getAuthorities()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30000000))
                .signWith(key)
                .compact();

        return jwt;
    }
//            response.setHeader(SecurityConstants.JWT_HEADER,"Bearer " +  jwt);
//        }

//         filterChain.doFilter(request, response);
//    }


    private List<String> getRole(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/api/login");
    }



    }


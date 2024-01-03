package com.example.security.config;

import com.example.security.user.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(    // na kazde wywołanie żadania możemy przechwycić ządanie(request) i zmienić odpowiednio odpowieedż (response)
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException

    {

        final String authHeader = request.getHeader("Authorization"); //pobiera z żądania nagłwek autoryzacyjny
        final String jwt;
        final String userEmail;

        if (authHeader == null ||!authHeader.startsWith("Bearer ")) // sprawdza czy negłwek istnieje i czy zaczyna sie ogólno przyjętym słowem Bearer
        {
            filterChain.doFilter(request,response);
            return;
        }

        jwt = authHeader.substring(7); // po słowie Bearer pobierany jest cały surowy !
        userEmail = jwtService.extractUsername(jwt);

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null)
        {
            // wywołą się jesli w tokenie Email został porawnie wyodrębniony oraz nie został jeszcze uwerzytelniony

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail); // do interfejsu przechowującego dane użytkownika dostarczamy jego NICK z DB

            if (jwtService.isTokenValid(jwt, userDetails))
            {
                //wywoła się jesli user pobrany z db ma z token który jest Valid

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken( //przkezujemy springowi w odpowienidm formacie ze został jakiś użytkonik został uwirzytleniony z konretnymi rolami
                        userDetails,null,userDetails.getAuthorities()
                );
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request) // dodaje informacje o szczegółach żądania HTTP, takie jak adres IP i identyfikator sesji.
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken); //informuje spring security ze owy użytkownik został uwirzytelniony

            }
        }
        filterChain.doFilter(request,response);

    }
}

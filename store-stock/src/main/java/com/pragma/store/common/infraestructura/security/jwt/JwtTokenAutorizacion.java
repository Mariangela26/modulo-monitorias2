package com.pragma.store.common.infraestructura.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.store.common.infraestructura.security.configuration.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JwtTokenAutorizacion extends OncePerRequestFilter {

    private final JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization == null
                || authorization.isEmpty()
            /*|| !authorization.startsWith(jwtPropiedades.getPrefix())*/
        ) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            Base64 base64url = new Base64(true);

            String[] payloadCodificado = authorization.split("\\.");
            String payloadDecodificado = new String(base64url.decode(payloadCodificado[1]),"UTF-8");

            ObjectMapper mapper = new ObjectMapper();

            UserCommand detallesUsuario = mapper.readerFor(UserCommand.class).readValue(payloadDecodificado);

            UserContextCommand userContextCommand = new UserContextCommand(
                    detallesUsuario.getEmail(),
                    detallesUsuario.getEmail());

            Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet = detallesUsuario.getTipoUsuario()
                    .stream()
                    .map(m -> new SimpleGrantedAuthority(m))
                    .collect(Collectors.toSet());

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userContextCommand,
                    null,
                    simpleGrantedAuthoritySet
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (Exception e) {
            throw new IllegalStateException("token invalido");
        }

        filterChain.doFilter(request, response);
    }
}

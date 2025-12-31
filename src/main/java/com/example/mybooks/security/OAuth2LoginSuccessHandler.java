package com.example.mybooks.security;

import com.example.mybooks.model.User;
import com.example.mybooks.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;

    public OAuth2LoginSuccessHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        DefaultOAuth2User oauthUser = (DefaultOAuth2User) authentication.getPrincipal();

        String email = oauthUser.getAttribute("email");
        String name = oauthUser.getAttribute("name");
        String googleId = oauthUser.getAttribute("sub"); 

        Optional<User> existingUserOpt = userRepository.findByEmail(email);

        if (existingUserOpt.isPresent()) {
        
            User existingUser = existingUserOpt.get();
            existingUser.setGoogleId(googleId);
            userRepository.save(existingUser);
        } else {
          
            User newUser = new User();
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setGoogleId(googleId);
            newUser.setPassword("GOOGLE");
            userRepository.save(newUser);
        }

    
        request.getSession().setAttribute("loggedUser", userRepository.findByEmail(email));

        
        response.sendRedirect("/");
    }
}

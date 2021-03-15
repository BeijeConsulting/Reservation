package it.beije.ananke.reservation.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This is a custom implementation of an AuthenticationSuccessHandler interface
 * Its role is to route the correct "welcome page" redirect depending on the type
 * of authorization of the user that just logged in.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    //Override of the standard auth success method call
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    //middleware function to handle authentication
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        //As the name suggest, return the correct target URL
        String targetUrl = determineTargetUrl(authentication);
        //Security check, if responsde is alredy committed something is not working properly from a servlet standpoint
        if (response.isCommitted()) {
            return;
        }
        //Actual response redirect
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(final Authentication authentication) {
        //Map every role with its landing page, in our case we have 2 roles but it can be changed
        Map<String, String> roleTargetUrlMap = new HashMap<>();
        roleTargetUrlMap.put("ROLE_USER", "/user/home");
        roleTargetUrlMap.put("ROLE_ADMIN", "/admin/home");

        //Retrives logged user's list of authorities.
        //Users can have more then one authority but only the first is considered.
        //Anyway for this implementation users will only have one authority so no problems there.
        //So anyway where were we, oh yeah comments...
        //Look-up for user's authority on the HashMap and return the corresponding langing page.
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if (roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap.get(authorityName);
            }
        }
        throw new IllegalStateException();
    }

    //Not really sure what this does tbh, kinda copied from the web
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
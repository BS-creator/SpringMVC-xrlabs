package SimpleAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		 Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		 System.out.println("Roles>>>>>"+roles);
	        if (roles.contains("ROLE_super_admin")) {
	        	System.out.println("invoked super admin page");
	        	redirectStrategy.sendRedirect(request, response, "/admin");
	        } else  {
	        	System.out.println("invoked admin");
	        	redirectStrategy.sendRedirect(request, response, "/sessions");
	        }
		
	}

}

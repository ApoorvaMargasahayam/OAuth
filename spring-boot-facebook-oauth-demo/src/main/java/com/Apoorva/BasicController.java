package com.Apoorva;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.Map;
import org.springframework.security.oauth2.provider.OAuth2Authentication;


@RestController
public class BasicController {
	
	@GetMapping("/")
	public String Home(Principal principal) {
		
		Map<String, Object> authDetails = (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication()
                .getDetails();

        String userName = (String) authDetails.get("name");

        return "Hi " + userName + ", Welcome!";
	}

}

package az.developia.bookshopping.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySession {
	private String username;

 public MySession() {
	 System.out.println("MySession>constructor");
	Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	String username =loggedInUser.getName();
	this.username=username;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

@PostConstruct
public void initSession() {
	System.out.println("MySession>initSession");
}
	
@PreDestroy
public void destroySession() {
	System.out.println("MySession>destroySession");
}

}

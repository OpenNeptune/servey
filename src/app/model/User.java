package app.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class User {
	
	@Getter @Setter private Integer userid;
	
	@Getter @Setter private String username;
	
	@Getter @Setter private String nickname;

	@Getter @Setter private String email;
	
	@Getter @Setter private String password;

	//用户拥有的角色组
	@Getter @Setter private Set<Role> roles = new HashSet<Role>();

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", nickname=" + nickname + ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}
	
}

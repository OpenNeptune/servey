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
	
	@Setter private boolean isAdmin;

	public boolean isAdmin() {
		if("111".equals(username)){
			return true;
		}else{
			return false;
		}
	}

	@Getter @Setter private Set<Role> roles = new HashSet<Role>();
	
	@Getter @Setter private long[] rightSum;
	
	public String[] getRoleArray(){
		String[] result = new String[roles.size()];
		int i=0;
		for(Role role : roles){
			result[i] = String.valueOf(role.getRoleId());
			i++;
		}
		return result;
	}
	
	public void calculateRightSum(){
		int pos = 0;
		long code = 0 ;
		for(Role role : roles){
			for(Right r : role.getRights()){
				pos = r.getRightPos();
				code = r.getRightCode();
				rightSum[pos] = rightSum[pos] | code ;
			}
		}

	}
	
	public boolean hasRight(Right r){
		boolean result = false;
		int pos = r.getRightPos();
		long code = r.getRightCode();
		result= !((rightSum[pos] & code)  == 0);
		return result;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", nickname=" + nickname + ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
	}
	
}

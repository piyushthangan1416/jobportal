package com.jobportal.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jobportal.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * @author Caio Fernando
 */
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User{

    /**
     *
     */
    private static final long serialVersionUID = 4928486404697932897L;
    private User user;
    

    public AuthenticatedUser(User user) {
        super(user.getEmail(),
              user.getPassword(),
              getAuthorities(user));
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user)
	{
		Set<String> roleAndPermissions = new HashSet<>();
		List<String> roles = user.getRoles();
		
		for (String role : roles)
		{
			roleAndPermissions.add(role);
		}
		String[] roleNames = new String[roleAndPermissions.size()];
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleAndPermissions.toArray(roleNames));
		return authorities;
	}
}
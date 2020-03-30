package lv.accenture.bootcamp.rardb4.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserWithId extends org.springframework.security.core.userdetails.User  {

    private Long userId;

    public UserWithId(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

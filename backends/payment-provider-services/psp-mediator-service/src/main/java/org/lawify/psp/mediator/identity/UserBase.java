package org.lawify.psp.mediator.identity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@MappedSuperclass
public abstract class UserBase implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    protected String password;
    protected String email;
    protected Set<PspRole> roles = new HashSet<>();
    protected void addRole(PspRole role){
        this.roles.add(role);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (var role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return authorities;
    }

    public List<String> getRoleNames() {
        return this.roles.stream().map(Enum::name).toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement account expiration logic
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement account locking logic
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement credentials expiration logic
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement user enable/disable logic
        return true;
    }
}

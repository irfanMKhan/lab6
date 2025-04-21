package edu.miu.cs.cs489.lesson6.dentistapp.security;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements UserDetails {

    private Long id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;

    private String email;
    private String mobile;
    private String occupation;
    private String companyName;

    private Long totalRoles;
    private String roleName;
    private Boolean isTokenExpired;


    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}

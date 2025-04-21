package edu.miu.cs.cs489.lesson6.dentistapp.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class UserGrantedAuthority implements GrantedAuthority {

    Long id;
    String role;
    String description;
    Long priority;

    public String getAuthority() {
        return this.role;
    }

}

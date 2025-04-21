package edu.miu.cs.cs489.lesson6.dentistapp.security;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO  {

    private Long id;
    private String name;
    private String description;
    private Long priority;
    private Long userId;

}

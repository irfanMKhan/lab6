package edu.miu.cs.cs489.lesson6.dentistapp.security;

import com.nagad.microservice.notification.model.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends AbstractDTO {

    private Long id;
    private String name;
    private String description;
    private Long priority;
    private Long userId;

}

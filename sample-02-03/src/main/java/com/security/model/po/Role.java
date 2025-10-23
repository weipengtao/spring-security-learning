package com.security.model.po;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Long id;
    private String roleName;
    private String description;
    private List<Permission> permissions;
}

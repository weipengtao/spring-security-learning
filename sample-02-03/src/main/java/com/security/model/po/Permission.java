package com.security.model.po;

import lombok.Data;

@Data
public class Permission {
    private Long id;
    private String permissionName;
    private String description;
}

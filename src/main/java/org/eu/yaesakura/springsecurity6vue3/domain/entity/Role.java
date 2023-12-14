package org.eu.yaesakura.springsecurity6vue3.domain.entity;

import lombok.Data;

/**
 * 角色实体类
 *
 * @author YaeSakura
 */

@Data
public class Role {
    // 角色ID
    private Integer id;
    // 角色名称
    private String name;
}

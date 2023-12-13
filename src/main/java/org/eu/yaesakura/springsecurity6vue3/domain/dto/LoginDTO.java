package org.eu.yaesakura.springsecurity6vue3.domain.dto;

import lombok.Data;

/**
 * 登录表单
 *
 * @author YaeSakura
 */

@Data
public class LoginDTO {
    // 用户名
    private String username;
    // 密码
    private String password;
}

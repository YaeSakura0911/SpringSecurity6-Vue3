package org.eu.yaesakura.springsecurity6vue3.controller;

import org.eu.yaesakura.springsecurity6vue3.domain.entity.Permission;
import org.eu.yaesakura.springsecurity6vue3.domain.entity.User;
import org.eu.yaesakura.springsecurity6vue3.domain.vo.GetUserBySessionVo;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 * @author YaeSakura
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 根据 Session 获取用户
     * @param authentication 认证信息
     */
    @GetMapping
    public GetUserBySessionVo getUserBySession(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        GetUserBySessionVo getUserBySessionVo = new GetUserBySessionVo();
        getUserBySessionVo.setName(principal.getUsername());
        getUserBySessionVo.setPermissions(principal.getPermissionList().stream().map(Permission::getCode).toList());
        return getUserBySessionVo;
    }
}
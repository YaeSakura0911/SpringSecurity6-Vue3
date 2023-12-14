package org.eu.yaesakura.springsecurity6vue3.service.impl;

import org.eu.yaesakura.springsecurity6vue3.domain.entity.*;
import org.eu.yaesakura.springsecurity6vue3.repository.*;
import org.eu.yaesakura.springsecurity6vue3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户服务实现类
 *
 * @author YaeSakura
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RolePermissionRepository rolePermissionRepository;
    private final PermissionRepository permissionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           RolePermissionRepository rolePermissionRepository,
                           PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.rolePermissionRepository = rolePermissionRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户
        User user = userRepository.getUserByUsername(username);

        // 根据用户ID查询用户角色
        List<UserRole> userRoleList = userRoleRepository.getUserRolesByUserId(user.getId());

        // 如果没有角色
        if (userRoleList.isEmpty()) {
            return user;
        }

        // 提取出角色ID
        List<Integer> roleIdList = userRoleList.stream().map(UserRole::getRoleId).toList();

        // 根据角色ID查询权限ID
        List<RolePermission> rolePermissionList = rolePermissionRepository.getRolePermissionsByRoleIds(roleIdList);

        // 如果没有权限
        if (rolePermissionList.isEmpty()) {
            return user;
        }

        // 提取出权限ID
        Set<Integer> permissionIdSet = rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toSet());

        // 根据权限ID查询权限
        List<Permission> permissionList = permissionRepository.getPermissionsByPermissionIds(permissionIdSet);

        user.setPermissionList(permissionList);

        return user;
    }
}

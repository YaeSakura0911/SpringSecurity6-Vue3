package org.eu.yaesakura.springsecurity6vue3.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.eu.yaesakura.springsecurity6vue3.domain.entity.Permission;

import java.util.List;
import java.util.Set;

/**
 * 权限持久层
 *
 * @author YaeSakura
 */

@Mapper
public interface PermissionRepository {
    /**
     * 根据权限ID集合查询权限
     * @param permissionIdSet 权限ID集合
     * @return 包含权限的列表
     */
    @Select("SELECT * FROM permission WHERE id IN #{permissionIdSet}")
    List<Permission> getPermissionsByPermissionIds(Set<Integer> permissionIdSet);
}

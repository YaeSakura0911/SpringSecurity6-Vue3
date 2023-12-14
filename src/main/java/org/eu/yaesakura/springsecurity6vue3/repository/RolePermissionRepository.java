package org.eu.yaesakura.springsecurity6vue3.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.eu.yaesakura.springsecurity6vue3.domain.entity.RolePermission;

import java.util.List;

/**
 * 角色权限关系持久层
 *
 * @author YaeSakura
 */

@Mapper
public interface RolePermissionRepository {
    /**
     * 根据角色ID列表查询角色权限关系
     * @param roleIdList 角色ID列表
     * @return 包含角色权限关系的列表
     */
    @Select("SELECT * FROM role_permission WHERE role_id IN (#{roleIdList})")
    List<RolePermission> getRolePermissionsByRoleIds(List<Integer> roleIdList);
}

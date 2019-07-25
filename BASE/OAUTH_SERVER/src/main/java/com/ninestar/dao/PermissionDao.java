package com.ninestar.dao;


import java.util.List;

import com.ninestar.entity.Permission;

/**
 * 〈权限Dao〉
 *
 */
public interface PermissionDao {

    /**
     * 根据角色id查找权限列表
     * @param roleId 角色id
     * @return 权限列表
     */
    List<Permission> findByRoleId(Integer roleId);
}

package com.ninestar.dao;



import java.util.List;

import com.ninestar.entity.Role;

/**
 * 〈角色Dao〉
 *
 */
public interface RoleDao {

    /**
     * 根据用户id查找角色列表
     * @param memberId 用户id
     * @return 角色列表
     */
    List<Role> findByMemberId(Integer memberId);
}

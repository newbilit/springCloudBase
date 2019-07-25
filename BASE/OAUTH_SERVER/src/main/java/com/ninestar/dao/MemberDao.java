package com.ninestar.dao;

import com.ninestar.entity.Member;

/**
 * 〈用户Dao〉
 *
 */
public interface MemberDao {

    /**
     * 根据会员名查找会员
     * @param memberName 会员名
     * @return 会员
     */
    Member findByMemberName(String memberName);
}

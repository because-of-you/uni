package cn.acitrus.uni.common.enums.permissions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/2/1
 **/
@AllArgsConstructor
@Getter
public enum UserRoleType {
    /**
     * 管理员角色
     */
    ADMIN,
    /**
     * 访客角色
     */
    GUEST
}

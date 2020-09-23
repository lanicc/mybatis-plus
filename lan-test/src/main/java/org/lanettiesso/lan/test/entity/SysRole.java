package org.lanettiesso.lan.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author lan
 * @date 2020/9/22
 */
@Data
@ToString
@Accessors(chain = true)
public class SysRole {

    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private Integer idRole;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 显示顺序
     */
    private Integer roleSort;

    /**
     * 角色状态(1正常，0停用)
     */
    private String status;

    /**
     * 删除标志(0存在，1删除)
     */
    private String delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新着
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 备注
     */
    private String remark;
}

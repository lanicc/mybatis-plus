package org.lanettiesso.lan.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lanettiesso.lan.test.entity.SysRole;

import java.util.List;

/**
 * @author lan
 * @date 2020/9/22
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<String> selectRolePermissionByUserId(Integer idUser);
}

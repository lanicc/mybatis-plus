package org.lanettiesso.lan.test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lanettiesso.lan.test.entity.SysRole;
import org.lanettiesso.lan.test.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

/**
 * @author lan
 * @date 2020/9/22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements RoleService {
}

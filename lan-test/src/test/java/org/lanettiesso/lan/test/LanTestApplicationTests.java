package org.lanettiesso.lan.test;

import org.junit.jupiter.api.Test;
import org.lanettiesso.lan.test.entity.SysRole;
import org.lanettiesso.lan.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class LanTestApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    void testBatchSave() {
        List<SysRole> roleList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            roleList.add(newRole().setRoleName("hahha"));
        }
        boolean b = roleService.saveBatch(roleList);
        for (SysRole sysRole : roleList) {
            System.out.println(sysRole);
        }
    }

    private SysRole newRole() {
        return new SysRole()
            .setRoleName("test-123");
    }

}

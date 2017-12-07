package com.baayso.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baayso.springboot.demo.dao.DemoUserDAO;
import com.baayso.springboot.demo.domain.DemoUserDO;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


/**
 * 测试业务。
 *
 * @author ChenFangjie (2016/4/1 16:27)
 * @since 1.0.0
 */
@Service
public class DemoUserService extends ServiceImpl<DemoUserDAO, DemoUserDO> {

    @Transactional
    public boolean saveTestUser() {
        DemoUserDO user1 = new DemoUserDO();
        user1.setName("code-1");

        super.insert(user1);

        DemoUserDO user2 = new DemoUserDO();
        user2.setName("code-2");

        super.insert(user2);

        int min = 0;
        int max = 1;
        int random = (int) (Math.random() * (max - min + 1)) + min;

        int i = 1 / (random > 5 ? 1 : 0);

        return true;
    }

    public boolean saveTestUsers() {
        DemoUserDO user3 = new DemoUserDO();
        user3.setName("code-3");

        DemoUserDO user4 = new DemoUserDO();
        user4.setName("code-4");

        List<DemoUserDO> list = new ArrayList<>();
        list.add(user3);
        list.add(user4);

        super.insertBatch(list);

        return true;
    }

    public boolean deletes() {
        List<Long> ids = new ArrayList<>();
        ids.add(7L);
        ids.add(8L);

        return super.deleteBatchIds(ids);
    }

}

package com.baayso.springboot.access.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.baayso.springboot.access.dao.AccessApiDAO;
import com.baayso.springboot.access.domain.AccessApiDO;
import com.baayso.springboot.common.service.AbstractCommonService;


/**
 * API通用业务逻辑。
 *
 * @author ChenFangjie (2017/4/17 10:25)
 * @since 1.0.0
 */
@Service
public class AccessApiService extends AbstractCommonService<AccessApiDO, Long> {

    @Inject
    private AccessApiDAO accessApiDAO;

    /**
     * 根据接入方ID查询其拥有的API列表。
     *
     * @param accessId 接入方ID
     *
     * @return API列表
     *
     * @since 1.0.0
     */
    public List<AccessApiDO> listByAccessId(Long accessId) {
        return this.accessApiDAO.listByAccessId(accessId);
    }

}
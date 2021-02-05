package com.hanko.admin.service.impl;

import com.hanko.admin.entity.SysResource;
import com.hanko.admin.mapper.SysResourceMapper;
import com.hanko.admin.service.ISysResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源总表包括：菜单资源+页面、文件等其它资源 服务实现类
 * </p>
 *
 * @author com.hanko.admin
 * @since 2021-02-03
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

}

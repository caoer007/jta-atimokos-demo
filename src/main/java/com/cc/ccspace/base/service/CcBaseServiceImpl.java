package com.cc.ccspace.base.service;

import com.cc.ccspace.base.dao.BaseDao;
import javax.annotation.Resource;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/5/7 2:06.
 */
public abstract class CcBaseServiceImpl {
     @Resource(name = "baseDao")
     protected BaseDao baseDao;
     @Resource(name="baseDao02")
     protected BaseDao baseDao02;

}

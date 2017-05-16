package com.cc.ccspace.service.test;
import com.cc.ccspace.base.dao.NameSpace;
import com.cc.ccspace.base.service.CcBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * @AUTHOR CF
 * @DATE Created on 2017/5/7 0:37.
 */
@Service
public class TestServiceImpl extends CcBaseServiceImpl implements TestService {
    //手动管理模式
    /*
    @Resource
    private JtaTransactionManager jtaTransactionManager;*/

    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
    //可采用aop配置不使用注释，针对某些命名的方法进行事务管理 readOnly =true控制库的读写 有待研究
    @Override
    public void test(int mode) throws Exception {
        Map m=new HashMap();
        m.put("uid","001");
        m.put("price","10");
        m.put("status","1");
//       TransactionManager tm= jtaTransactionManager.getTransactionManager();//手动管理模式 此时可把注解去除
          /*
        try {
            tm.getStatus();
            tm.begin();
            catch (Exception e){
            tm.rollback();
             throw new Exception("error rollback");
            }
          }

            */
            int a= baseDao.insert(NameSpace.TestMapper.TestMapper, "xaTest", m);
            int b= baseDao02.insert(NameSpace.TestMapper.TestMapper, "xaTest", m);
            if (mode==1) {
               throw new Exception("回滚测试！");
            }
        }

}

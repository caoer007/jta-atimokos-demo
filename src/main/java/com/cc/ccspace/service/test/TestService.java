package com.cc.ccspace.service.test;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/2/26 16:43.
 */
public interface TestService {
     /**  * describe: 事务测试方法
     	 * @author CAI.F
     	 * @date:  日期:2017/5/17 时间:0:17
     	 * @param mode 是否回滚 1回滚 非1不回滚
     	 */
     void test(int mode) throws Exception;
}

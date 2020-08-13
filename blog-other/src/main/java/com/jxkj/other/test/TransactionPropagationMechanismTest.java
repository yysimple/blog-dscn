package com.jxkj.other.test;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 事务传播机制
 *
 * @author: WuChengXing
 * @create: 2020-08-13 00:50
 **/
@Service
public class TransactionPropagationMechanismTest {

    /**
     * 1. springboot在下面这种情况下，ABC都是公用A的事务，虽然C会开启新的事务，但是也不会生效
     * 2. 失效原因：
     *      同一个对象内，方法互调默认失效，因为绕过了代理对象，事务是使用代理对象来控制的
     * 3. 解决办法：
     *      3.1 在主启动类上加上 @EnableAspectJAutoProxy(exposeProxy = true)
     *      2.2 开启了这个以后的所有动态代理都是aspect对外暴露对象
     *
     */

    /**
     * A 是
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void methonA(){
        System.out.println("保存A操作");
        /*methonB();
        methonC();*/

        /**
         * 这种方式的传播机制就会生效
         */
        TransactionPropagationMechanismTest transactionPropagationMechanismTest = (TransactionPropagationMechanismTest) AopContext.currentProxy();
        transactionPropagationMechanismTest.methonB();
        transactionPropagationMechanismTest.methonC();

        int i = 10 / 0;
        System.out.println(i);
    }

    /**
     *
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void methonB(){
        System.out.println("保存B操作");
    }

    /**
     *
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void methonC(){
        System.out.println("保存C操作");
    }
}

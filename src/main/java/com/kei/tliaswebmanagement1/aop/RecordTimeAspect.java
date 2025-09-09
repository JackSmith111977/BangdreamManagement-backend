package com.kei.tliaswebmanagement1.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* AOP 面向切面的编程*/
/*核心概念：
* 1.连接点JoinPoint：可以被控制的方法
* 2.通知Advice：共性功能
* 3.切入点PointCut：匹配连接点的条件，通知仅会在切入点方法执行时被应用
* 4.切面Aspect：通知与切入点的对应关系
* 5.目标对象Target：通知应用的对象*/

/* 通知类型：
* 1.@Around：环绕通知，在目标方法前后执行，返回结果（需要指定Object返回值，需要调用proceedingJoinPoint.proceed()让原方法执行）
* 2.@Before：前置通知，在目标方法执行前执行
* 3.@After：后置通知，在目标方法执行后执行，无论方法正常返回还是抛出异常都会执行
* 4.@AfterReturning：返回通知，在目标方法正常返回后执行，异常不会执行
* 5.@AfterThrowing：异常通知，在目标方法抛出异常后执行，正常返回不会执行
* */

/* 通知的执行顺序：
* 1.类名字母靠前的通知，在方法前先执行，在方法后后执行
* 2.@Order（num） 可以控制执行顺序
*   数字小的，在方法前先执行，在方法后后执行*/

/* 切入点表达式
* 1.execution
*   execution(访问修饰符？ 返回值 包名.类名.？方法名（方法参数） throw 异常？) ？表示可省略
*   ‘*’可以表示返回值、包名、类名、方法名、任意类型参数、方法名称的一部分
*   ‘..’可以在包名处表示任意层级的包、方法形参中任意类型和个数的参数*/

/* 连接点类 JoinPoint
* around的连接点类 ProceedingJoinPoint*/

/* @PointCut：可以指定公共切入点
* public:别的切面类可以调用此公共切入点
* private:仅本切面类可以调用 */

@Aspect// 标识aop类，切面类
@Component
public class RecordTimeAspect{

    private static final Logger log = LoggerFactory.getLogger(RecordTimeAspect.class);

    //@Around("execution(* com.kei.tliaswebmanagement1.service.Impl.ClazzsServiceImpl.list(com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam))")
    //@Around("execution(* com..service.Impl.ClazzsServiceImpl.list(*))")
    //@Around("execution(* com.kei.tliaswebmanagement1..Impl.*.list(com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam))")
    //@Around("execution(* com.kei.tliaswebmanagement1..Impl.*.l*(com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam))")
    //@Around("execution(* com.kei.tliaswebmanagement1..Impl.*.*t(com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam))")
    //@Around("execution(* com.kei.tliaswebmanagement1..Impl.*.*s*(com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam))")
    //@Around("execution(* com.kei.tliaswebmanagement1..Impl.*.*s*(..))")
    // 接口匹配
    //@Around("execution(* com.kei.tliaswebmanagement1.service.*.list(..))")
    // 多个方法匹配，可用逻辑表达式
    //@Around("execution(* com.kei.tliaswebmanagement1.service.Impl.ClazzsServiceImpl.list(..)) ||"+
    //        "execution(* com.kei.tliaswebmanagement1.service.Impl.ClazzsServiceImpl.deleteById(..))")

    // @annotation：指定注解匹配,只需要在目标方法加LogOperation注解即可
    @Around("@annotation(com.kei.tliaswebmanagement1.anno.LogOperation)")


    //@Around("com.kei.tliaswebmanagement1.aop.MyAspect.publicPointcut()")// 标识需要拦截的方法，切入点
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {// 通知，通过将本方法作为代理对象，将通知方法应用到目标方法上
        // 1. 获取开始时间
        long begin = System.currentTimeMillis();

        // 2. 执行原始代码
            Object result = proceedingJoinPoint.proceed();

        // 3. 获取结束时间
        long end = System.currentTimeMillis();
        log.info("方法执行耗时：{}ms", end - begin);

        return result;
    }

    @Before("execution(* com.kei.tliaswebmanagement1.service.Impl.*.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("before");
        // 1.获取目标对象
        Object target = joinPoint.getTarget();
        log.info("目标对象：{}", target);

        // 2.获取目标类
        String targetClass = joinPoint.getTarget().getClass().getName();
        log.info("目标类：{}", targetClass);

        // 3.获取目标方法
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法：{}", methodName);

        // 4.获取目标方法参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法参数：{}", args);
    }

}

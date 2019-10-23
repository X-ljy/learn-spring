package com.ljy.qx.learnaop.annotation;

import java.lang.annotation.*;

/**
 * @author : 夕
 * @date : 2019/10/23
 */

@Documented //该注解将被包含在Javadoc中
@Retention(RetentionPolicy.RUNTIME) //注解会在字节码中存在，在运行时可以通过反射获取到
@Target(ElementType.METHOD) //该注解只能声明在方法前
@Inherited //说明子类可以继承父类中的该注解
public @interface LogAnnoatation {

    String value() default "----LogAnnoatation注解调用----";

}

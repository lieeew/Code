package com.hspedu.Spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * ClassName: UserAction
 * Package: com.hspedu.Spring
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 12:43
 * @Description:
 */
/*
    1. 我也可以使用 @Controller
    2. 在默认条件下, 我们配置的 4种注解 都是单例的
    3. @Scope("prototype") 表示以多实现
 */
@Component
@Scope("prototype") // 表示使用多例
public class UserAction {


}

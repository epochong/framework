package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author epochong
 * @date 2019/7/12 20:34
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
//运行时注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Benchmark {
}

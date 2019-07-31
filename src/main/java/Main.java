/**
 * @author epochong
 * @date 2019/7/12 20:00
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */

import annotations.Benchmark;
import annotations.Measurement;
import annotations.cases.StringConcatCase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //默认配置
        int iterations = 10;
        int group = 5;
        StringConcatCase object = new StringConcatCase();
        Class  cls = object.getClass();
        Annotation annotationMeasurement = cls.getAnnotation(Measurement.class);
        //如果给定参数值这使用给定的，如果没有就使用默认值
        if (annotationMeasurement != null) {
            Measurement measurement = (Measurement) annotationMeasurement;
            iterations = measurement.iterations();
            group = measurement.group();
        }

        Method[] methods = cls.getMethods();
        //哪些方法被BenchMark注释
        for (Method method : methods
                ) {
            Annotation annotationBenchmark = method.getAnnotation(Benchmark.class);
            if (annotationBenchmark == null) {
                continue;
            }
            int methodIterations = iterations;
            int methodGroup = group;
            System.out.println(method.getName());
            Measurement methodAnnotation = method.getAnnotation(Measurement.class);
            if (methodAnnotation != null) {
                Measurement methodMeasurement = (Measurement) methodAnnotation;
                methodIterations = methodMeasurement.iterations();
                methodGroup = methodMeasurement.group();
            }
            for (int i = 0; i < methodGroup; i++) {
                long t1 = System.nanoTime();
                for (int j = 0; j < methodIterations; j++) {
                    method.invoke(object);
                }
                long t2 = System.nanoTime();
                System.out.println(i + " " + (t2 - t1));
            }
        }
    }
}
/*
public class Main {
    public static void main(String[] args) {
        Class<?> cls = Main.class;
        Annotation annotation = cls.getAnnotation(Measurement.class);
        if (annotation == null) {
            System.out.println("没有使用");
            return;
        }
        Measurement measurement = (Measurement)annotation;
        System.out.println(measurement.iterations());
        System.out.println(measurement.group());
    }
}
*/

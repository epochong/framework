package annotations.cases;

import annotations.Benchmark;
import annotations.Measurement;

/**
 * @author epochong
 * @date 2019/7/12 20:35
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
@Measurement(iterations = 1000, group = 5)
public class StringConcatCase {
    private void doNothing() {

    }
    @Benchmark
    public String testStringAdd() {
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += i;
        }
        return s;
    }
    @Benchmark
    public String testStringBuilderAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}

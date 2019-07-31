package annotations.cases;

import annotations.Benchmark;
import annotations.Measurement;

/**
 * @author epochong
 * @date 2019/7/12 21:04
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
@Measurement(iterations = 10, group = 2)
public class SortCase {
    @Benchmark
    public void sort() {
        int[] a = {1,2,3,4};

    }
}

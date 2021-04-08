package io.github.gcdd1993.interview.pacvue;

/**
 * 实现Queue，进行服务限流
 * <p>
 * Created by gcdd1993 on 2021/4/8.
 */
public class Question3 {

    public void fun1(String userToken) {
        boolean limited = false;

        // 因为Queue是先进先出队列，可以基于它实现限流

        if (limited) {
            throw new IllegalArgumentException("限流");
        }
    }

}

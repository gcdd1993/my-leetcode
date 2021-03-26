package leetcode.editor.cn;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * [1116]打印零与奇偶数 Created By gcdd1993 on 2021-03-26 01:28:30.
 * <p/>
 * 解题思路：
 * TODO
 */
public class PrintZeroEvenOdd {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd solution = new PrintZeroEvenOdd().new ZeroEvenOdd(9);
        new Thread(() -> {
            try {
                solution.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                solution.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                solution.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(10_000);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 信号量实现
     */
    class ZeroEvenOdd {
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        private final Semaphore zero = new Semaphore(1);
        private final Semaphore even = new Semaphore(0);
        private final Semaphore odd = new Semaphore(0);

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                // 等待信号量
                zero.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    even.release();
                } else {
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    // zync实现
//class ZeroEvenOdd {
//    private int n;
//
//    public ZeroEvenOdd(int n) {
//        this.n = n;
//    }
//
//    private class Wrapper {
//        int i = 1;
//    }
//
//    private final String z = "zero";
//    private final Wrapper wrapper = new Wrapper();
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        while (wrapper.i <= n) {
//            // 等待Z锁
//            synchronized (z) {
//                printNumber.accept(0);
//                // 释放Z锁，并阻塞当前线程
//                z.wait();
//                synchronized (wrapper) {
//                    wrapper.i++;
//                    wrapper.notifyAll();
//                }
//            }
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        while (wrapper.i <= n) {
//            // 等待wrapper锁
//            synchronized (wrapper) {
////                    System.out.println("even获取Wrapper锁");
//                if (wrapper.i % 2 == 0) {
//                    synchronized (z) {
//                        printNumber.accept(wrapper.i);
//                        z.notifyAll();
//                    }
//                }
//                wrapper.wait();
//            }
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        while (wrapper.i <= n) {
//            // 等待wrapper锁
//            synchronized (wrapper) {
////                    System.out.println("odd获取Wrapper锁");
//                if (wrapper.i % 2 == 1) {
//                    synchronized (z) {
//                        printNumber.accept(wrapper.i);
//                        z.notifyAll();
//                    }
//                }
//                wrapper.wait();
//            }
//        }
//    }
//
//}

}
//假设有这么一个类： 
//
// class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // 构造函数
//  public void zero(printNumber) { ... }  // 仅打印出 0
//  public void even(printNumber) { ... }  // 仅打印出 偶数
//  public void odd(printNumber) { ... }   // 仅打印出 奇数
//}
// 
//
// 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程： 
//
// 
// 线程 A 将调用 zero()，它只输出 0 。 
// 线程 B 将调用 even()，它只输出偶数。 
// 线程 C 将调用 odd()，它只输出奇数。 
// 
//
// 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n
//。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出："0102"
//说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出："0102030405"
// 
// 👍 90 👎 0

package leetcode.editor.cn;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * [1115]交替打印FooBar Created By gcdd1993 on 2021-03-29 18:39:59.
 * <p/>
 * 解题思路：
 * TODO
 */
public class PrintFoobarAlternately {
    public static void main(String[] args) throws InterruptedException {
        FooBar solution = new PrintFoobarAlternately().new FooBar(2);

        new Thread(() -> {
            try {
                solution.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                solution.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        Thread.sleep(3000);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FooBar {
        private int n;
        private final AtomicBoolean fooFlag = new AtomicBoolean(true);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (fooFlag) {
                    if (!fooFlag.compareAndSet(true, false)) {
                        fooFlag.wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    fooFlag.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (fooFlag) {
                    if (!fooFlag.compareAndSet(false, true)) {
                        fooFlag.wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    fooFlag.notifyAll();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
//我们提供一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2: 
//
// 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
// 👍 104 👎 0

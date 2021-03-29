package leetcode.editor.cn;

import java.util.function.IntConsumer;

/**
 * [1195]交替打印字符串 Created By gcdd1993 on 2021-03-29 19:10:00.
 * <p/>
 * 解题思路：
 * 顺序打印
 */
public class FizzBuzzMultithreaded {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzzMultithreaded().new FizzBuzz(10);

        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.number(i -> System.out.print(i + ""));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FizzBuzz {
        private int n;

        public FizzBuzz(int n) {
            this.n = n;
            this.intWrapper = new IntWrapper(1);
        }

        private class IntWrapper {
            int n;

            private IntWrapper(int n) {
                this.n = n;
            }
        }

        private final IntWrapper intWrapper;

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (intWrapper.n <= n) {
                synchronized (intWrapper) {
                    if (intWrapper.n % 3 == 0 && intWrapper.n % 5 != 0) {
                        printFizz.run();
                        intWrapper.n++;
                        intWrapper.notifyAll();
                    } else {
                        intWrapper.wait();
                    }
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (intWrapper.n <= n) {
                synchronized (intWrapper) {
                    if (intWrapper.n % 5 == 0 && intWrapper.n % 3 != 0) {
                        printBuzz.run();
                        intWrapper.n++;
                        intWrapper.notifyAll();
                    } else {
                        intWrapper.wait();
                    }
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (intWrapper.n <= n) {
                synchronized (intWrapper) {
                    if (intWrapper.n % 3 == 0 && intWrapper.n % 5 == 0) {
                        printFizzBuzz.run();
                        intWrapper.n++;
                        intWrapper.notifyAll();
                    } else {
                        intWrapper.wait();
                    }
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (intWrapper.n <= n) {
                synchronized (intWrapper) {
                    if (intWrapper.n % 3 != 0 && intWrapper.n % 5 != 0) {
                        printNumber.accept(intWrapper.n++);
                        intWrapper.notifyAll();
                    } else {
                        intWrapper.wait();
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
//编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是： 
//
// 
// 如果这个数字可以被 3 整除，输出 "fizz"。 
// 如果这个数字可以被 5 整除，输出 "buzz"。 
// 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。 
// 
//
// 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14
//, fizzbuzz。 
//
// 假设有这么一个类： 
//
// 
//class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//} 
//
// 请你实现一个有四个线程的多线程版 FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用： 
//
// 
// 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。 
// 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。 
// 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。 
// 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。 
// 
//
// 
//
// 提示： 
//
// 
// 本题已经提供了打印字符串的相关方法，如 printFizz() 等，具体方法名请参考答题模板中的注释部分。 
// 
//
// 
// 👍 46 👎 0

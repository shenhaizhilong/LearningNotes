
某日在群里看到如下题,就顺便写了一段代码：
请写一段程序，让其运行时的表现为触发5次ygc,然后3次fgc，然后3次ygc,然后1次fgc，请给出代码以及启动参数

分析：
1. 触发ygc： 年轻代空间不足，自然会触发ygc;为了简化程序，我们需要设定比较小的堆空间，启动参数  -Xms10M -Xmx10M； 为了看到GC 日志需要：
 -XX:+PrintGCDetails
2. 触发fgc，我们需要在老年代新建大的对象，让老年代空间不足；
3. 垃圾回收器应该采用：串行垃圾回收器

java 启动参数： -Xms10M -Xmx10M -XX:+PrintGCDetails -verbose:gc -XX:+UseSerialGC  



```java

package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2019/3/5 10:19
 */
public class GCTimes {

    private static final int One_MB = 1024*1024;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("create a " + (i +1) + " MB");
            byte[] b1 = new byte[One_MB];
        }


        for (int i = 0; i < 4; i++) {
            byte[] b2 = new byte[5*One_MB];
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("created  " + (i +1) + " MB");
            byte[] b1 = new byte[One_MB];
        }

        for (int i = 0; i < 1; i++) {
            byte[] b2 = new byte[5*One_MB];
        }


    }
}


```

GC details:

```html

create a 1 MB
create a 2 MB
[GC (Allocation Failure) [DefNew: 2344K->320K(3072K), 0.0015032 secs] 2344K->655K(9920K), 0.0015439 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
create a 3 MB
create a 4 MB
[GC (Allocation Failure) [DefNew: 2420K->0K(3072K), 0.0006812 secs] 2756K->655K(9920K), 0.0007110 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
create a 5 MB
create a 6 MB
[GC (Allocation Failure) [DefNew: 2101K->0K(3072K), 0.0001359 secs] 2756K->655K(9920K), 0.0001752 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
create a 7 MB
create a 8 MB
[GC (Allocation Failure) [DefNew: 2101K->0K(3072K), 0.0001186 secs] 2756K->655K(9920K), 0.0001378 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
create a 9 MB
create a 10 MB
[GC (Allocation Failure) [DefNew: 2101K->0K(3072K), 0.0001095 secs] 2756K->655K(9920K), 0.0001420 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [DefNew: 1024K->0K(3072K), 0.0002983 secs][Tenured: 5775K->655K(6848K), 0.0011633 secs] 6799K->655K(9920K), [Metaspace: 126K->126K(4480K)], 0.0014971 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [DefNew: 0K->0K(3072K), 0.0002273 secs][Tenured: 5775K->655K(6848K), 0.0010976 secs] 5775K->655K(9920K), [Metaspace: 126K->126K(4480K)], 0.0013733 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [DefNew: 0K->0K(3072K), 0.0002469 secs][Tenured: 5775K->655K(6848K), 0.0011225 secs] 5775K->655K(9920K), [Metaspace: 126K->126K(4480K)], 0.0014080 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
created  1 MB
created  2 MB
created  3 MB
[GC (Allocation Failure) [DefNew: 2101K->0K(3072K), 0.0002190 secs] 7877K->5775K(9920K), 0.0002432 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
created  4 MB
created  5 MB
[GC (Allocation Failure) [DefNew: 2102K->0K(3072K), 0.0005841 secs] 7877K->5775K(9920K), 0.0006113 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
created  6 MB
created  7 MB
[GC (Allocation Failure) [DefNew: 2102K->0K(3072K), 0.0001620 secs] 7877K->5775K(9920K), 0.0001892 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
created  8 MB
[GC (Allocation Failure) [DefNew: 2101K->0K(3072K), 0.0001688 secs][Tenured: 5775K->626K(6848K), 0.0014027 secs] 7877K->626K(9920K), [Metaspace: 126K->126K(4480K)], 0.0016274 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 3072K, used 55K [0x04a00000, 0x04d50000, 0x04d50000)
  eden space 2752K,   2% used [0x04a00000, 0x04a0dda0, 0x04cb0000)
  from space 320K,   0% used [0x04cb0000, 0x04cb0000, 0x04d00000)
  to   space 320K,   0% used [0x04d00000, 0x04d00000, 0x04d50000)
 tenured generation   total 6848K, used 5746K [0x04d50000, 0x05400000, 0x05400000)
   the space 6848K,  83% used [0x04d50000, 0x052ec820, 0x052eca00, 0x05400000)
 Metaspace       used 126K, capacity 2280K, committed 2368K, reserved 4480K

Process finished with exit code 0

```
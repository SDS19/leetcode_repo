package test;

import org.openjdk.jmh.annotations.*;
import sort.quicksort.MergeSort_1;
import sort.quicksort.QuickSort_1;
import sort.quicksort.QuickSort_2;
import sort.quicksort.QuickSort_3;

import java.util.Arrays;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@Threads(8)
@Fork(1)
public class Test {

    @Benchmark
    public void test(){
        int[] arr = {2,6,5,3,8,7,1,0};
        Arrays.sort(arr);
    }

    @Benchmark
    public void test_1(){
        int[] arr = {2,6,5,3,8,7,1,0};
        QuickSort_1.sort(arr);
    }

    @Benchmark
    public void test_2(){
        int[] arr = {2,6,5,3,8,7,1,0};
        QuickSort_2.sort(arr);
    }

    @Benchmark
    public void test_3(){
        int[] arr = {2,6,5,3,8,7,1,0};
        QuickSort_3.sort(arr);
    }

    @Benchmark
    public void test_4(){
        int[] arr = {2,6,5,3,8,7,1,0};
        MergeSort_1.sort(arr);
    }

}

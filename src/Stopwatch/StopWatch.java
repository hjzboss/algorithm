package Stopwatch;
//简单的计时器
public class StopWatch {
    private final long start;

    public StopWatch(){
        start = System.currentTimeMillis();//初始化计时器
    }

    public double elapsedTime(){//返回所经过的时间
        long now = System.currentTimeMillis();
        return (now - start)/1000.0;
    }
}

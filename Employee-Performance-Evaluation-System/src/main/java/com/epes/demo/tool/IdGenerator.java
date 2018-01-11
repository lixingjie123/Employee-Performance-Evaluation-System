package com.epes.demo.tool;

/**
 * ID生成器
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

public class IdGenerator {
    /**
     *  开始该类生成ID的时间截，1288834974657 (Thu, 04 Nov 2010 01:42:54 GMT) 这一时刻到当前时间所经过的毫秒数
     *  占 41 位（还有一位是符号位，永远为 0）。
     */
    private final long startTime = 1288834974657L;

    /**
     *  机器id所占的位数
     */
    private long workerIdBits = 5L;

    /**
     * 数据标识id所占的位数
     */
    private long datacenterIdBits = 5L;

    /**
     * 支持的最大机器id，结果是31,这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数
     */
    private long maxWorkerId = ~(-1L << workerIdBits);

    /**
     * 支持的最大数据标识id
     */
    private long maxDatacenterId = ~(-1L << datacenterIdBits);

    /***
     * 序列在id中占的位数
     */
    private long sequenceBits = 12L;

    /**
     * 机器id向左移12位
     */
    private long workerIdLeftShift = sequenceBits;

    /**
     * 数据标识id向左移17位
     */
    private long datacenterIdLeftShift = workerIdBits + workerIdLeftShift;

    /***
     * 时间截向左移5+5+12=22位
     */
    private long timestampLeftShift = datacenterIdBits + datacenterIdLeftShift;

    /***
     * 生成序列的掩码，这里为1111 1111 1111
     */
    private long sequenceMask = ~(-1 << sequenceBits);

    private long workerId;

    private long datacenterId;

    /***
     * 同一个时间截内生成的序列数，初始值是0，从0开始
     */
    private long sequence = 0L;

    /***
     * 上次生成id的时间截
     */
    private long lastTimestamp = -1L;

    public IdGenerator(long workerId, long datacenterId){
        if(workerId < 0 || workerId > maxWorkerId){
            throw new IllegalArgumentException(
                    String.format("workerId[%d] is less than 0 or greater than maxWorkerId[%d].", workerId, maxWorkerId));
        }
        if(datacenterId < 0 || datacenterId > maxDatacenterId){
            throw new IllegalArgumentException(
                    String.format("datacenterId[%d] is less than 0 or greater than maxDatacenterId[%d].", datacenterId, maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    /***
     * 生成id
     */
    public synchronized long nextId(){
        long timestamp = timeGen();
        if(timestamp < lastTimestamp){
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果是同一时间生成的，则自增
        if(timestamp == lastTimestamp){
            sequence = (sequence + 1) & sequenceMask;
            if(sequence == 0){
                //生成下一个毫秒级的序列
                timestamp = tilNextMillis();
                //序列从0开始
                sequence = 0L;
            }
        }else{
            //如果发现是下一个时间单位，则自增序列回0，重新自增
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - startTime) << timestampLeftShift)
                | (datacenterId << datacenterIdLeftShift)
                | (workerId << workerIdLeftShift)
                | sequence;
    }

    protected long tilNextMillis(){
        long timestamp = timeGen();
        if(timestamp <= lastTimestamp){
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen(){
        return System.currentTimeMillis();
    }

}

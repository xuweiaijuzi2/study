package com.xuwei.redis.demo1;

import redis.clients.jedis.Jedis;

/**
 * @program: study
 * @Date: 2024/10/11 17:07
 * @Author: Mr.Xu
 * @Description:
 */
public class RedisLock {

    private Jedis jedis;
    private String lockKey;
    private String lockValue;
    private int exprieTime;
    private boolean locked;

    public RedisLock(Jedis jedis, String lockKey, int exprieTime) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.exprieTime = exprieTime;
        this.lockValue = Thread.currentThread().getId() + "-" +System.nanoTime();
    }

    public boolean lock(){
        long startTime = System.currentTimeMillis();
        while (true){
            long result = jedis.setnx(lockKey.getBytes(), lockValue.getBytes());// 没有设置锁过期
            if (result == 1){
                locked = true;
                return true;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() - startTime >= exprieTime){
                return false;
            }
        }
    }

    public void unlock() {
        if (!locked) {
            return;
        }
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        jedis.eval(script, 1, lockKey, lockValue);
    }
}

package self.sunng.redis.pubsub;

import redis.clients.jedis.Jedis;

/**
 * Created by sunxiaodong on 2017/2/4.
 */
public class Sub {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);

        MyListener listener= new MyListener();

        jedis.subscribe(listener, "pubsub");

    }
}

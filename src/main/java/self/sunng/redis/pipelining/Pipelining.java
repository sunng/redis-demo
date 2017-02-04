package self.sunng.redis.pipelining;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.Set;

/**
 * Created by sunxiaodong on 2017/2/4.
 */
public class Pipelining {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);

        Pipeline pipeline = jedis.pipelined();
        pipeline.set("fool", "bar");
        pipeline.zadd("fooz", 1, "barowitch");  pipeline.zadd("fooz", 0, "barinsky");
        pipeline.zadd("fooz", 0, "barikoviev");
        Response<String> pipeString = pipeline.get("fool");
        Response<Set<String>> sose = pipeline.zrange("fooz", 0, -1);
        pipeline.sync();

        int soseSize = sose.get().size();
        System.out.println(soseSize);
        Set<String> setBack = sose.get();
        System.out.println(setBack);
    }
}

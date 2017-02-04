package self.sunng.redis.transaction;

import redis.clients.jedis.Jedis;

/**
 * Created by sunxiaodong on 2017/2/4.
 */
public class Transaction {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // System.out.println(jedis.zadd("foo", 0, "aaa"));
        // System.out.println(jedis.get("foo"));
        // jedis.watch (key1, key2, ...);
        // redis.clients.jedis.Transaction transaction = jedis.multi();
        // transaction.set("foo", "bar");
        // transaction.set("foo1", "bar1");
        // transaction.exec();


        redis.clients.jedis.Transaction transaction1 = jedis.multi();
        try {
            // jedis.watch("foo");
            // transaction1.set("foo", "bbb");
            // transaction1.set("fool", "bar2");
            // Response<String> result1 = transaction1.get("fool");

            // transaction1.zadd("fooz", 1, "barowitch");
            // transaction1.zadd("fooz", 0, "barinsky");
            transaction1.zadd("fooz", 0, "1");
            transaction1.zadd("foo", 0, "barikoviev");
            transaction1.zadd("fooz", 0, "2");
            // Response<Set<String>> sose = transaction1.zrange("fooz", 0, -1);
            transaction1.exec();

            // String foolbar = result1.get();
            // System.out.println(foolbar);
            // int soseSize = sose.get().size();
            // System.out.println(soseSize);
        } catch(Exception e) {
            e.printStackTrace();
            transaction1.discard();
        }



        // List<Object> allResults = transaction1.exec();                 // you could still get all results at once, as before
    }
}

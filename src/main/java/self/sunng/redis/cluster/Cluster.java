package self.sunng.redis.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunxiaodong on 2017/2/4.
 */
public class Cluster {

    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 30001));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 30002));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 30003));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 30004));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 30005));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 30006));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");
        System.out.println(value);
    }
}

package self.sunng.redis.pubsub;

import redis.clients.jedis.JedisPubSub;

/**
 * Created by sunxiaodong on 2017/2/4.
 */
public class MyListener extends JedisPubSub {

    public void onMessage(String channel, String message) {
        System.out.println("onMessage : " + channel + "," + message);
    }

    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe : " + channel + "," + subscribedChannels);
    }

    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("onUnsubscribe : " + channel + "," + subscribedChannels);
    }

    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe : " + pattern + "," + subscribedChannels);
    }

    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe : " + pattern + "," + subscribedChannels);
    }

    public void onPMessage(String pattern, String channel,
                           String message) {

        System.out.println("onPMessage : " + pattern + "," + channel + "," + message);
    }
}

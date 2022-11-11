package lection16.lesson16;

public class Client extends Thread {
    private boolean reading = false;
    private ChannelPool<AudioChannel> pool;

    public Client(ChannelPool<AudioChannel> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        AudioChannel channel = null;
        try {
            channel = pool.getResource(500);
            reading = true;
            System.out.println("Ch: " + getId() + " : " + channel);
            System.out.println("Channel Client #" + getId() + " took channel #" + channel.getChannelId());
        } catch (ResourceException e) {
            System.out.println("Client #" + getId() + " lost ->" + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Null pointer hello: " + getId() + " -> " + e);
        } finally {
            if (channel != null) {
                reading = false;
                System.out.println("Channel Client #" + getId() + " " + channel.getChannelId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }

    public boolean isReading() {
        return reading;
    }
}

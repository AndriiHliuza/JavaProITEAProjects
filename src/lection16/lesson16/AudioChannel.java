package lection16.lesson16;

import java.util.Random;

public class AudioChannel {
    private int channelId;

    public AudioChannel(int channelId) {
        this.channelId = channelId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void using() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "AudioChannel{" +
                "channelId=" + channelId +
                '}';
    }
}

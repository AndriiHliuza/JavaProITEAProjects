package lection16.lesson16;

import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        LinkedList<AudioChannel> list = new LinkedList<>() {
            {
                this.add(new AudioChannel(771));
                this.add(new AudioChannel(883));
                this.add(new AudioChannel(550));
                this.add(new AudioChannel(337));
                this.add(new AudioChannel(442));
            }
        };
//        var list2 = new LinkedList<AudioChannel>();
//        list2.add(new AudioChannel(771));
//        list2.add(new AudioChannel(883));
//        list2.add(new AudioChannel(550));
//        list2.add(new AudioChannel(337));
//        list2.add(new AudioChannel(442));

        System.out.println("hello world!!!!!!!!");

        var pool = new ChannelPool<>(list);

        System.out.println("hello java!!!!!!!!");

        for (int i = 0; i < 20; i++) {
            //new Client(pool).start();
            try {
                pool.getResource(44);
            } catch (ResourceException e) {
                throw new RuntimeException(e);
            }
        }

//        try {
//            Thread.sleep(1032);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Final pool: " + pool.getResources());
    }
}

package lection9.lesson9;

public class MelomanRunner {
    public static void main(String[] args) {
        MusicStyle ms = MusicStyle.CLASSIC;
        System.out.print(ms);

        switch (ms) {
            case JAZZ -> System.out.println(44);
            case CLASSIC -> System.out.println(33);
            case ROCK -> System.out.println(6);

            default -> throw new EnumConstantNotPresentException(ms.getDeclaringClass(), ms.name());
        };
        int b = 2;
        switch (b) {
            case 1 -> {new Object();}
            default -> {
                System.out.println("hello");
                int fff = 5 + 6;
                System.out.println(fff);
                int bbb = 34;
            }
        }
        switch (b) {
            case 1 :
            case 2 :
                System.out.println("hello");
                int fff = 5 + 6;
                System.out.println(fff);
                break;
            default:
                fff = 56;
                System.out.println(fff);
        }
        int v = switch (b) {
            case 1 :
            case 2 :
                System.out.println("hello");
                int fff = 5 + 6;
                System.out.println(fff);
                yield 6;
            default:
//                fff = 56;
//                System.out.println(fff);
                yield 90;
                //int bfd = 45;
                //System.out.println("bfd");
                //yield 23;

        };
        int v2 =switch (b) {
            case 1 -> 4;
            default -> {
                System.out.println("hello");
                int fff = 5 + 6;
                System.out.println(fff);
                yield 7;
            }
        };
        System.out.println("V = " + v);
        System.out.println("V2 = " + v2);
        //System.out.println("C = " + c);

    }

    public void defineSq(MusicStyle s, double ...x) {
         Object o = switch (s) {
            case JAZZ -> new Object();
            case CLASSIC -> null;
            case ROCK -> "hello";
            //case BLUES -> 5;
            default -> 357;
         };
    }
}

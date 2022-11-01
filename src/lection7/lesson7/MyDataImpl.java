package lection7.lesson7;

public class MyDataImpl implements MyData{


    public boolean isNull(String str) {
        System.out.println("check null");
        return str == null ? true : "".equals(str) ? true : false;
    }


    public static void main(String[] args) {
        MyDataImpl myData = new MyDataImpl();
        myData.print("");
        myData.isNull("");
    }
}

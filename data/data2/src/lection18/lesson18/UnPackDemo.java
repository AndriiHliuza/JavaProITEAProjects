package lection18.lesson18;

public class UnPackDemo {
    public static void main(String[] args) {
        String nameJar = "./example.jar";
        String destinationPath = "C:\\Users\\VivoBook\\AndriiHL\\Programming\\ITEA\\Java_Pro\\Java_Pro_Projects\\lection3\\JavaProITEAProjects\\data\\data2";
        new UnPackJar().unpack(destinationPath, nameJar);
    }
}

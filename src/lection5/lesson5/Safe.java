package lection5.lesson5;

public class Safe {
    double width = 10;
    double height = 10;
    double depth = 10;
    double safeVolume;
    public Safe(double pWidth, double pHeight, double pDepth) {
        width = pWidth;
        height = pHeight;
        depth = pDepth;
    }
//    void setSafeVolume(double pWidth, double pHeight, double pDepth) {
//        width = pWidth;
//        height = pHeight;
//        depth = pDepth;
//    }

    double getSafeVolume() {
        return width * height * depth;
    }
}

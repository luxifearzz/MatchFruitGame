package code;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PhotoElement {
    private static String path = "code/element/";

    // ImageIcon close = scaledImage(path + "close.jpg", 130, 130);
    public static ImageIcon empty = scaledImage(path + "empty.jpg", 200, 200);
    public static ImageIcon f1 = scaledImage(path + "f1.jpg", 110, 110);
    public static ImageIcon f2 = scaledImage(path + "f2.jpg", 110, 110);
    public static ImageIcon f3 = scaledImage(path + "f3.jpg", 110, 110);
    public static ImageIcon f4 = scaledImage(path + "f4.jpg", 110, 110);
    public static ImageIcon f5 = scaledImage(path + "f5.jpg", 110, 110);
    public static ImageIcon f6 = scaledImage(path + "f6.jpg", 110, 110);
    public static ImageIcon f7 = scaledImage(path + "f7.jpg", 110, 110);
    public static ImageIcon f8 = scaledImage(path + "f8.jpg", 110, 110);
    public static ImageIcon f9 = scaledImage(path + "f9.jpg", 110, 110);

    public static ImageIcon menuBG = new ImageIcon(path + "menuBG.png");
    public static ImageIcon bg = new ImageIcon(path + "bg.png");
    public static ImageIcon play = new ImageIcon(path + "play.png");
    public static ImageIcon info = new ImageIcon(path + "rule.png");
    public static ImageIcon closeInfo = new ImageIcon(path + "closeInfo.png");
    public static ImageIcon mainMenu = new ImageIcon(path + "mainMenu.png");
    public static ImageIcon submit = new ImageIcon(path + "submit.png");
    public static ImageIcon next = new ImageIcon(path + "next.png");
    public static ImageIcon dev = new ImageIcon(path + "dev.png");
    public static ImageIcon rule = new ImageIcon(path + "rule.png");
    public static ImageIcon gameRule = new ImageIcon(path + "gameRule.png");
    public static ImageIcon heart = scaledImage(path + "heart.png", 30, 30);

    public static String getPath() {
        return path;
    }

    private static ImageIcon scaledImage(String path, int width, int height) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
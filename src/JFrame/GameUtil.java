package JFrame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @program: JavaTest
 * @description
 * @author: chenyongxin
 * @create: 2019-11-17 16:01
 **/
public class GameUtil {
    // 工具类最好将构造器私有化。
    private GameUtil() {

    }

    public static Image getImage(String path) {
        BufferedImage bi = null;
        try {
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}

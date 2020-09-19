package projeto.integrador;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CarregaIMG {

    public BufferedImage loadImage(String fileName) {

        BufferedImage buff = null;
        try {
            buff = ImageIO.read(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
        return buff;
    }
}
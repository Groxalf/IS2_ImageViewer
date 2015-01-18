package persistance;

import model.RealImage;
import swing.SwingBitmap;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class BufferedImageLoader implements ImageLoader {

    private final String filePath;


    public BufferedImageLoader(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public RealImage load() {
        return new RealImage(new SwingBitmap(readImage()));
    }


    private BufferedImage readImage() {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException ex) {
            return null;
        }
    }

}

package swing;

import model.Bitmap;
import java.awt.image.BufferedImage;

public class SwingBitmap implements Bitmap{

    private final BufferedImage bufferedImage;

    public SwingBitmap(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    
    @Override
    public float getWidth() {
        return bufferedImage.getWidth();
    }

    @Override
    public float getHeight() {
        return bufferedImage.getHeight();
    }
    
}

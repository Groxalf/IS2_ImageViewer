package swing;

import model.Image;

import view.ImageViewer;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JPanel;


public class ImageViewerPanel extends JPanel implements ImageViewer{
    
    private Image image;
    private static final int SWIPE_SENSIBILITY = 50;

    public ImageViewerPanel(Image image) {
        this.image = image;
        captureMouserEvents();
        repaint();
    }


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.drawImage(((SwingBitmap)image.getBitmap()).getBufferedImage(), 0, 0, null);
    }


    @Override
    public Image getImage() {
        return image;
    }


    @Override
    public void setImage(Image image) {
        this.image = image;
        update();
    }

    
    @Override
    public void update() {
        repaint();
    }


    private void captureMouserEvents() {
        addMouseListener(new MouseSwipeEvent(new OnSwipeListener() {
            
            @Override
            public void onSwipe(MouseSwipeEvent.Direction direction) {
                HashMap<MouseSwipeEvent.Direction, Image> nearImages = new HashMap<MouseSwipeEvent.Direction, Image>();
                nearImages.put(MouseSwipeEvent.Direction.Left, image.getNext());
                nearImages.put(MouseSwipeEvent.Direction.Rigth, image.getPrev());
                setImage(nearImages.get(direction));
                repaint();
            }
        }, SWIPE_SENSIBILITY));
    }

}

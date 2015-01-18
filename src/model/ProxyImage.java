package model;

import persistance.ImageLoader;


public class ProxyImage extends Image{

    private final ImageLoader loader;
    private Image next;
    private Image prev;
    private RealImage current;

    public ProxyImage(ImageLoader loader) {
        this.loader = loader;
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public void setNext(Image next) {
        this.next = next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Image prev) {
        this.prev = prev;
    }

    private void loadImage() {
        if(current != null ) return;
        current = loader.load();
    }

    @Override
    public Bitmap getBitmap() {
        loadImage();
        return current.getBitmap();
    }
    
}

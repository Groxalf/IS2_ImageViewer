package model;


public abstract class Image {

    public abstract Bitmap getBitmap();

    public abstract Image getNext();

    public abstract void setNext(Image next);

    public abstract Image getPrev();

    public abstract void setPrev(Image prev);

}

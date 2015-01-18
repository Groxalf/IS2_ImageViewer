package swing;

import java.awt.event.MouseListener;


public class MouseSwipeEvent implements MouseListener{
    
    private int initialXMousePointer;
    private int sensibility;
    private final OnSwipeListener onSwipeListener;

    public enum Direction{
        Rigth, Left
    }

    
    public MouseSwipeEvent(OnSwipeListener listener, int sensibility){
        onSwipeListener = listener;
        this.sensibility = sensibility;
    }


    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }


    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        initialXMousePointer = e.getX();
    }


    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        if(Math.abs(e.getX() - initialXMousePointer) < sensibility) return;

        if(e.getX() - initialXMousePointer > 0){
            onSwipeListener.onSwipe(Direction.Rigth);
            return;
        }
        onSwipeListener.onSwipe(Direction.Left);
    }


    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }


    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }
    
}

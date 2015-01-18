package command;

import view.ImageViewer;


public class NextImageCommand extends Command{

    private final ImageViewer viewer;

    public NextImageCommand(ImageViewer viewer){
        this.viewer = viewer;
    }
    
    @Override
    public void execute() {
        System.out.println(viewer);
        System.out.println(viewer.getImage().getNext());
        viewer.setImage(viewer.getImage().getNext());
    }
    
}

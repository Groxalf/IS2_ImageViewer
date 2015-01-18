package command;

import view.ImageViewer;


public class PrevImageCommand extends Command{

    private final ImageViewer viewer;

    public PrevImageCommand(ImageViewer viewer){
        this.viewer = viewer;
    }
    
    @Override
    public void execute() {
        viewer.setImage(viewer.getImage().getPrev());
    }

}

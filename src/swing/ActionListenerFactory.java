package swing;

import view.ImageViewer;
import java.awt.event.ActionListener;

public interface ActionListenerFactory {

    public ActionListener create(int buttonId, ImageViewer viewer);

}

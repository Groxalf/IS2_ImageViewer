package app;
import command.Command;
import command.NextImageCommand;
import command.PrevImageCommand;
import model.Image;
import persistance.ImageDirectoryLoad;
import swing.ActionListenerFactory;
import swing.MainFrame;
import view.ImageViewer;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Application {

    private static final String PATH = "C:\\Users\\Public\\Pictures\\Sample Pictures";

    public static void main(String[] args) {
        new Application().excute();
    }

    private void excute() {
        List<Image> images = new ImageDirectoryLoad(PATH).load();

        MainFrame main = new MainFrame(new ActionListenerFactory() {
            @Override
            public ActionListener create(int buttonId, ImageViewer viewer) {
                return loadCommandSet(viewer).get(buttonId);
            }

            private Map<Integer, Command> loadCommandSet(ImageViewer viewer) {
               Map<Integer, Command> commandSet = new HashMap<>();
               commandSet.put(MainFrame.NEXT, new NextImageCommand(viewer));
               commandSet.put(MainFrame.PREV, new PrevImageCommand(viewer));
               return commandSet;
            }
        });

        main.setImage(images.get(0));
    }


    private ActionListener[] getListners(ImageViewer viewer) {
        ActionListener[] listeners =  new ActionListener[2];
        listeners[MainFrame.NEXT] = new NextImageCommand(viewer);
        listeners[MainFrame.PREV] = new PrevImageCommand(viewer);

        return listeners;
    }
}

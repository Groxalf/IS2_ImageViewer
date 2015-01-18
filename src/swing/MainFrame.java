package swing;

import model.Image;
import view.ImageViewer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{

    private ActionListenerFactory factoryListeners;
    private ImageViewer viewer;
    private Image image;
    private JButton nextBtn;
    private JButton prevBtn;
    public static final int PREV = 0;
    public static final int NEXT = 1;


    public MainFrame(ActionListenerFactory factoryListeners) {
        super("Image Browser");
        this.factoryListeners = factoryListeners;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(600, 300));
        addComponent();
    }
    
    
    public void setImage(Image image){
        this.image = image;
        this.add(createImagePanel());
        setListeners();
        setVisible(true);
    }


    private void addComponent() {
        this.add(createToolBar(), BorderLayout.SOUTH);
    }


    private JButton createButton(String btnTitle) {
        JButton button = new JButton(btnTitle);
        return button;
    }


    private Component createImagePanel() {
        ImageViewerPanel panel = new ImageViewerPanel(image);
        this.viewer = panel;
        return panel;
    }


    private void setListeners(){
        this.nextBtn.addActionListener(factoryListeners.create(MainFrame.NEXT, viewer));
        this.prevBtn.addActionListener(factoryListeners.create(MainFrame.PREV, viewer));
    }


    private Component createNextButton() {
        this.nextBtn = createButton("Next");
        return nextBtn;
    }


    private Component createPrevButton() {
        this.prevBtn = createButton("Prev");
        return this.prevBtn;
    }


    private Component createToolBar() {
        JPanel toolbar = new JPanel();
        toolbar.add(createPrevButton());
        toolbar.add(createNextButton());
        return toolbar;
    }
    
}

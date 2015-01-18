package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract  class Command implements ActionListener{

    public abstract void execute();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        execute();
    }

}

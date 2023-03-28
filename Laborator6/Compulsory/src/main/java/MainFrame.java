import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        //...TODO
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        add(canvas, CENTER); //this is BorderLayout.CENTER
        //...TODO

        //invoke the layout manager
        pack();
    }
}

package src.window;

import javax.swing.JFrame;

public class Window {

    private JFrame jFrame;

    public Window(Panel panel) {
        this.jFrame = new JFrame();
        //jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}

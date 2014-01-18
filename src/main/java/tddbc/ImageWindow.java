package tddbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton b = new JButton();
    private ImageContent i = ImageContent.RED;

    public ImageWindow() {
        super();
        b.setIcon(new ImageIcon(i.getImage()));
        getContentPane().add(b);
        //setPreferredSize(new Dimension(320,240));

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        DisplayMode displayMode = env.getDefaultScreenDevice().getDisplayMode();

        // 画面の左はしへ表示したい
        int height = displayMode.getHeight();

        pack();

        setLocation(0, height - getHeight());

        setAlwaysOnTop(true);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                i = i.next();
                b.setIcon(new ImageIcon(i.getImage()));
            }
        });

    }


}

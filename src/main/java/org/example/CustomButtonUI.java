package org.example;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButtonUI extends BasicButtonUI {
    private Image backgroundImage;

    public CustomButtonUI(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setOpaque(false);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        // Paint the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, c.getWidth(), c.getHeight(), null);
        }
        super.paint(g, c);
    }

    public static void applyCustomUI(JButton button, Image backgroundImage, Color hoverColor) {
        button.setUI(new CustomButtonUI(backgroundImage));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(null);
            }
        });
    }
}

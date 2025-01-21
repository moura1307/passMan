import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ScrollBarDetails extends BasicScrollBarUI {
    private boolean isThumbHovered = false;

    @Override
    protected void installListeners() {
        super.installListeners();
        scrollbar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Check if the mouse is over the thumb
                if (getThumbBounds().contains(e.getPoint())) {
                    if (!isThumbHovered) {
                        isThumbHovered = true;
                        scrollbar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }
                } else {
                    if (isThumbHovered) {
                        isThumbHovered = false;
                        scrollbar.setCursor(Cursor.getDefaultCursor());
                    }
                }
            }
        });

        scrollbar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                if (isThumbHovered) {
                    isThumbHovered = false;
                    scrollbar.setCursor(Cursor.getDefaultCursor());
                }
            }
        });
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set padding for the thumb
        int padding = 3;
        int x = thumbBounds.x + padding;
        int y = thumbBounds.y + padding;
        int width = thumbBounds.width - 2 * padding;
        int height = thumbBounds.height - 2 * padding;

        // Draw rounded thumb
        g2.setColor(isThumbHovered ? Color.DARK_GRAY : Color.GRAY); // Change color on hover
        int arc = 15;
        g2.fillRoundRect(x, y, width, height, arc, arc);

        g2.dispose();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the rounded track
        g2.setColor(Color.LIGHT_GRAY);
        int arc = 10;
        g2.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, arc, arc);

        g2.dispose();
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createInvisibleButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createInvisibleButton();
    }

    private JButton createInvisibleButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setVisible(false);
        return button;
    }
}

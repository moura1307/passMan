import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private JPanel mainWindow;

    public RoundedPanel(JPanel mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public Dimension getPreferredSize() {
        int backPassWidth = mainWindow.getWidth() - 50;
        int backPassHeight = mainWindow.getHeight() / 3;
        return new Dimension(backPassWidth, backPassHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw a rounded rectangle
        int arcWidth = 50;  // Width of the corner arc
        int arcHeight = 50; // Height of the corner arc
        int strokeWidth = 2;

        // Set background color
        g2.setColor(getBackground());
        g2.fillRoundRect(strokeWidth, strokeWidth, getWidth() - 2 * strokeWidth, getHeight() - 2 * strokeWidth, arcWidth, arcHeight);

        // Draw the border
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(strokeWidth));
        g2.drawRoundRect(strokeWidth, strokeWidth, getWidth() - 2 * strokeWidth, getHeight() - 2 * strokeWidth, arcWidth, arcHeight);
    }
}

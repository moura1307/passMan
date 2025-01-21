import javax.swing.*;
import java.awt.*;

class RoundedPanel extends JPanel {

    public void addContent(RoundedPanel roundedPanel, JPanel passwordsPage, int i) {
        roundedPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        roundedPanel.add(new JLabel("Rounded Panel " + (i + 1)));
        if(i >= 1) {
            passwordsPage.add(Box.createVerticalStrut(10));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        int panelWidth = getParent().getWidth() - 50;
        int panelHeight = getParent().getWidth() / 5;
        return new Dimension(panelWidth, panelHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arcWidth = 20;
        int arcHeight = 20;
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

        // Draw the border around the rounded rectangle
        g2.setColor(Color.GRAY);  // Border color
        g2.setStroke(new BasicStroke(2));  // Border width
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);  // Border around the panel
    }
}
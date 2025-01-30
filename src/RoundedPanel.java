import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class RoundedPanel extends JPanel {

    public void addContent(RoundedPanel roundedPanel, JPanel passwordsPage, int i) {
        if(i >= 1) {
            roundedPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            ImageIcon imageHolderImage = new ImageIcon("src\\img\\image.png");
            JButton siteButton = ButtonActions.createTransparentButton();
            roundedPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    dynamicSide.resizeSiteImage(roundedPanel, imageHolderImage, siteButton);
                }
            });
            roundedPanel.setLayout(new BorderLayout());

            JPanel topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            topLeftPanel.setOpaque(false);

            topLeftPanel.add(siteButton);
            roundedPanel.add(topLeftPanel, BorderLayout.NORTH);
        }
    }

    @Override
    public Dimension getMaximumSize() {
        int maxHeight = 300;
        return new Dimension(Integer.MAX_VALUE, maxHeight);
    }
    @Override
    public Dimension getPreferredSize() {
        int panelWidth = getParent().getWidth() - 500;
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
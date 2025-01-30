import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {

    public static void main(String[] args) {

        //Frame
        JFrame frame = new JFrame("PassMan");
        frame.setSize(1200, 800);
        frame.setMinimumSize(new Dimension(1200, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        //Icon
        ImageIcon icon = new ImageIcon("src\\img/icon.png");
        frame.setIconImage(icon.getImage());

        //Panel on side
        JPanel sidePanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                if ((frame.getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                    int panelWidth = frame.getWidth() / 8;
                    int panelHeight = frame.getHeight();
                    return new Dimension(panelWidth, panelHeight);
                } else if (frame.getWidth() >= 2000) {
                    int panelWidth = frame.getWidth() / 7;
                    int panelHeight = frame.getHeight();
                    return new Dimension(panelWidth, panelHeight);
                } else if (frame.getWidth() >= 1500) {
                    int panelWidth = frame.getWidth() / 6;
                    int panelHeight = frame.getHeight();
                    return new Dimension(panelWidth, panelHeight);
                } else {
                    int panelWidth = frame.getWidth() / 5;
                    int panelHeight = frame.getHeight();
                    return new Dimension(panelWidth, panelHeight);
                }
            }
        };
        sidePanel.setBackground(Color.lightGray);
        sidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        frame.add(sidePanel, BorderLayout.WEST);

        //Things on the side
        ImageIcon logoImage = new ImageIcon("src\\img/logo.png");
        ImageIcon buttonIcon = new ImageIcon("src\\img/button.png");
        ImageIcon button2Icon = new ImageIcon("src\\img/button2.png");
        JLabel logo  = new JLabel(logoImage);
        JButton button1 = ButtonActions.createTransparentButton();
        JButton button2 = ButtonActions.createTransparentButton();

        // Dynamically resize the button icon based on the side panel size
        sidePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                dynamicSide.resizeContentSide(sidePanel, logoImage, buttonIcon, button2Icon, logo, button1, button2);
            }
        });

        sidePanel.add(logo);
        sidePanel.add(button1);
        sidePanel.add(button2);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Passwords Page
        JPanel passwordsPage = new JPanel();
        passwordsPage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        passwordsPage.setLayout(new BoxLayout(passwordsPage, BoxLayout.Y_AXIS)); // Vertical arrangement

        // Add multiple RoundedPanels
        ImageIcon newPasswordIcon = new ImageIcon("src/img/New_Panel.png");
        JButton addPanelButton = ButtonActions.createTransparentButton();
        ButtonActions.addPanelAction(addPanelButton, passwordsPage);

        JPanel newPasswordPanel = new JPanel() {
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
        };
        newPasswordPanel.addComponentListener(new ComponentAdapter() {
            @Override public void componentResized(ComponentEvent e) {
                dynamicSide.resizePasswordPage(passwordsPage, newPasswordPanel, newPasswordIcon, addPanelButton);
            }
        });

        passwordsPage.add(newPasswordPanel);
        newPasswordPanel.add(addPanelButton);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(passwordsPage);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarDetails());
        scrollPane.setBorder(null);

        //Credits Page
        JPanel creditsPage = new JPanel();
        creditsPage.add(new JLabel("This is Page 2"));

        // Add pages to the main panel
        mainPanel.add(scrollPane, "passwordsPage");
        mainPanel.add(creditsPage, "creditsPage");
        frame.add(mainPanel, BorderLayout.CENTER);

        //MUST STAY AT THE END /!!!\
        ButtonActions.buttonClickAction(button1, button2, cardLayout, mainPanel);
        frame.setVisible(true);

    }

}
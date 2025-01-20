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
        ImageIcon icon = new ImageIcon("src\\icon.png");
        frame.setIconImage(icon.getImage());

        //Panel for scroll
        /*JPanel scrollPanel = new JPanel(){
            @Override
            public Dimension getPreferredSize() {
                int panelWidth = frame.getWidth() / 75;
                int panelHeight = frame.getHeight();
                return new Dimension(panelWidth, panelHeight);
            }
        };
        scrollPanel.setBackground(Color.lightGray);
        scrollPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
        frame.add(scrollPanel, BorderLayout.EAST);
        JScrollBar scrollBar = new JScrollBar(1) {
            @Override
            public Dimension getPreferredSize() {
                int panelWidth = frame.getWidth() / 75;
                return new Dimension(panelWidth, frame.getHeight());
            }
        };
        scrollPanel.add(scrollBar);*/

        //Panel on side
        JPanel sidePanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                int panelWidth = frame.getWidth() / 5;
                int panelHeight = frame.getHeight();
                return new Dimension(panelWidth, panelHeight);
            }
        };
        sidePanel.setBackground(Color.lightGray);
        sidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        frame.add(sidePanel, BorderLayout.WEST);

        //Things on the side
        ImageIcon logoImage = new ImageIcon("src\\logo.png");
        ImageIcon buttonIcon = new ImageIcon("src\\button.png");
        ImageIcon button2Icon = new ImageIcon("src\\button2.png");
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

        //Passwords Page
        JPanel passwordsPage = new JPanel();
        JPanel backPass = new RoundedPanel(passwordsPage);
        JPanel backPass2 = new RoundedPanel(passwordsPage);
        JPanel backPass3 = new RoundedPanel(passwordsPage);

        passwordsPage.add(backPass);
        passwordsPage.add(backPass2);
        passwordsPage.add(backPass3);

        //Credits Page
        JPanel creditsPage = new JPanel();
        creditsPage.add(new JLabel("This is Page 2"));

        // Add pages to the main panel
        mainPanel.add(passwordsPage, "passwordsPage");
        mainPanel.add(creditsPage, "creditsPage");
        frame.add(mainPanel, BorderLayout.CENTER);

        //MUST STAY AT THE END /!!!\
        ButtonActions.buttonClickAction(button1, button2, cardLayout, mainPanel);
        frame.setVisible(true);
    }

}
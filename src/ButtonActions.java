import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonActions {
    public static JButton createTransparentButton() {
        JButton button = new JButton() ;
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(UIManager.getColor("control"));  // Reset background color
            }
        });

        return button;
    }

    public static void buttonClickAction(JButton button1, JButton button2, CardLayout cardLayout, JPanel mainPanel) {
        button1.addActionListener(e -> cardLayout.show(mainPanel, "passwordsPage"));

        button2.addActionListener(e -> cardLayout.show(mainPanel, "creditsPage"));
    }

    public static void addPanelAction(JButton addPanelButton, JPanel passwordsPage) {
        final int[] counter = {0};

        addPanelButton.addActionListener(e -> {
            counter[0]++;
            RoundedPanel newPanel = new RoundedPanel();
            newPanel.addContent(newPanel, passwordsPage, counter[0]);
            //passwordsPage.add(newPanel, 0);

            passwordsPage.add(newPanel);
            passwordsPage.revalidate();
            passwordsPage.repaint();
        });


    }

}
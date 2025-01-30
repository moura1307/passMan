    import javax.swing.*;
    import java.awt.*;

    public class DynamicSide {
        public static void resizeContentSide(JPanel sidePanel, ImageIcon logoImage, ImageIcon buttonIcon, ImageIcon button2Icon, JLabel logo, JButton button1, JButton button2) {
            int resizeWidth = sidePanel.getWidth() - 75;
            int resizeHeight = sidePanel.getWidth() - sidePanel.getHeight();

            // Resize images
            Image resizedLogo = logoImage.getImage().getScaledInstance(resizeWidth, resizeHeight, Image.SCALE_SMOOTH);
            Image resizedButton1Image = buttonIcon.getImage().getScaledInstance(resizeWidth, resizeHeight, Image.SCALE_SMOOTH);
            Image resizedButton2Image = button2Icon.getImage().getScaledInstance(resizeWidth, resizeHeight, Image.SCALE_SMOOTH);

            // Update icons
            logo.setIcon(new ImageIcon(resizedLogo));
            button1.setIcon(new ImageIcon(resizedButton1Image));
            button2.setIcon(new ImageIcon(resizedButton2Image));
        }

        public static void resizePasswordPage(JPanel passwordsPage, JPanel newPasswordPanel, ImageIcon newPasswordIcon, JButton addPanelButton) {

            int passwordsWidth = 300;
            int passwordsHeight = 50;
            newPasswordPanel.setPreferredSize(new Dimension(passwordsWidth, passwordsHeight));
            newPasswordPanel.setMinimumSize(new Dimension(passwordsWidth, passwordsHeight));
            newPasswordPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, passwordsHeight));

            // Ensure the panel is fully laid out to get the correct width and height
            newPasswordPanel.revalidate();
            newPasswordPanel.repaint();

            // Set the button size, you can set a fixed size for the button
            addPanelButton.setPreferredSize(new Dimension(newPasswordPanel.getWidth(), newPasswordPanel.getHeight()));
            addPanelButton.setMargin(new Insets(-12, 0 ,0 ,0));

            int imageWidth;
            int imageHeight = (int) (newPasswordPanel.getHeight());
            if(newPasswordPanel.getWidth() <= 1500) {
                imageWidth = (int) (newPasswordPanel.getWidth() * 0.25);
            } else {
                imageWidth = (int) (newPasswordPanel.getWidth() * 0.1);
            }

            // Resize the image to fit inside the panel while keeping it smaller
            Image resizedPassword = newPasswordIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

            // Set the resized image as the button's icon
            addPanelButton.setIcon(new ImageIcon(resizedPassword));

            addPanelButton.setHorizontalAlignment(SwingConstants.CENTER);
            addPanelButton.setVerticalAlignment(SwingConstants.CENTER);
        }

    }
import javax.swing.*;
import java.awt.*;

public class dynamicSide {
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

}


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlankButton {
    public static JButton createTransparentButton(JPanel sidePanel) {
        JButton button = new JButton() ;

        // Set button properties to make it transparent
        //button.setPreferredSize(new Dimension(163, 50));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);

        // Add mouse listener to change cursor on hover
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

}

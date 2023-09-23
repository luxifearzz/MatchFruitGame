package code;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TimerLabel extends JLabel {
    public TimerLabel() {
        super("", SwingConstants.CENTER);
        setText("X");
        setBounds(20, 20, 40, 40);
        setFont(new Font("Prompt", Font.PLAIN, 30));
        setBackground(new Color(0xFFF2D5));
        setOpaque(true);
        setVisible(false);
    }
}

package code;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToolsPanel extends JPanel {
    public JLabel lScore;
    public JButton bReset;
    public JButton bNext;
    public JPanel pHeart;

    public ToolsPanel() {
        lScore = new JLabel();
        lScore.setPreferredSize(new Dimension(150, 30));
        lScore.setAlignmentX(Component.CENTER_ALIGNMENT);
        lScore.setFont(new Font("Prompt", Font.BOLD, 16));

        pHeart = new HeartPanel();

        bReset = new JButton();
        bReset.setIcon(PhotoElement.mainMenu);
        bReset.setPreferredSize(new Dimension(140, 50));
        bReset.setOpaque(false);
        bReset.setContentAreaFilled(false);
        bReset.setBorderPainted(false);

        bNext = new JButton();
        bNext.setIcon(PhotoElement.next);
        bNext.setPreferredSize(new Dimension(140, 50));
        bNext.setOpaque(false);
        bNext.setContentAreaFilled(false);
        bNext.setBorderPainted(false);

        setBounds(380, 475, 360, 135);   // begin at 475px top, 380px left with 360px width, 135px height.
        setLayout(new FlowLayout());
        setBackground(new Color(0xFFF2D5));
        setVisible(false);
        setBorder(new TextBubbleBorder(Color.black, 1, 16, 0));
        
        add(lScore);
        add(pHeart);
        add(bReset);
        add(bNext);
    }
}

class HeartPanel extends JPanel {
    public HeartPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(150, 30));
        setOpaque(false);
    }
}
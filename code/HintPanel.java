package code;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HintPanel extends JPanel {
    public JLabel lHint1;
    public JLabel lHint2;
    public JLabel lHint3;
    public JLabel lHint4;

    public HintPanel() {
        lHint1 = new JLabel();
        lHint2 = new JLabel();
        lHint3 = new JLabel();
        lHint4 = new JLabel();
        
        setBackground(new Color(0xFFF2D5));
        setLayout(new GridLayout(2, 2, 10, 10));  // create gridlayout size 2*2 that has space 10px.
        setBorder(new TextBubbleBorder(Color.black, 2, 16, 0));   // make pHint corner round
        setVisible(false);

        add(lHint1);
        add(lHint2);
        add(lHint3);
        add(lHint4);
    }
}
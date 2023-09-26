package code;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    public JButton bGame1;
    public JButton bGame2;
    public JButton bGame3;
    public JButton bGame4;

    public GamePanel() {
        bGame1 = new JButton();
        bGame2 = new JButton();
        bGame3 = new JButton();
        bGame4 = new JButton();

        setOpaque(false);
        setBounds(360, 30, 400, 400); // begin at 30px top, 360px left with 400px width, 400px height.
        setLayout(new GridLayout(2, 2, 25, 25));  // create gridlayout size 2*2 that has space 25px.
        setVisible(false);

        add(bGame1);
        add(bGame2);
        add(bGame3);
        add(bGame4);
    }
}
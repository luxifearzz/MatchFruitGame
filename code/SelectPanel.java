package code;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectPanel extends JPanel {
    public JButton bSel1;
    public JButton bSel2;
    public JButton bSel3;
    public JButton bSel4;
    public JButton bSel5;
    public JButton bSel6;
    public JButton bSel7;
    public JButton bSel8;
    public JButton bSel9;

    public SelectPanel() {
        bSel1 = new JButton();
        bSel2 = new JButton();
        bSel3 = new JButton();
        bSel4 = new JButton();
        bSel5 = new JButton();
        bSel6 = new JButton();
        bSel7 = new JButton();
        bSel8 = new JButton();
        bSel9 = new JButton();

        setOpaque(false);
        setBounds(40, 340, 280, 280);   // begin at 340px top, 40px left with 280px width, 280px height.
        setLayout(new GridLayout(3, 3, 6, 6));  // create gridlayout size 3*3 that has space 6px.
        setVisible(false);

        bSel1.setIcon(PhotoElement.f1);
        bSel2.setIcon(PhotoElement.f2);
        bSel3.setIcon(PhotoElement.f3);
        bSel4.setIcon(PhotoElement.f4);
        bSel5.setIcon(PhotoElement.f5);
        bSel6.setIcon(PhotoElement.f6);
        bSel7.setIcon(PhotoElement.f7);
        bSel8.setIcon(PhotoElement.f8);
        bSel9.setIcon(PhotoElement.f9);

        add(bSel1);
        add(bSel2);
        add(bSel3);
        add(bSel4);
        add(bSel5);
        add(bSel6);
        add(bSel7);
        add(bSel8);
        add(bSel9);
    }
}
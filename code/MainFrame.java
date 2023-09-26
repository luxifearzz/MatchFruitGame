package code;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
    public JButton bStart;
    public JButton bToInfo;
    public JLabel lInfo;
    public JButton bCloseInfo1;
    public JButton bCloseInfo2;

    public JLabel lBackground;

    public MainFrame() {
        initBtn();
        initInfo();
        initBackground();
    }

    public MainFrame(String title) {
        super(title);
        initBackground();
        initBtn();
        initInfo();
    }

    private void initBtn() {
        bStart = new JButton();
        bStart.setIcon(PhotoElement.play);
        bStart.setBounds(330, 210, 140, 47);
        bStart.setVisible(true);
        bStart.setOpaque(false);
        bStart.setContentAreaFilled(false);
        bStart.setBorderPainted(false);

        bToInfo = new JButton();
        bToInfo.setIcon(PhotoElement.info);
        bToInfo.setBounds(330, 310, 140, 47);
        bToInfo.setVisible(true);
        bToInfo.setOpaque(false);
        bToInfo.setContentAreaFilled(false);
        bToInfo.setBorderPainted(false);
        
        add(bStart);
        add(bToInfo);
    }

    private void initInfo() {
        lInfo = new JLabel();
        lInfo.setIcon(PhotoElement.gameRule);
        
        bCloseInfo1 = new JButton();
        bCloseInfo2 = new JButton();
        
        bCloseInfo1.setIcon(PhotoElement.closeInfo);
        bCloseInfo1.setBounds(630, 550, 140, 47);   // at bottom right
        bCloseInfo1.setOpaque(false);
        bCloseInfo1.setContentAreaFilled(false);
        bCloseInfo1.setBorderPainted(false);

        bCloseInfo2.setBounds(571, 167, 64, 29);    // at X button on screen (hidden behide picture)
        bCloseInfo2.setOpaque(false);
        bCloseInfo2.setContentAreaFilled(false);
        bCloseInfo2.setBorderPainted(false);

        lInfo.setVisible(false);
        bCloseInfo1.setVisible(false);
        bCloseInfo2.setVisible(false);

        // swap this 2 line if want to hide/show
        add(bCloseInfo1);   //this on top: show button over picture
        add(lInfo);         //this on top: hide button behide picture
        add(bCloseInfo2);
    }

    private void initBackground() {
        lBackground = new JLabel();
        lBackground.setPreferredSize(new Dimension(800, 700));
        lBackground.setIcon(PhotoElement.menuBG);
        setContentPane(lBackground);
    }
}
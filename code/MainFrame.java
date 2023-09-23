package code;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
    public JButton bStart;
    public JButton bToInfo;
    public JLabel lInfo;
    public JButton bCloseInfo;

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
        
        bCloseInfo = new JButton();
        bCloseInfo.setIcon(PhotoElement.closeInfo);
        bCloseInfo.setBounds(630, 550, 140, 47);
        bCloseInfo.setOpaque(false);
        bCloseInfo.setContentAreaFilled(false);
        bCloseInfo.setBorderPainted(false);

        lInfo.setVisible(false);
        bCloseInfo.setVisible(false);

        add(lInfo);
        add(bCloseInfo);
    }

    private void initBackground() {
        lBackground = new JLabel();
        lBackground.setPreferredSize(new Dimension(800, 700));
        lBackground.setIcon(PhotoElement.menuBG);
        setContentPane(lBackground);
    }
}
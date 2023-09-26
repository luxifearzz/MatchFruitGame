package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class App implements ActionListener {
    final boolean isRepeated = AppConfig.isRepeated;

    ImageIcon iAns1;
    ImageIcon iAns2;
    ImageIcon iAns3;
    ImageIcon iAns4;
    ImageIcon iUser1;
    ImageIcon iUser2;
    ImageIcon iUser3;
    ImageIcon iUser4;

    Timer gTimer;
    Timer hTimer;

    boolean g1isEmpty = true;
    boolean g2isEmpty = true;
    boolean g3isEmpty = true;
    boolean g4isEmpty = true;

    boolean isFreeze;
    boolean isStart;

    int score;
    int timerCounter;

    final int WIN_SCORE = AppConfig.WIN_SCORE;

    final int PHASE1 = AppConfig.PHASE1;       // start: timer game = 15 sec, timer hint = 5 sec
    final int PHASE2 = AppConfig.PHASE2;       // timer game = 10 sec, timer hint = 4 sec
    final int PHASE3 = AppConfig.PHASE3;       // timer game = 5 sec, timer hint = 4 sec
    final int PHASE4 = AppConfig.PHASE4;       // timer game = 5 sec, timer hint = 3 sec
    
    final int P1_GAME_TIMER = AppConfig.P1_GAME_TIMER;
    final int P2_GAME_TIMER = AppConfig.P2_GAME_TIMER;
    final int P3_GAME_TIMER = AppConfig.P3_GAME_TIMER;
    final int P4_GAME_TIMER = AppConfig.P4_GAME_TIMER;
    
    final int P1_OPEN_TIMER = AppConfig.P1_OPEN_TIMER;
    final int P2_OPEN_TIMER = AppConfig.P2_OPEN_TIMER;
    final int P3_OPEN_TIMER = AppConfig.P3_OPEN_TIMER;
    final int P4_OPEN_TIMER = AppConfig.P4_OPEN_TIMER;
    
    final int MAX_HEART = AppConfig.MAX_HEART;
    int now_heart = MAX_HEART;

    private MainFrame f;
    private GamePanel pGame;
    private HintPanel pHint;
    private SelectPanel pSelect;
    private TimerLabel lTimer;
    private ToolsPanel pTools;

    public App() {
        setMainFrame();
        addActionListener();
        pTools.lScore.setText("   Your score : " + score);
    }

    private void setMainFrame() {
        f = new MainFrame("Select Match Fruits Game");
        pGame = new GamePanel();
        pHint = new HintPanel();
        pSelect = new SelectPanel();
        lTimer = new TimerLabel();
        pTools = new ToolsPanel();

        f.add(pGame);
        f.add(pHint);
        f.add(pSelect);
        f.add(lTimer);
        f.add(pTools);

        setMiddle(pHint, 250, 250);
        setMiddle(f.lInfo, 500, 380);

        setHeart(now_heart);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(800, 700);
        f.setResizable(false);
        f.setVisible(true);
    }

    private void addActionListener() {
        pTools.bReset.addActionListener(this);
        pTools.bNext.addActionListener(this);
        pGame.bGame1.addActionListener(this);
        pGame.bGame2.addActionListener(this);
        pGame.bGame3.addActionListener(this);
        pGame.bGame4.addActionListener(this);
        f.bStart.addActionListener(this);
        f.bToInfo.addActionListener(this);
        f.bCloseInfo1.addActionListener(this);
        f.bCloseInfo2.addActionListener(this);
        pSelect.bSel1.addActionListener(this);
        pSelect.bSel2.addActionListener(this);
        pSelect.bSel3.addActionListener(this);
        pSelect.bSel4.addActionListener(this);
        pSelect.bSel5.addActionListener(this);
        pSelect.bSel6.addActionListener(this);
        pSelect.bSel7.addActionListener(this);
        pSelect.bSel8.addActionListener(this);
        pSelect.bSel9.addActionListener(this);

    }

    private void start() {
        lTimer.setText("X");
        isFreeze = false;
        isStart = true;

        pGame.bGame1.setIcon(PhotoElement.empty);
        pGame.bGame2.setIcon(PhotoElement.empty);
        pGame.bGame3.setIcon(PhotoElement.empty);
        pGame.bGame4.setIcon(PhotoElement.empty);

        g1isEmpty = true;
        g2isEmpty = true;
        g3isEmpty = true;
        g4isEmpty = true;

        iAns1 = null;
        iAns2 = null;
        iAns3 = null;
        iAns4 = null;
        iUser1 = null;
        iUser2 = null;
        iUser3 = null;
        iUser4 = null;

        pTools.bNext.setIcon(PhotoElement.submit);

        setPanelVisible(false);
        setMiddle(pHint, 250, 250);
        pHint.setVisible(true);
        lTimer.setVisible(true);
        
        openCard();
    }

    private void openCard() {
        ImageIcon rand1 = randomFruit();
        iAns1 = rand1;
        pHint.lHint1.setIcon(rand1);
        ImageIcon rand2 = randomFruit();
        iAns2 = rand2;
        pHint.lHint2.setIcon(rand2);
        ImageIcon rand3 = randomFruit();
        iAns3 = rand3;
        pHint.lHint3.setIcon(rand3);
        ImageIcon rand4 = randomFruit();
        iAns4 = rand4;
        pHint.lHint4.setIcon(rand4);

        if (score >= PHASE4) timerCounter = P3_OPEN_TIMER;
        else if (score >= PHASE2) timerCounter = P2_OPEN_TIMER;
        else timerCounter = P1_OPEN_TIMER;
        hTimer = new Timer(1000, e -> {
            lTimer.setText("" + timerCounter--);
            if (timerCounter < 0) {
                hTimer.stop();

                setPanelVisible(true);
                pHint.setVisible(false);
                pHint.setBounds(40, 40, 230, 230);
        
                gameTimer();
            }
        });
        hTimer.start();
    }

    private void gameTimer() {

        if (score >= PHASE3) timerCounter = P3_GAME_TIMER;
        else if (score >= PHASE2) timerCounter = P2_GAME_TIMER;
        else timerCounter = P1_GAME_TIMER;

        gTimer = new Timer(1000, e -> {
            lTimer.setText("" + timerCounter--);
            if (timerCounter < 0) {
                gTimer.stop();
                lTimer.setText("X");
                isFreeze = true;
            }
        });
        gTimer.start();
    }

    private ImageIcon randomFruit() {
        int rnd = (int)(Math.random() * 10);
        ImageIcon img = null;
        switch (rnd) {
            case 0 : img = PhotoElement.f1;
                     break;
            case 1 : img = PhotoElement.f2;
                     break;
            case 2 : img = PhotoElement.f3;
                     break;
            case 3 : img = PhotoElement.f4;
                     break;
            case 4 : img = PhotoElement.f5;
                     break;
            case 5 : img = PhotoElement.f6;
                     break;
            case 6 : img = PhotoElement.f7;
                     break;
            case 7 : img = PhotoElement.f8;
                     break;
            case 8 : img = PhotoElement.f9;
                     break;
            case 9 : img = randomFruit();
                     break;
            default : img = new ImageIcon();
                     break;
        }

        if (isRepeated) return img;

        if (img != iAns1 && img != iAns2 && img != iAns3 && img != iAns4)
            return img;
        else
            return randomFruit();
    }

    public void actionPerformed(ActionEvent ev) {
        JButton src = (JButton)ev.getSource();

        if (src == f.bToInfo) {
            f.bStart.setVisible(false);
            f.bToInfo.setVisible(false);
            f.lInfo.setVisible(true);
            f.bCloseInfo1.setVisible(true);
            f.bCloseInfo2.setVisible(true);
        } else if (src == f.bCloseInfo1 || src == f.bCloseInfo2) {
            f.bStart.setVisible(true);
            f.bToInfo.setVisible(true);
            f.lInfo.setVisible(false);
            f.bCloseInfo1.setVisible(false);
            f.bCloseInfo2.setVisible(false);
        } else if (src == f.bStart) {
            f.lBackground.setIcon(PhotoElement.bg);
            f.bStart.setVisible(false);
            f.bToInfo.setVisible(false);
            score = 0;
            now_heart = MAX_HEART;
            setHeart(now_heart);
            start();
        } else if (src == pTools.bReset) {
            resetToMainMenu();
        } else if (src == pTools.bNext) {
            if (isStart) {
                timerCounter = 0;
                gTimer.stop();

                pHint.setVisible(true);
                lTimer.setVisible(false);

                if (checkAns() == true) {
                    pTools.lScore.setText("   Your score : "+ ++score);
                    JOptionPane.showMessageDialog(f, "Congrats!", "Game Panel", JOptionPane.DEFAULT_OPTION);
                } else {
                    changeHeart(-1);
                    if (--now_heart > 0) JOptionPane.showMessageDialog(f, "Sorry, Wrong answer.", "Game Panel", JOptionPane.DEFAULT_OPTION);
                    else {
                        JOptionPane.showMessageDialog(f, "Game Over!", "Game Panel", JOptionPane.WARNING_MESSAGE);
                        resetToMainMenu();
                    }
                }

                pTools.bNext.setIcon(PhotoElement.next);
                isFreeze = true;
                isStart = false;
            } else {
                if (score >= WIN_SCORE) {
                    JOptionPane.showMessageDialog(f, "You Win! " + WIN_SCORE + " full score!!");
                    resetToMainMenu();
                    return;
                }
                start();
            }
        }else if (!isFreeze) {
            if (src == pSelect.bSel1 || src == pSelect.bSel2 || src == pSelect.bSel3 || src == pSelect.bSel4 || src == pSelect.bSel5 || src == pSelect.bSel6 || src == pSelect.bSel7 || src == pSelect.bSel8 || src == pSelect.bSel9) {
                addToGame(src);
            } else if (src == pGame.bGame1 || src == pGame.bGame2 || src == pGame.bGame3 || src == pGame.bGame4) {
                removeFromGame(src);
            }
        }
    }

    private void resetToMainMenu() {
        timerCounter = 0;
        gTimer.stop();
        setPanelVisible(false);
        lTimer.setVisible(false);
        f.bStart.setVisible(true);
        f.bToInfo.setVisible(true);
        f.lBackground.setIcon(PhotoElement.menuBG);
        score = 0;
        pTools.lScore.setText("   Your score : " + score);
    }

    private boolean checkAns() {
        if (iUser1 == iAns1 && iUser2 == iAns2 && iUser3 == iAns3 && iUser4 == iAns4) return true;
        return false;
    }

    private void setPanelVisible(boolean flag) {
        pHint.setVisible(flag);
        pGame.setVisible(flag);
        pSelect.setVisible(flag);
        pTools.setVisible(flag);
    }

    private void addToGame(JButton btn) {
        ImageIcon icon = evalIcon(btn);
        if (g1isEmpty) {
            iUser1 = icon;
            pGame.bGame1.setIcon(resizedIcon(icon));
            g1isEmpty = false;
        } else if (g2isEmpty) {
            iUser2 = icon;
            pGame.bGame2.setIcon(resizedIcon(icon));
            g2isEmpty = false;
        } else if (g3isEmpty) {
            iUser3 = icon;
            pGame.bGame3.setIcon(resizedIcon(icon));
            g3isEmpty = false;
        } else if (g4isEmpty) {
            iUser4 = icon;
            pGame.bGame4.setIcon(resizedIcon(icon));
            g4isEmpty = false;
        }
    }

    private ImageIcon evalIcon(JButton btn) {
        if (btn == pSelect.bSel1) return PhotoElement.f1;
        if (btn == pSelect.bSel2) return PhotoElement.f2;
        if (btn == pSelect.bSel3) return PhotoElement.f3;
        if (btn == pSelect.bSel4) return PhotoElement.f4;
        if (btn == pSelect.bSel5) return PhotoElement.f5;
        if (btn == pSelect.bSel6) return PhotoElement.f6;
        if (btn == pSelect.bSel7) return PhotoElement.f7;
        if (btn == pSelect.bSel8) return PhotoElement.f8;
        if (btn == pSelect.bSel9) return PhotoElement.f9;
        return new ImageIcon();
    }

    private ImageIcon resizedIcon(ImageIcon img) {
        String picture = "";
        if (img == PhotoElement.f1) picture = "f1.jpg";
        else if (img == PhotoElement.f2) picture = "f2.jpg";
        else if (img == PhotoElement.f3) picture = "f3.jpg";
        else if (img == PhotoElement.f4) picture = "f4.jpg";
        else if (img == PhotoElement.f5) picture = "f5.jpg";
        else if (img == PhotoElement.f6) picture = "f6.jpg";
        else if (img == PhotoElement.f7) picture = "f7.jpg";
        else if (img == PhotoElement.f8) picture = "f8.jpg";
        else if (img == PhotoElement.f9) picture = "f9.jpg";
        return scaledImage(PhotoElement.getPath() + picture, 200, 200);
    }
    
    private void removeFromGame(JButton btn) {
        if (btn == pGame.bGame1) {
            g1isEmpty = true;
            iUser1 = null;
        } else if (btn == pGame.bGame2) {
            g2isEmpty = true;
            iUser2 = null;
        } else if (btn == pGame.bGame3) {
            g3isEmpty = true;
            iUser3 = null;
        } else if (btn == pGame.bGame4) {
            g4isEmpty = true;
            iUser4 = null;
        }
        btn.setIcon(PhotoElement.empty);
    }

    private void setHeart(int n) {
        pTools.pHeart.removeAll();
        for (int i = 0; i < n; i++) {
            pTools.pHeart.add(new JLabel(PhotoElement.heart));
        }
        pTools.pHeart.revalidate();
    }

    private void changeHeart(int n) {
        if (n == 0) return;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                pTools.pHeart.add(new JLabel(PhotoElement.heart));
            }
        } else {
            for (int i = 0; i < -n; i++) {
                pTools.pHeart.remove(0);
            }
        }
    }

    private void setMiddle(Container p, int width, int height) {
        p.setBounds(400-(width/2), 350-(height/2), width, height);
    }

    private ImageIcon scaledImage(String path, int width, int height) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
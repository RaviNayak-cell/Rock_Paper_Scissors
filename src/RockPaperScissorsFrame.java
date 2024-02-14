import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class RockPaperScissorsFrame extends JFrame {

    JPanel mainPnl;
    JPanel titlePnl;
    JPanel decidePnl;
    JPanel statsPnl;
    JPanel winnerPnl;
    JPanel titleLbl;
    JPanel rockBtn;
    JPanel paperBtn;
    JPanel scissorsBtn;
    JPanel quitBtn;
    JPanel rockImg;
    JPanel paperImg;
    JPanel scissorsImg;


    JPanel playerWinsL;
    JPanel computerWinsL;
    JPanel tiesL;
    JTextField statsTF;
    int playerWins;
    int computerWins;
    int ties;

    JTextArea displayTA;
    JScrollPane scroller;

    Random rnd = new Random();

    public RockPaperScissorsFrame() {

        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(4,11));

        createTitlePnl();
        mainPnl.add(titlePnl);

        createDecidePnl();
        mainPnl.add(decidePnl);

        createStatsPnl();
        mainPnl.add(statsPnl);

        createWinnerPnl();
        mainPnl.add(winnerPnl);

        add(mainPnl);
        setSize(700,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createTitlePnl() {

        titlePnl = new JPanel();
        titleLbl = new JLabel("Rock Paper Scissors Game");

        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleLbl);
    }

    private void createDecidePnl() {

        decidePnl = new JPanel();
        decidePnl.setLayout(new GridLayout(1,4));
        decidePnl.setBorder(new TitledBorder(new EtchedBorder(), "Pick"));

//       rockImg = new ImageIcon("src/rockImg.png");
//       paperImg = new ImageIcon("src/paperImg.png");
//       scissorsImg = new ImageIcon("src/scissorImg.png");

        rockBtn = new JButton(rockImg);
        paperBtn = new JButton(paperImg);
        scissorsImg = new JButton(scissorsImg);
        quitBtn = new JButton("Quit");

        decidePnl.add(rockBtn);
        decidePnl.add(paperBtn);
        decidePnl.add(scissorsBtn);
        decidePnl.add(quitBtn);

        rockBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You play: Rock\n");
            play(0);
        });

        paperBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You play: Paper\n");
            play(1);
        });

        scissorsBtn.addActionListener((ActionEvent ae) -> {
            displayTA.append("You play: Scissors\n");
            play(2);
        });

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
    }

    private void createStatsPnl() {

        statsPnl = new JPanel();

        playerWinsL = new JLabel("Player Wins: 0");
        computerWinsL = new JLabel("Computer Wins: 0");
        tiesL = new JLabel("Ties: 0");

        statsTF = new JTextField(15);
    }

    private void createWinnerPnl() {

        winnerPnl = new JPanel();
        displayTA = new JTextArea(10,15);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        winnerPnl.add(scroller);
    }

    private void play(int playerMove) {

        int computerMove
    }

}

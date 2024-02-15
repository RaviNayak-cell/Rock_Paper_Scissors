import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class RockPaperScissorsFrame extends JFrame {

    Panel mainPnl;
    JPanel titlePnl;
    JPanel decidePnl;
    JPanel statsPnl;
    JPanel winnerPnl;
    JLabel titleLbl;
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;
    ImageIcon rockImg;
    ImageIcon paperImg;
    ImageIcon scissorsImg;

    JLabel playerWinsL;
    JLabel computerWinsL;
    JLabel tiesL;
    JTextField statsTF;
    int playerWins;
    int computerWins;
    int ties;

    JTextArea displayTA;
    JScrollPane scroller;

    Random rnd = new Random();

    public RockPaperScissorsFrame() {

        mainPnl = new Panel();
        mainPnl.setLayout(new GridLayout(4, 11));

        createTitlePnl();
        mainPnl.add(titlePnl);

        createDecidePnl();
        mainPnl.add(decidePnl);

        createStatsPnl();
        mainPnl.add(statsPnl);

        createWinnerPnl();
        mainPnl.add(winnerPnl);

        add(mainPnl);
        setSize(700, 900);
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
        decidePnl.setLayout(new GridLayout(1, 4));
        decidePnl.setBorder(new TitledBorder(new EtchedBorder(), "Pick"));

        ImageIcon rockIcon = new ImageIcon("src/rockImg.jpg");
        ImageIcon paperIcon = new ImageIcon("src/paperImg.jpg");
        ImageIcon scissorsIcon = new ImageIcon("src/scissorImg.jpg");

        Image rockImg = rockIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image paperImg = paperIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Image scissorsImg = scissorsIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon resizedRockIcon = new ImageIcon(rockImg);
        ImageIcon resizedPaperIcon = new ImageIcon(paperImg);
        ImageIcon resizedScissorsIcon = new ImageIcon(scissorsImg);

        rockBtn = new JButton(resizedRockIcon);
        paperBtn = new JButton(resizedPaperIcon);
        scissorsBtn = new JButton(resizedScissorsIcon);
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

            playerWinsL = new JLabel("Players Wins: 0");
            computerWinsL = new JLabel("Computers Wins: 0");
            tiesL = new JLabel("Ties: 0");

            statsPnl.add(playerWinsL);
            statsPnl.add(computerWinsL);
            statsPnl.add(tiesL);

            statsTF = new JTextField(15);
        }

    private void createWinnerPnl() {

        winnerPnl = new JPanel();
        displayTA = new JTextArea(10, 15);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        winnerPnl.add(scroller);
    }

    private void play(int playerMove) {

        int computerMove = rnd.nextInt(3);

        if (playerMove == computerMove) {
            if (playerMove == 0) {
                displayTA.append("Computer plays: Rock\n It's a tie!\n");
            } else if (playerMove == 1) {
                displayTA.append("Computer plays: Paper\n It's a tie!\n");
            }
            if (playerMove == 2) {
                displayTA.append("Computer plays: Scissors\n It's a tie!\n");
            }
            ties++;
            tiesL.setText("Ties: " + ties);
        } else if (playerMove == 1 && computerMove == 0) {
            displayTA.append("Computer plays: Rock\n Paper covers Rock (Player Wins)\n");
            playerWins++;
        } else if (playerMove == 0 && computerMove == 1) {
            displayTA.append("Computer plays: Paper\n Paper covers Rocker (Computer Wins)\n");
            computerWins++;
        } else if (playerMove == 2 && computerMove == 0) {
            displayTA.append("Computer plays: Rock\n Rock breaks Scissors (Computer Wins)\n");
            computerWins++;
            ;
        } else if (playerMove == 0 && computerMove == 2) {
            displayTA.append("Computer plays: Scissors\n Rock breaks Scissors (Player Wins)\n");
            playerWins++;
        } else if (playerMove == 2 & computerMove == 1) {
            displayTA.append("Computer plays: Paper\n Scissors cuts Paper (Player Wins)\n");
            playerWins++;
        } else if (playerMove == 1 && computerMove == 2) {
            displayTA.append("Computer plays: Scissors\n Scissors cuts Paper (Computer Wins)\n");
            computerWins++;
        }
        playerWinsL.setText("Player Wins: " + playerWins);
        computerWinsL.setText("Computer Wins: " + computerWins);
    }
}
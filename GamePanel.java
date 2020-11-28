import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel implements ActionListener{

    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    GamePanel(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("Tic-Tac-Toe");

        textfield.setBackground(new Color(225,225,225));
        textfield.setForeground(new Color(0,0,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,85));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(200,10,900,640);

        button.setLayout(new GridLayout(3,3));
        button.setBackground(new Color(25,25,25));

        for (int i=0; i<9; i++){
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("Starcraft",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(textfield);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button);

        firstTurn();
    }
    int count=0;
    int check_tie=0;

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<9; i++){
            if (e.getSource()==buttons[i]) {
                if (player1_turn) {
                    count++;
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(150, 0, 150));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("Player2 Turn");
                        check();
                        if (count==5 && check_tie==0)
                            no_win(0, 1, 2, 3, 4, 5, 6, 7, 8);
                    }
                }
                else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(150, 150, 0));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("Player1 Turn");
                        check();
                    }
                }
            }
        }

    }
    public void firstTurn(){
        try{
            Thread.sleep(850);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        player1_turn=true;
        textfield.setText("Player1 Turn");
    }
    public void check(){
        if (
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X") ){
            player1(0,1,2);
        }
        else if (
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X") ){
            player1(3,4,5);
        }
        else if (
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X") ){
            player1(6,7,8);
        }
        else if (
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X") ){
            player1(0,3,6);
        }
        else if (
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X") ){
            player1(1,4,7);
        }
        else if (
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X") ){
            player1(2,5,8);
        }
        else if (
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X") ){
            player1(0,4,8);
        }
        else if (
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X") ){
            player1(2,4,6);
        }

        
        else if (
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O") ){
            player2(0,1,2);
        }
        else if (
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O") ){
            player2(3,4,5);
        }
        else if (
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O") ){
            player2(6,7,8);
        }
        else if (
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O") ){
            player2(0,3,6);
        }
        else if (
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O") ){
            player2(1,4,7);
        }
        else if (
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O") ){
            player2(2,5,8);
        }
        else if (
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O") ){
            player2(0,4,8);
        }
        else if (
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O") ){
            player2(2,4,6);
        }

    }
    public void player1(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0; i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player1 Wins!!");
        check_tie=1;
    }
    public void player2(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i=0; i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player2 Wins!!");
    }
    public void no_win(int a, int b, int c, int d, int e, int f, int g, int h, int i){
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);
        buttons[d].setBackground(Color.RED);
        buttons[e].setBackground(Color.RED);
        buttons[f].setBackground(Color.RED);
        buttons[g].setBackground(Color.RED);
        buttons[h].setBackground(Color.RED);
        buttons[i].setBackground(Color.RED);
        for (int j=0; j<9;j++){
            buttons[j].setEnabled(false);
        }
        textfield.setText("TIE!!");
    }
}

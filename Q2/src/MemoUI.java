import javax.swing.*;
import java.awt.*;

public class MemoUI extends JFrame {
    DatePanel datePanel;
    MemoPanel memoPanel;
    ButtonsPanel buttonsPanel;

    public MemoUI(){
        datePanel = new DatePanel();
        setLayout(new GridLayout(3,1));
        setSize(new Dimension(1000,600));
        add(datePanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        MemoUI memoUI = new MemoUI();
    }

}
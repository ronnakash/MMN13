import javax.swing.*;
import java.awt.*;

public class MemoPanel {
Memo currentMemo;



    public static class MemoTextArea extends JTextArea {
        public MemoTextArea() {
            super();
            setFont(new Font("Ariel", Font.BOLD, 30));
            setLineWrap(true);
            setWrapStyleWord(true);
            setForeground(new Color(10, 10, 10));
            setPreferredSize(new Dimension(400,100));
            setEditable(true);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatePanel extends JPanel {
    DateComboBox[] dateComboBoxes;
    Date currentDate;
    DateTextArea dateText;

    public DatePanel() {
        dateComboBoxes = new DateComboBox[] {new DateComboBox.DayComboBox(this), new DateComboBox.MonthComboBox(this), new DateComboBox.YearComboBox(this)};
        currentDate = new Date(dateComboBoxes[0].getCurrentlySelected(), dateComboBoxes[1].getCurrentlySelected(), dateComboBoxes[2].getCurrentlySelected());
        dateText = new DateTextArea(currentDate);
        setPreferredSize(new Dimension(1000,400));
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        layout.setHgap(25);
        layout.setVgap(50);
        for (DateComboBox box : dateComboBoxes)
            add(box);
        add(dateText);
        setVisible(true);
    }

    public void updateDate() {
        currentDate = new Date(dateComboBoxes[0].getCurrentlySelected(), dateComboBoxes[1].getCurrentlySelected(), dateComboBoxes[2].getCurrentlySelected());
        dateText.updateDate(currentDate);
        repaint();
    }


    public static class DateTextArea extends JTextArea{
        public DateTextArea(Date date) {
            super(date.toString());
            setFont(new Font("Ariel", Font.BOLD, 30));
            setLineWrap(true);
            setWrapStyleWord(true);
            setForeground(new Color(10, 10, 10));
            setPreferredSize(new Dimension(400,100));
            setEditable(false);
        }

        public void updateDate(Date date){
            setText(date.toString());
            repaint();
        }
    }


}

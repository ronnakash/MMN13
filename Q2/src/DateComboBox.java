import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class DateComboBox extends JComboBox implements ItemListener {
    private String[] options;
    DatePanel panel;

    public DateComboBox(String[] options, DatePanel datePanel) {
        super(options);
        panel = datePanel;
        this.options = options;
        setEditable(true);
        addItemListener(this);
        setPreferredSize(new Dimension(150,100));
        setFont(new Font("Ariel", Font.BOLD, 32));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        panel.updateDate();
    }

    public int getCurrentlySelected(){
        for(int i=0; i<options.length; i++){
            if (options[i].equals(getSelectedItem()))
                return this instanceof YearComboBox ? i+2000 : i+1;
        }
        return 0;
    }


    public static class DayComboBox extends DateComboBox{

        public DayComboBox(DatePanel datePanel) {
            super(new String[] {"1","2","3","4","5","6","7","8","9","10",
                    "11","12","13","14","15","16","17","18","19","20",
                    "21","22","23","24","25","26","27","28","29","30","31"}, datePanel);
        }
    }

    public static class MonthComboBox extends DateComboBox{

        public MonthComboBox(DatePanel datePanel) {
            super(new String[] {"January", "February", "March", "April", "May", "June", "July", "August",
                    "September", "October", "November", "December"}, datePanel);
        }
    }

    public static class YearComboBox extends DateComboBox{

        public YearComboBox(DatePanel datePanel) {
            super(new String[] {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
                    "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019",
                    "2002","2021","2022","2023","2024","2025","2026","2027","2028","2029"}, datePanel);
        }



    }


}

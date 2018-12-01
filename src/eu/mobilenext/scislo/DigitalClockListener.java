package eu.mobilenext.scislo;

import javax.swing.*;
import java.awt.*;

public class DigitalClockListener implements ClockListener {
    public JLabel time = new JLabel("Current Time");

    public DigitalClockListener(JPanel panel) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/sources/DS-DIGIT.TTF"));
            time.setFont(font.deriveFont(Font.PLAIN, 48f));
            panel.add(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSecondsChange(ClockEvent e) {
        time.setText(e.simpleTime.toString());
    }

    @Override
    public void onMinutesChange(ClockEvent e) {

    }

    @Override
    public void onHoursChange(ClockEvent e) {

    }
}

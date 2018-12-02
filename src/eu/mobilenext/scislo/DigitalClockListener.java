package eu.mobilenext.scislo;

import javax.swing.*;
import java.awt.*;

public class DigitalClockListener implements ClockListener {
    public JLabel time = new JLabel("00:00:00");
    private JPanel panel;

    public DigitalClockListener(JPanel panel) {
        this.panel = panel;
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/sources/DS-DIGIT.TTF"));
            time.setFont(font.deriveFont(Font.PLAIN, 48f));
            time.setAlignmentX(Component.CENTER_ALIGNMENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add() {
        panel.add(time);
    }

    public void remove() {
        this.panel.remove(time);
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

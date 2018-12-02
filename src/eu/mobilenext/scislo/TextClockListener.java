package eu.mobilenext.scislo;

import javax.swing.*;
import java.awt.*;

public class TextClockListener implements ClockListener {

    public JLabel time = new JLabel("00:00:00");

    public TextClockListener(JPanel panel) {
        time.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(time);

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

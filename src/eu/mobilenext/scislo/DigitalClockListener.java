package eu.mobilenext.scislo;

import javax.swing.*;

public class DigitalClockListener implements ClockListener {

    public JLabel time = new JLabel("Current Time");

    public DigitalClockListener (JFrame panel) {
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

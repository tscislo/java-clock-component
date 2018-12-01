package eu.mobilenext.scislo;

import javax.swing.*;

public class Clock {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clock();
            }
        });

    }

    public Clock() {

        ClockListener listener = new SimpleClockListener();

        ClockComponent clock = new ClockComponent();

        clock.addClockListener(listener);


    }
}

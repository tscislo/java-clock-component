package eu.mobilenext.scislo;

import javax.swing.*;
import java.awt.*;

public class Clock extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clock();
            }
        });

    }

    public Clock() {

        ClockListener simpleListener = new SimpleClockListener();
        ClockListener digitalListener = new DigitalClockListener(this);

        ClockComponent clockComponent = new ClockComponent();

        clockComponent.addClockListener(simpleListener);
        clockComponent.addClockListener(digitalListener);

        setLayout(new FlowLayout());
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

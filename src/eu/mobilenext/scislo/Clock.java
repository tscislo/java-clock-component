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

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ClockListener simpleListener = new SimpleClockListener();
        ClockListener textListener = new TextClockListener(panel);
        ClockListener digitalListener = new DigitalClockListener(panel);

        ClockComponent clockComponent = new ClockComponent();

        clockComponent.addClockListener(simpleListener);
        clockComponent.addClockListener(textListener);
        clockComponent.addClockListener(digitalListener);

        add(panel);
        setLayout(new FlowLayout());
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

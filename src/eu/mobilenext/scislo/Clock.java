package eu.mobilenext.scislo;

import javax.swing.*;
import java.awt.*;

public class Clock extends JFrame {

    private DigitalClockListener digitalListener;
    private AnalogClockListener analogListener;
    private ClockComponent clockComponent;
    JPanel panel = new JPanel();

    private String[] types = {"Digital", "Analog"};

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { new Clock();
            }
        });

    }

    public Clock() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(200, 200));

//        ClockListener simpleListener = new SimpleClockListener();
//        ClockListener textListener = new TextClockListener(panel);
        digitalListener = new DigitalClockListener(panel);
        analogListener = new AnalogClockListener(200, Color.lightGray, 200, panel);

        clockComponent = new ClockComponent();

//        clockComponent.addClockListener(analogListener);
//        clockComponent.addClockListener(simpleListener);
//        clockComponent.addClockListener(textListener);
//        clockComponent.addClockListener(digitalListener);

        useAnalog();
        setLocationByPlatform(true);
        add(panel);
        setLayout(new FlowLayout());
        createMenu();
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createMenu() {
        JMenu mTypes = new JMenu("Clock Types");
        JMenuBar menuBar = new JMenuBar();
        ButtonGroup group = new ButtonGroup();

        for(String type : types) {
            JRadioButtonMenuItem button = new JRadioButtonMenuItem(type);
            group.add(button);
            mTypes.add(button);
            button.setSelected(true);
            button.addActionListener((actionEvent) -> {
                String clickedButton = ((JRadioButtonMenuItem) actionEvent.getSource()).getText();
                panel.getGraphics().clearRect(0, 0, panel.getWidth(), panel.getHeight());
                if(clickedButton == "Analog") {
                    useAnalog();
                } else {
                    useDigital();
                }
                validate();
            });
        }
        menuBar.add(mTypes);
        setJMenuBar(menuBar);
    }

    private void useAnalog() {
        clockComponent.removeClockListener(digitalListener);
        digitalListener.remove();
        clockComponent.addClockListener(analogListener);
        analogListener.add();
    }

    private void useDigital() {
        clockComponent.removeClockListener(analogListener);
        analogListener.remove();
        clockComponent.addClockListener(digitalListener);
        digitalListener.add();
    }

}

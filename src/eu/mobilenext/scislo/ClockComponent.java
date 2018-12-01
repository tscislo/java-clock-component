package eu.mobilenext.scislo;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ClockComponent extends JPanel implements Runnable {


    public ClockComponent() {
        Thread t = new Thread(this);
        t.start();
    }

    public void addClockListener(ClockListener listener) {
        listenerList.add(ClockListener.class, listener);
    }

    public void removeClockListener(ClockListener listener) {
        listenerList.remove(ClockListener.class, listener);
    }

    private ClockEvent createClockEvent(ClockEvent.ClockEventType type) {
        Date currentDate = new Date();
        return new ClockEvent(this, type, new SimpleTime(currentDate.getHours(), currentDate.getMinutes(), currentDate.getSeconds()));
    }


    @Override
    public void run() {
        EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            ClockEvent ge1 = this.createClockEvent(ClockEvent.ClockEventType.SECOND);
            queue.postEvent(ge1);
        }

    }

    @Override
    public void processEvent(AWTEvent evt) {
        ClockListener[] listeners = listenerList.getListeners(ClockListener.class);
        if (evt instanceof ClockEvent) {
            for (int i = 0; i < listeners.length; i++) {
                ClockEvent ge = (ClockEvent) evt;
                switch (ge.getEventType()) {
                    case SECOND:
                        listeners[i].onSecondsChange(ge);
                        break;
                }
            }
        } else {
            super.processEvent(evt);
        }
    }

}

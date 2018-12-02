package eu.mobilenext.scislo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class ClockComponent extends JPanel implements Runnable {

    private SimpleTime pastSimpleTime;

    public static SimpleTime getCurrentSimpleTime() {
        Date currentDate = new Date();
        return new SimpleTime(currentDate.getHours(), currentDate.getMinutes(), currentDate.getSeconds());
    }

    private ClockEvent createClockEvent(ClockEvent.ClockEventType type) {
        return new ClockEvent(this, type, getCurrentSimpleTime());
    }

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


    @Override
    public void run() {
        EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        while (true) {
            pastSimpleTime = getCurrentSimpleTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            SimpleTime currentSimpleTime = getCurrentSimpleTime();
            ArrayList<ClockEvent> clockEvents = new ArrayList<ClockEvent>();
            if (currentSimpleTime.secondsGreater(pastSimpleTime)) {
                clockEvents.add(this.createClockEvent(ClockEvent.ClockEventType.SECOND));
            }
            if (currentSimpleTime.minutesGreater(pastSimpleTime)) {
                clockEvents.add(this.createClockEvent(ClockEvent.ClockEventType.SECOND));
                clockEvents.add(this.createClockEvent(ClockEvent.ClockEventType.MINUTE));
            }
            if (currentSimpleTime.hoursGreater(pastSimpleTime)) {
                clockEvents.add(this.createClockEvent(ClockEvent.ClockEventType.SECOND));
                clockEvents.add(this.createClockEvent(ClockEvent.ClockEventType.MINUTE));
                clockEvents.add(this.createClockEvent(ClockEvent.ClockEventType.HOUR));
            }

            for (ClockEvent clockEvent : clockEvents) {
                queue.postEvent(clockEvent);
            }
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
                    case MINUTE:
                        listeners[i].onMinutesChange(ge);
                        break;
                    case HOUR:
                        listeners[i].onHoursChange(ge);
                        break;
                }
            }
        } else {
            super.processEvent(evt);
        }
    }

}

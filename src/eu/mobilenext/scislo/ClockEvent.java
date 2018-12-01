package eu.mobilenext.scislo;

import java.awt.*;

public class ClockEvent extends AWTEvent {

    public SimpleTime simpleTime;

    public static final int CLOCK_EVENT = AWTEvent.RESERVED_ID_MAX + 123;

    public static enum ClockEventType {
        SECOND, MINUTE, HOUR
    }


    private ClockEventType type = ClockEventType.SECOND;

    public ClockEvent(Object source, ClockEventType et, SimpleTime time) {
        super(source, CLOCK_EVENT);
        this.simpleTime = time;
        type = et;
    }

    public ClockEventType getEventType() {
        return type;
    }
}

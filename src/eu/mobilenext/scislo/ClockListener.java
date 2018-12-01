package eu.mobilenext.scislo;

import java.util.EventListener;

public interface ClockListener extends EventListener {
    public abstract void onSecondsChange(ClockEvent e);

    public abstract void onMinutesChange(ClockEvent e);

    public abstract void onHoursChange(ClockEvent e);
}


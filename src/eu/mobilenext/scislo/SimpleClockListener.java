package eu.mobilenext.scislo;

public class SimpleClockListener implements ClockListener {


    @Override
    public void onSecondsChange(ClockEvent e) {
        System.out.println("seconds changed -> " + e.simpleTime);
    }

    @Override
    public void onMinutesChange(ClockEvent e) {
        System.out.println("minutes changed -> " + e.simpleTime);
    }

    @Override
    public void onHoursChange(ClockEvent e) {
        System.out.println("hours changed -> " + e.simpleTime);
    }
}

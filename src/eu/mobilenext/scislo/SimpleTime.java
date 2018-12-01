package eu.mobilenext.scislo;

public class SimpleTime {

    public int hours = 0;
    public int minutes = 0;
    public int seconds = 0;

    public SimpleTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }


    public String toString() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }

    public boolean hoursGreater(SimpleTime simpleTime) {
        return simpleTime.hours < this.hours;
    }

    public boolean minutesGreater(SimpleTime simpleTime) {
        return simpleTime.minutes < this.minutes;
    }

    public boolean secondsGreater(SimpleTime simpleTime) {
        return simpleTime.seconds < this.seconds;
    }

}

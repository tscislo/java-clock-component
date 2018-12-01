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
        return this.hours + ":" + this.minutes + ":" + this.seconds;
    }
}

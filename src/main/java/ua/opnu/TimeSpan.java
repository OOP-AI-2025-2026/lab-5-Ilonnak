package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        this.hours = 0;
        this.minutes = minutes;
        normalize();
    }

    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    public TimeSpan(TimeSpan other) {
        if (other == null) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = other.hours;
            this.minutes = other.minutes;
        }
        normalize();
    }

    public void add(int h, int m) {
        this.hours += h;
        this.minutes += m;
        normalize();
    }

    public void add(int minutes) {
        this.minutes += minutes;
        normalize();
    }

    public void add(TimeSpan timespan) {
        if (timespan == null) return;
        this.hours += timespan.hours;
        this.minutes += timespan.minutes;
        normalize();
    }

    public void subtract(int h, int m) {
        this.hours -= h;
        this.minutes -= m;
        normalize();
    }

    public void subtract(int minutes) {
        this.minutes -= minutes;
        normalize();
    }

    public void subtract(TimeSpan span) {
        if (span == null) return;
        this.hours -= span.hours;
        this.minutes -= span.minutes;
        normalize();
    }

    private void normalize() {
        int total = hours * 60 + minutes;
        if (total < 0) total = 0;
        hours = total / 60;
        minutes = total % 60;
    }

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }

    public double getTotalHours() { return hours + minutes / 60.0; }
    public int getTotalMinutes() { return hours * 60 + minutes; }

    public void scale(int factor) {
        if (factor <= 0) return;
        int total = getTotalMinutes() * factor;
        hours = total / 60;
        minutes = total % 60;
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", hours, minutes);
    }
}


public class Clock {
    private int s;
    public Clock(int h, int m, int s) {
        if (h > 23 || h < 0) {
            this.s += 0;
        } else {
            this.s += h * 3600;
        }
        if (m > 59 || m < 0) {
            this.s += 0;
        } else {
            this.s += m * 60;
        } 
        if (s > 59 || s < 0) {
            this.s += 0;
        } else {
            this.s += s;
        }        
    }
    
    public Clock(int h) {
        this(h, 0, 0);
    }
    
    public Clock(int h, int m) {
        this(h, m, 0);
    }
    
    public Clock() {
        this(0, 0, 0);
    }
    
    public int getHour() {
        if (this.s >= 86400) {
            this.s = 0;
        }
        return this.s / 3600;
    }
    
    public int getMinute() {
        if (this.s >= 86400) {
            this.s = 0;
        }
        return (this.s % 3600) / 60;
    }
    
    public int getSecond() {
        if (this.s >= 86400) {
            this.s = 0;
        }
        return this.s - (this.getHour() * 3600) - (this.getMinute() * 60);
    }
    
    public void setHour(int h) {
        if (h > 23 || h < 0) {
            return;
        } else {
            this.s -= this.getHour();
            this.s += h * 3600;
        }
    }
    
    public void setMinute(int m) {
        if (m > 59 || m < 0) {
            return;
        } else {
            this.s -= this.getMinute();
            this.s += m * 60;
        }
    }
    
    public void setSecond(int s) {
        if (s > 59 || s < 0) {
            return;
        } else {
            this.s -= this.getSecond();
            this.s += s;
        }   
    }
    
    public void set(int h) {
        this.set(h, 0, 0);
    }
    
    public void set(int h, int m) {
        this.set(h, m, 0);
    }
    
    public void set(int h, int m, int s) {
        if (((h >= 0 && h < 24)) && ((m < 60 && m >= 0)) && ((s < 60 && s >= 0))) {
            reset();
            this.setHour(h);
            this.setMinute(m);
            this.setSecond(s);
        }
    }
    
    public void reset() {
        this.s = 0;
    }
    
    @Override
    public String toString() {
        return "(" + getHour() + ":" + getMinute() + ":" + getSecond() + ")";
    }
    
    
    
    
}

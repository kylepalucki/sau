
public class Clock {
    private int h;
    private int m;
    private int s;
    
    public Clock(int h, int m, int s) {
        if (h > 23 || h < 0) {
            this.h = 0;
        } else {
            this.h = h;
        }
        if (m > 59 || m < 0) {
            this.m = 0;
        } else {
            this.m = m;
        } 
        if (s > 59 || s < 0) {
            this.s = 0;
        } else {
            this.s = s;
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
        return this.h;
    }
    
    public int getMinute() {
        return this.m;
    }
    
    public int getSecond() {
        return this.s;
    }
    
    public void setHour(int h) {
        if (h > 23 || h < 0) {
            return;
        } else {
            this.h = h;
        }
    }
    
    public void setMinute(int m) {
        if (m > 59 || m < 0) {
            return;
        } else {
            this.m = m;
        }
    }
    
    public void setSecond(int s) {
        if (s > 59 || s < 0) {
            return;
        } else {
            this.s = s;
        }   
    }
    
    public void set(int h) {
        this.setHour(h);
    }
    
    public void set(int h, int m) {
        this.setHour(h);
        this.setMinute(m);
    }
    
    public void set(int h, int m, int s) {
        this.setHour(h);
        this.setMinute(m);
        this.setSecond(s);
    }
    
    public void reset() {
        this.setHour(0);
        this.setMinute(0);
        this.setSecond(0);
    }
    
    @Override
    public String toString() {
        return "(" + getHour() + ":" + getMinute() + ":" + getSecond() + ")";
    }
    
    
    
    
}

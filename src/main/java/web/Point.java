package web;

import java.util.Date;

public class Point {
    private final float x;
    private final float y;
    private final float r;
    private final boolean result;
    private final Date requestTime ;
    private final long processTime;

    public Point(float x, float y, float r, boolean result, Date requestTime, long processTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.requestTime = requestTime;
        this.processTime = processTime;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public boolean getResult() {
        return result;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public long getProcessTime() {
        return processTime;
    }
}

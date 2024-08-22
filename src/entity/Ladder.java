package entity;

public class Ladder {

    private int start;
    private int  end;

    public Ladder(int start, int end) {
        if(end<start){
            throw new RuntimeException("end can't be less than start");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

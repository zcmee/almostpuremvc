package pl.adam.puremvc.dto;

/**
 * Created by SkyNET on 2017-11-13.
 */
public class RecordRange {
    private Integer from;
    private Integer to;

    public RecordRange() {
    }

    public RecordRange(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public RecordRange(String from, String to) {
        this.from = Integer.parseInt(from);
        this.to = Integer.parseInt(to);
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "RecordRange{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

}

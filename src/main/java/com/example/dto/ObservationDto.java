package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by vinit on 3/30/17.
 */
public class ObservationDto {


    @JsonProperty("realtime_start")
    Date realtimeStart;

    @JsonProperty("realtime_end")
    Date realtimeEnd;

    @JsonProperty("date")
    Date date;

    @JsonProperty("value")
    String value;

    public Date getRealtimeStart() {
        return realtimeStart;
    }

    public void setRealtimeStart(Date realtimeStart) {
        this.realtimeStart = realtimeStart;
    }

    public Date getRealtimeEnd() {
        return realtimeEnd;
    }

    public void setRealtimeEnd(Date realtimeEnd) {
        this.realtimeEnd = realtimeEnd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

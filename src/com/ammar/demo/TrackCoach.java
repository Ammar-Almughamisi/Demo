package com.ammar.demo;

public class TrackCoach implements Coach {
    public String getDailyWorkOut() {
        return ("this is the trackCoach");
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}

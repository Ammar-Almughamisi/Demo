package com.ammar.demo;

import org.springframework.stereotype.Component;

@Component("myCriecktCoach")
public class CricketCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkOut() {
        return "this is cricket coach" + " " + emailAddress + " " + team;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    private void desotryMethod() {
        System.out.println("closing the database");
    }
}

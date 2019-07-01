package com.ammar.demo;

public class BaseBallCoach implements Coach {
    private FortuneService fortuneService;

    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;

    }

    @Override
    public String getDailyWorkOut() {
        return ("return baseBallCoach  : ");

    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


}

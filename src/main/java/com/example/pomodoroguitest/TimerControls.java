package com.example.pomodoroguitest;

import java.util.Timer;
import java.util.TimerTask;

public class TimerControls {
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);
    boolean timerOn;
    int time;
    String timeTxt;

    public TimerControls(){
        Timer timer = new Timer();
        timerOn = false;

        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                if(timerOn == true){
                    if(time > 0){
                        time -= 1;
                        minutes = time / 60;
                        seconds = time % 60;
                        secondsString = String.format("%02d", seconds);
                        minutesString = String.format("%02d", minutes);
                        timeTxt = minutesString + ":" + secondsString;
                        HelloApplication.setTime(timeTxt);
                    }
                }

            }
        };

        //timer.schedule(task, 1000);  Just does it once
        timer.scheduleAtFixedRate(task, 0, 1000);  //Repeats every second

    }

    public void setTimerOn(boolean timeBool){
        timerOn = timeBool;
    }
    public boolean getTimerOn(){
        return timerOn;
    }
    public void startTimer(int seconds){
        time = seconds;
    }
    public String getTime(){
        return null;
    }



}

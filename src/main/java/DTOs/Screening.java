/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.sql.Time;

/**
 *
 * @author jimmy_2u626cl
 */
public class Screening {

    private int ScreenId;
    private int MovieId;
    private Time Starttime;
    
    public Screening(){
    
    }

    public Screening(int ScreenId, int MovieId, Time Starttime) {
        this.ScreenId = ScreenId;
        this.MovieId = MovieId;
        this.Starttime = Starttime;
    }

    public int getScreenId() {
        return ScreenId;
    }

    public void setScreenId(int ScreenId) {
        this.ScreenId = ScreenId;
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int MovieId) {
        this.MovieId = MovieId;
    }

    public Time getStarttime() {
        return Starttime;
    }

    public void setStarttime(Time Starttime) {
        this.Starttime = Starttime;
    }

    @Override
    public String toString() {
        return "Screening{" + "ScreenId=" + ScreenId + ", MovieId=" + MovieId + ", Starttime=" + Starttime + '}';
    }
    
}

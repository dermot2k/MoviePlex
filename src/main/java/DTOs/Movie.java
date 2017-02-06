/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author jimmy_2u626cl
 */
public class Movie {

   
    private String movieName;
    private String genre;
    private String length;
    private int IMDBnumber;
    private String posterURL;

    public Movie(){
    
    }
    
        public Movie(String movieName, String genre, String length, int IMDBnumber, String posterURL) {
        this.movieName = movieName;
        this.genre = genre;
        this.length = length;
        this.IMDBnumber = IMDBnumber;
        this.posterURL = posterURL;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getIMDBnumber() {
        return IMDBnumber;
    }

    public void setIMDBnumber(int IMDBnumber) {
        this.IMDBnumber = IMDBnumber;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    @Override
    public String toString() {
        return "Movies{" + "movieName=" + movieName + ", genre=" + genre + ", length=" + length + ", IMDBnumber=" + IMDBnumber + ", posterURL=" + posterURL + '}';
    }
    
    
}

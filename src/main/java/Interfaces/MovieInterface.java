/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DTOs.Movie;
import java.util.ArrayList;

/**
 *
 * @author jimmy_2u626cl
 */
public interface MovieInterface {
    
       public ArrayList<Movie> getAllMovies();
       
        public void addMovie(Movie aMovie);
        
        public int removeMovie(Movie movieID);
        
        public ArrayList<String> getFrameWork(String frameWork);
}

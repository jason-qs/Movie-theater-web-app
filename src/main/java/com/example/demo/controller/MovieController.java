package com.example.demo.controller;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Theater;
import com.example.demo.entity.User;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.TheaterRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MovieService;
import com.example.demo.service.TheaterService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService service;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterService theaterService;
    @Autowired
    private UserService Userservice;
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie){
        return service.saveMovie(movie);
    }

    @PostMapping("/addMovies")
    public List<Movie> addMovies(@RequestBody List<Movie> movies){
        return service.saveMovies(movies);
    }
    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return service.getMovies();
    }


    @GetMapping("/MovieById/{id}")
    public Movie findMovieById(@PathVariable int id){
        return service.getMovieById(id);
    }

    @PutMapping("/updateMovie")
    public Movie updateMovie(@RequestBody Movie movie){
        return service.updateMovie(movie);
    }
    @PutMapping("/movie/{movie_id}/users/{user_id}")
    Movie reserveUserToMovie(
            @PathVariable int movie_id,
            @PathVariable int user_id
    ) {
        Movie movie = movieRepository.findById(movie_id).get();
        User user = userRepository.findById(user_id).get();
        movie.reserveUser(user);
        return movieRepository.save(movie);
    }


    @PutMapping("/movie/{movie_id}/theaters/{theater_id}")
    Movie assignMovieToTheater(
            @PathVariable int movie_id,
            @PathVariable int theater_id
    ) {
        Movie movie = service.getMovieById(movie_id);
        Theater theater = theaterService.getTheaterById(theater_id);
        movie.assignTheater(theater);
        return movieRepository.save(movie);
    }


    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable int id){
        return service.deleteMovie(id);
    }

}

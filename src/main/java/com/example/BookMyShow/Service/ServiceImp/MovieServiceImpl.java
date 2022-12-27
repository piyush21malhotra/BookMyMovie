package com.example.BookMyShow.Service.ServiceImp;

import com.example.BookMyShow.Converter.MovieConverter;
import com.example.BookMyShow.DTO.EntryDto.MovieEntryDto;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {

        MovieEntity movieEntity = MovieConverter.convertEntryDtoToEntity(movieEntryDto);
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        if(movieRepository.existsByName(movieEntryDto.getName())) {
            movieResponseDto.setName("This movie already exist");
            return movieResponseDto;
        }
        movieRepository.save(movieEntity);

        return MovieConverter.convertEntityToResponseDto(movieEntity);
    }

    @Override
    public MovieResponseDto getMovieById(int id) {
        return MovieConverter.convertEntityToResponseDto(movieRepository.findById(id).get());
    }

    @Override
    public List<MovieResponseDto> getAllMovies() {
        return MovieConverter.convertEntityListToResponseDto(movieRepository.findAll());
    }


}

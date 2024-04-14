package com.example.JavaSkillsTest.controller;

import com.example.JavaSkillsTest.module.Photos;
import com.example.JavaSkillsTest.service.implementation.PhotosServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/photos")
public class PhotosController {

    private final PhotosServiceImplementation photosServiceImplementation;

    @GetMapping("/getAll")
    public List<Photos> getAllPhotos() {
        return photosServiceImplementation.getAllPhotos();
    }

    @GetMapping("/getphotosfilter/range")
    public List<Photos> getPhotosRangeFilter(){
        return photosServiceImplementation.getPhotosRangeFilter();
    }

    @GetMapping("/getphotosfilter/letterandrange")
    public List<Photos> getPhotosTitleLengthAndRange(){
        return photosServiceImplementation.getPhotosTitleLengthAndRange();
    }

    @GetMapping("/getfilter/fullbody")
    public List<Photos> getPhotosFullBodyFilters(){
        return photosServiceImplementation.getPhotosFullBodyFilters();
    }

    @GetMapping("/get/{id}")
    public Photos getByIdPhotos(@PathVariable Integer id){
        return photosServiceImplementation.getByIdPhotos(id);
    }

    @PostMapping("/create")
    public List<Photos> createPhotos(@RequestBody List<Photos> photos){
        return photosServiceImplementation.createPhotos(photos);
    }

    @PutMapping("/update")
    public Photos updatePhotos(@RequestBody Photos photos){
        return photosServiceImplementation.updatePhotos(photos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllPhotos(){
        photosServiceImplementation.deleteAllPhotos();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhotosById(@PathVariable Integer id){
        photosServiceImplementation.deletePhotosById(id);
    }





}

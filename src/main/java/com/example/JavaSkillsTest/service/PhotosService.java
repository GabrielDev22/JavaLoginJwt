package com.example.JavaSkillsTest.service;

import com.example.JavaSkillsTest.module.Photos;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PhotosService {

    List<Photos> getAllPhotos();

    List<Photos> getPhotosRangeFilter();
    List<Photos> getPhotosTitleLengthAndRange();
    List<Photos> getPhotosFullBodyFilters();
    Photos getByIdPhotos(Integer id);
    List<Photos> createPhotos(List<Photos> photos);
    Photos updatePhotos(Photos photos);
    void deletePhotosById(Integer id);
    void deleteAllPhotos();


}

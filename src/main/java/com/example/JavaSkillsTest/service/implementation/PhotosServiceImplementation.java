package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.Photos;
import com.example.JavaSkillsTest.repository.PhotosRepository;
import com.example.JavaSkillsTest.service.PhotosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class PhotosServiceImplementation implements PhotosService {

    private final PhotosRepository photosRepository;

    @Override
    public List<Photos> getAllPhotos() {
        List<Photos> getAllPhotos = null;
        try{
            getAllPhotos = photosRepository.findAll();
            if(getAllPhotos.isEmpty()){
                return null;
            }
            return getAllPhotos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return getAllPhotos;
    }

    @Override
    public List<Photos> getPhotosRangeFilter() {
        List<Photos> getPhotosRange = new ArrayList<>();
        try{
            List<Photos> postPhotosRange = photosRepository.findAll();
            for(Photos photos : postPhotosRange){
                if(photos.getId() >= 100 && photos.getId() <= 200){
                    getPhotosRange.add(photos);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getPhotosRange;
    }

    @Override
    public List<Photos> getPhotosTitleLengthAndRange() {
        List<Photos> getPhotosTitleLengthAndRange = null;
        try{
            getPhotosTitleLengthAndRange = photosRepository.findAll();

            getPhotosTitleLengthAndRange.stream()
                    .filter(photos -> photos.getId() >= 1000 && photos.getId() <= 1100 && photos.getTitle().length() < 30)
                    .collect(Collectors.toList());

            return getPhotosTitleLengthAndRange;

        }catch (Exception e){
            e.printStackTrace();
        }
        return getPhotosTitleLengthAndRange;
    }

    @Override
    public List<Photos> getPhotosFullBodyFilters() {
        List<Photos> getPhotosFullBody = new ArrayList<>();
        try{
            List<Photos> postPhotosFullBody = photosRepository.findAll();
            for (Photos photos : postPhotosFullBody){
                if(photos.getId() >= 4000 && photos.getId() <= 4100 && photos.getTitle().length() > 40){
                    getPhotosFullBody.add(photos);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getPhotosFullBody;
    }

    @Override
    public Photos getByIdPhotos(Integer id) {
        Photos getByIdPhotos = null;
        try{
            getByIdPhotos = photosRepository.getReferenceById(id);
            if(getByIdPhotos.getId() == null){
                return null;
            }
            return getByIdPhotos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return getByIdPhotos;
    }

    @Override
    public List<Photos> createPhotos(List<Photos> photos) {
        List<Photos> createPhotos = new ArrayList<>();
        try{
            for(Photos photo : photos){
                Photos multiCreatePhotos = photosRepository.save(photo);
                createPhotos.add(multiCreatePhotos);
            }
            return createPhotos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Photos updatePhotos(Photos photos) {
        Photos updatePhotos = null;
        try{
            updatePhotos = photosRepository.save(photos);
            if(!StringUtils.hasText(updatePhotos.getTitle())){
                return null;
            }
            return updatePhotos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updatePhotos;
    }

    @Override
    public void deletePhotosById(Integer id) {
        photosRepository.deleteById(id);
    }

    @Override
    public void deleteAllPhotos() {
        photosRepository.deleteAll();
    }
}

package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.Albums;
import com.example.JavaSkillsTest.repository.AlbumsRepository;
import com.example.JavaSkillsTest.service.AlbumsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Slf4j
@Service
public class AlbumsServiceImplementation implements AlbumsService {


    private final AlbumsRepository albumsRepository;

    @Override
    public List<Albums> getAllAlbums(int limit) {
        List<Albums> getAllAlbums = null;
        try{
            getAllAlbums =  albumsRepository.findAll();
            if(getAllAlbums.isEmpty()){
                return null;
            }
            return  getAllAlbums;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Albums> getAlbumsWithLetterQ() {
        List<Albums> getAlbumsLetterQ = new ArrayList<>();
        try{
            List<Albums> postAlbumsLetterQ = albumsRepository.findAll();
            for (Albums posts : postAlbumsLetterQ){
                if(posts.getTitle().toLowerCase().startsWith("q")){
                    getAlbumsLetterQ.add(posts);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return getAlbumsLetterQ;
    }

    @Override
    public List<Albums> getAlbumsMaxLength30() {
        List<Albums> getAlbumsMaxLength = new ArrayList<>();
        try{
            List<Albums> postAlbumsMaxLength = albumsRepository.findAll();
            for(Albums post : postAlbumsMaxLength){
                if(post.getTitle().length() > 40){
                    getAlbumsMaxLength.add(post);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getAlbumsMaxLength;
    }

    @Override
    public List<Albums> getAlbumsFilterBody() {
        List<Albums> getAlbumsFilterBody = new ArrayList<>();
        try{
            List<Albums> postAlbumsFilterBody = albumsRepository.findAll();
            for (Albums post : postAlbumsFilterBody){
                if(post.getTitle().length() > 40 && post.getTitle().toLowerCase().startsWith("i") || post.getTitle().toLowerCase().startsWith("q")){
                    getAlbumsFilterBody.add(post);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getAlbumsFilterBody;
    }

    @Override
    public Albums getAlbumsById(Integer id) {
        Albums getAlbumsById = null;
        try{
            getAlbumsById = albumsRepository.getReferenceById(id);
            if(getAlbumsById.getId() == null){
                return null;
            }
            return getAlbumsById;
        }catch (Exception e){
            e.printStackTrace();
        }
        return getAlbumsById;
    }

    @Override
    public List<Albums> createAlbums(List<Albums> albums) {
        List<Albums> multipleCreateAlbums = new ArrayList<>();
        try{
            for (Albums album : albums){
                Albums multipleCreateAlbum = albumsRepository.save(album);
                multipleCreateAlbums.add(multipleCreateAlbum);
            }
            return multipleCreateAlbums;

        }catch (Exception e){
            e.printStackTrace();
        }
        return multipleCreateAlbums;
    }

    @Override
    public Albums updateAlbums(Albums albums) {
        Albums updateAlbums = null;
        try{
            updateAlbums = albumsRepository.save(albums);
            if(!StringUtils.hasText(updateAlbums.getTitle())){
                return null;
            }
            return updateAlbums;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateAlbums;
    }

    @Override
    public void deleteAlbumsById(Integer id) {
        albumsRepository.deleteById(id);
    }

    @Override
    public void deleteAllAlbums() {
        albumsRepository.deleteAll();
    }
}

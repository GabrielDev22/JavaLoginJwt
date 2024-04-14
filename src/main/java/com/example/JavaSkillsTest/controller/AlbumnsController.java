package com.example.JavaSkillsTest.controller;


import com.example.JavaSkillsTest.module.Albums;
import com.example.JavaSkillsTest.service.implementation.AlbumsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albumns")
public class AlbumnsController {

    @Autowired
    AlbumsServiceImplementation albumsServiceImplementation;


    @GetMapping("/getAll")
    public List<Albums> getAllAlbums(@RequestParam(defaultValue = "100") int limit){
        return albumsServiceImplementation.getAllAlbums(limit);
    }

    @GetMapping("/getfilter/letterq")
    public List<Albums> getAlbumsWithLetterQ(){
        return albumsServiceImplementation.getAlbumsWithLetterQ();
    }

    @GetMapping("/getfilter/maxlenght30")
    public List<Albums> getAlbumsMaxLength30(){
        return albumsServiceImplementation.getAlbumsMaxLength30();
    }

    @GetMapping("/getfilter/body")
    public List<Albums> getAlbumsFilterBody() {
        return albumsServiceImplementation.getAlbumsFilterBody();
    }

    @GetMapping("/get/{id}")
    public Albums getAlbumsById(@PathVariable Integer id){
        return albumsServiceImplementation.getAlbumsById(id);
    }

    @PostMapping("/create")
    public List<Albums> createAlbums(@RequestBody List<Albums> albums){
        return albumsServiceImplementation.createAlbums(albums);
    }

    @PutMapping("/update")
    public Albums updateAlbums(@RequestBody Albums albums){
        return albumsServiceImplementation.updateAlbums(albums);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAlbumsById(@PathVariable Integer id){
         albumsServiceImplementation.deleteAlbumsById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllAlbums(){
        albumsServiceImplementation.deleteAllAlbums();
    }

}

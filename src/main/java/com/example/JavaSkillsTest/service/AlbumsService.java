package com.example.JavaSkillsTest.service;

import com.example.JavaSkillsTest.module.Albums;

import java.util.List;

public interface AlbumsService {

    List<Albums> getAllAlbums(int limit);
    List<Albums> getAlbumsWithLetterQ();
    List<Albums> getAlbumsMaxLength30();
    List<Albums> getAlbumsFilterBody();
    Albums getAlbumsById(Integer id);
    List<Albums> createAlbums(List<Albums> albums);
    Albums updateAlbums(Albums albums);
    void deleteAlbumsById(Integer id);
    void deleteAllAlbums();



}

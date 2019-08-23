package com.chilly.jpademo.service;

import com.chilly.jpademo.entity.Music;

import java.util.List;

public interface MusicService {

     List<Music> findAll();

     Music findMusicByMusicName(String musicName);

     void saveMusic(Music music);

     void editMusic(Music music);

     void deleteMusicById(int id);

}

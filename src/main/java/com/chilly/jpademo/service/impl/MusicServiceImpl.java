package com.chilly.jpademo.service.impl;

import com.chilly.jpademo.entity.Music;
import com.chilly.jpademo.repository.MusicRepository;
import com.chilly.jpademo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther ChillyLin
 * @date 2019/8/16
 */
@Service  //注解属于业务逻辑层，service或者manager层
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findMusicByMusicName(String musicName) {
        return musicRepository.findByMusicName(musicName);
    }

    @Override
    public void saveMusic(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void editMusic(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void deleteMusicById(int id) {
        musicRepository.deleteById(id);
    }
}

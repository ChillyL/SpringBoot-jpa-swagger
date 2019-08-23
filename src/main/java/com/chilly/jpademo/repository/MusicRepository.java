package com.chilly.jpademo.repository;

import com.chilly.jpademo.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther ChillyLin
 * @date 2019/8/15
 */
public interface MusicRepository extends JpaRepository<Music, Integer> {

    /*
    @Modifying 这个必须有，告诉框架我们执行的是更新/删除操作
    @Query 内部是正常的sql语句，但是需要注意的是表名，不是实际的表，而是我们前面定义的POJO
     */

    @Override
    List<Music> findAll();

    //@Query(value = "select * from music where music_name = ?1", nativeQuery = true)
    Music findByMusicName(String musicName);

    @Override
    void deleteById(Integer integer);

    @Override
    <S extends Music> S save(S s);

}

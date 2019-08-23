package com.chilly.jpademo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @auther ChillyLin
 * @date 2019/8/14
 */

/*
@Entity, @Table jpa注解，表示这个类与db的表关联，具体匹配的是表 music
@Id @GeneratedValue 作用与自增主键
@Column表明这个属性与表中的某列对应
@CreateDate根据当前时间来生成默认的时间戳
 */

/*
 ******  关于Swagger
@ApiModel 注解用于实体类，表示对类进行说明，用于参数用实体类接收。
@ApiModelProperty 注解用于类中属性，表示对 Model 属性的说明或者数据操作更改。
 */
@Entity
@Table(name = "music")
@ApiModel(value = "音乐实体类")
public class Music implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键，且由数据库自动生成
    @ApiModelProperty(value = "音乐唯一标识")
    private int id;

    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "音乐名")
    private String musicName;

    @Column(nullable = false)
    @ApiModelProperty(value = "音乐简介")
    private String musicIntro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicIntro() {
        return musicIntro;
    }

    public void setMusicIntro(String musicIntro) {
        this.musicIntro = musicIntro;
    }

    @Override
    public String toString() {
        return "{ id: "+id+
                "  musicName: "+musicName+
                "  musicIntro: "+musicIntro+" }";
    }
}

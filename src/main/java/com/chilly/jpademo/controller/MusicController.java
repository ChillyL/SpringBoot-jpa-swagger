package com.chilly.jpademo.controller;

import com.chilly.jpademo.entity.JsonResult;
import com.chilly.jpademo.entity.Music;
import com.chilly.jpademo.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther ChillyLin
 * @date 2019/8/18
 */

/*
    @RestController 注解包含了原来的 @Controller 和 @ResponseBody 注解。

    @Controller用于标记在一个类上，使用它标记的类就是一个SpringMvc Controller对象，
    分发处理器会扫描使用该注解的类的方法，并检测该方法是否使用了@RequestMapping注解。
    @ResponseBody 注解是将返回的数据结构转换为 JSON 格式

    但如果不是前后端分离，需要使用模板渲染的话，一般 Controller 中都会返回到具体的页面，此时就不能使用 @RestController 。
 */
@RestController
@RequestMapping("/Music")
/*
    @RequestMapping 是一个用来处理请求地址映射的注解
 */
//**********************************************************
/*   Swagger
    @Api 注解用于类上，表示标识这个类是 Swagger 的资源。
    @ApiOperation 注解用于方法，表示一个 HTTP 请求的操作。
    @ApiParam 注解用于参数上，用来标明参数信息。
 */
@Api(value = "Swagger2 在线接口文档")
public class MusicController {

    @Resource
    private MusicService musicService;

    @ApiOperation(value = "根据音乐名称获取音乐信息")
    @RequestMapping("/findMusicByName/{musicName}")
                                       /*
                                       @PathVariable 注解主要用来获取 URL 参数
                                       @RequestParam 也是获取请求参数的
                                       @RequestBody 注解用于接收前端传来的实体，接收参数也是对应的实体
                                    @PathValiable 是从 URL 模板中获取参数值， 即这种风格的 URL：http://localhost:8080/user/{id} ；
                                    而 @RequestParam 是从 Request 里获取参数值，即这种风格的 URL：http://localhost:8080/user?id=1
                                        */
    public JsonResult<Music> findMusic(@PathVariable("musicName")@ApiParam(value = "音乐名称")  String musicName){
        Music music = musicService.findMusicByMusicName(musicName);
        if (music != null){
            return new JsonResult<>(music);
        }else {
            return new JsonResult<>(null);
        }
    }

    @ApiOperation(value = "获取所有音乐信息")
    @RequestMapping("/findAll")
    public JsonResult<Music> findAll(){
        List<Music> musicList = musicService.findAll();
        return new JsonResult(musicList);
    }

    @ApiOperation(value = "通过音乐名称和简介添加音乐信息")
    @RequestMapping("/saveMusic/{musicName}/{musicIntro}")
    public JsonResult<Music> saveMusic(@PathVariable("musicName")@ApiParam(value = "音乐名称") String musicName,
                                       @PathVariable("musicIntro")@ApiParam(value = "音乐简介") String musicIntro){
        Music music = new Music();
        music.setMusicName(musicName);
        music.setMusicIntro(musicIntro);
        musicService.saveMusic(music);
        return new JsonResult<>("0","保存成功");
    }

    @ApiOperation(value = "通过音乐唯一标识（id）删除音乐信息")
    @RequestMapping("/deleteMusicById/{id}")
    public JsonResult<Music> deleteMusic(@PathVariable("id")@ApiParam(value = "音乐唯一标识（id") int id){
        musicService.deleteMusicById(id);
        return new JsonResult<>("0","删除成功");
    }

    @ApiOperation(value = "通过音乐名称和简介更改音乐信息")
    @RequestMapping("/editMusic/{musicName}/{musicIntro}")
    public JsonResult<Music> editMusic(@PathVariable("musicName")@ApiParam(value = "音乐名称") String musicName,
                                       @PathVariable("musicIntro")@ApiParam(value = "音乐简介") String musicIntro){
        Music music = musicService.findMusicByMusicName(musicName);
        if (music == null){
            return new JsonResult<>("404","无要修改的对象");
        }else {
            music.setMusicName(musicName);
            music.setMusicIntro(musicIntro);
            musicService.editMusic(music);
            return new JsonResult<>("0","数据更新成功");
        }
    }


}

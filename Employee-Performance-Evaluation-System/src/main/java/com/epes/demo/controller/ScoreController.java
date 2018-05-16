package com.epes.demo.controller;

import com.epes.demo.entity.PerformanceScore;
import com.epes.demo.service.PerformanceScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Description:
 * Date: 2018/5/6
 * Time: 19:55
 *
 * @Author lixingjie
 * @Modifice
 */
@Controller
@RequestMapping(value = "/score")
public class ScoreController {

    private final PerformanceScoreService scoreService;

    @Autowired
    public ScoreController(PerformanceScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping(value = "/addScore")
    @ResponseBody
    public Map<String,String> addScpre(PerformanceScore score){
        return scoreService.addScore(score);
    }

    @PostMapping(value = "/showScore")
    @ResponseBody
    public List<PerformanceScore> showScore(String userid){
        return scoreService.findScoreByEmpid(userid);
    }

}

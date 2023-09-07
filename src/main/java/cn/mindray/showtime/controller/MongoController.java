package cn.mindray.showtime.controller;

import cn.mindray.showtime.base.entity.Result;
import cn.mindray.showtime.entity.Mongo;
import cn.mindray.showtime.mapper.MongoAnnonRepo;
import cn.mindray.showtime.mapper.MongoRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description: 
 */
@Slf4j
@RestController
@RequestMapping("/mongo")
@Tag(name = "MongoController", description = "M78星云-芒果生产基地")
public class MongoController {

    @Autowired
    MongoRepo repo;

    @Autowired
    MongoAnnonRepo annonRepo;

    @PostMapping("/create")
    public Result create(@RequestBody Mongo mongo) {
        log.info("create mongo"+ mongo);
        repo.create(mongo);
        return Result.success(mongo);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Mongo mongo) {
        log.info("update mongo"+ mongo);
        repo.update(mongo);
        return Result.success(repo.find(mongo.getId()));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam long id) {
        return Result.success(repo.delete(id));
    }

    @GetMapping("/fuzzy")
    public Result fuzzy(@RequestParam(required = false) String searchKey) {
        return Result.success(repo.fuzzy(searchKey));
    }

    @GetMapping("/sameProductionPlace")
    @Operation(description = "寻找和传入id同产地的芒果")
    public Result sameProductionPlace(@RequestParam long id) {
        return Result.success(annonRepo.sameProductionPlace(id));
    }

}

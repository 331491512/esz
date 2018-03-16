package com.esuizhen.bigdata.controller;

import com.esuizhen.bigdata.common.ResponseErrorEnum;
import com.esuizhen.bigdata.common.ResponseResult;
import com.esuizhen.bigdata.common.RestResultGenerator;
import com.esuizhen.bigdata.common.annotation.MergeMethod;
import com.esuizhen.bigdata.common.annotation.MergeMethod.OperationEnum;
import com.esuizhen.bigdata.domain.Author;
import com.esuizhen.bigdata.repository.AuthorRepository;
import com.esuizhen.bigdata.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by fqc on 16/11/14.
 */
@RestController
@RequestMapping("/authors")
@Transactional( propagation = Propagation.REQUIRES_NEW )
public class AuthorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

    @RequestMapping("")
    public String index() {
        return "author controller";
    }

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/{name}")
    public List<Author> findAuthorByName(@PathVariable String name) {
        List<Author> authors = repository.findByLastName(name);
        return authors;
    }

    /**
     * 新增的时候，对于authorId基本也是通过原有数据获取的，不会自增，与随访业务相连
     * id则是系统id，自增，与业务无关
     *
     * @param name
     * @return
     */
    @MergeMethod(operationType = {OperationEnum.add,OperationEnum.merge})
    @RequestMapping(value = "/add/{name}")
    public ResponseResult add(@PathVariable String name) {
        ResponseResult responseResult = null;
        try {
            Author author = null;
            author = new Author();
            author.setCreated_time(new Date());
            author.setFirstName(name);
            //repository.save(author);
            authorService.addAuthor(author);
            LOGGER.info("增加ok，响应{}",200);
            responseResult = RestResultGenerator.genResult("增加ok");
        } catch (Exception e) {
            responseResult = RestResultGenerator.genErrorResult(e.getMessage());
        } finally {
            return responseResult;
        }
    }

    @RequestMapping(value = "update/{id}/{name}")
    @MergeMethod(operationType = {OperationEnum.update,OperationEnum.merge})
    public ResponseResult update(@PathVariable String name, @PathVariable String id, @RequestParam("authorId") String authorId) {
        Author author = null;
        String resMsg = "";
        author = repository.findOne(Long.parseLong(id));
        if (null==author) {
            return RestResultGenerator.genErrorResult(ResponseErrorEnum.ILLEGAL_PARAMS);
        }
        author.setAuthorId(Long.parseLong(authorId));
        author.setUpdated_time(new Date());
        author.setFirstName(name);
        author.setId(Integer.parseInt(id));
        repository.save(author);
        return RestResultGenerator.genResult("更新ok");
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable String id) {
        Author author = null;
        String resMsg = "";
        repository.delete(Long.parseLong(id));
        resMsg = "删除ok";
        return resMsg;
    }

   /* @RequestMapping(value = "versions/{id}")
    public Revisions versions(@PathVariable String id) {
        Author author = null;
        String resMsg = "";
        Revisions<Integer, Author> revisions = repository.findRevisions(Long.parseLong(id));
        return revisions;
    }

    @RequestMapping(value = "version/{id}/{versionNo}")
    public Revision findVerions(@PathVariable String id, @PathVariable String versionNo) {
        Author author = null;
        String resMsg = "";
        Revision<Integer, Author> revision = repository.findRevision(Long.parseLong(id), Integer.valueOf(versionNo));
        return revision;
    }*/

}

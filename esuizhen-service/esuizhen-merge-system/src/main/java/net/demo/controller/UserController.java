package net.demo.controller;

/**
 * Created by fqc on 11/29/16.
 */
/*@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("")
    public ResponseResult<List<User>> find() {
        List<User> users = userRepository.findAll();
        return RestResultGenerator.genResult(users, "200");
    }

    @GetMapping("save")
    public ResponseResult save() {
        User user = userRepository.save(new User("userName_" + RandomUtils.nextLong()));
        return RestResultGenerator.genResult(user, "200");
    }

}*/

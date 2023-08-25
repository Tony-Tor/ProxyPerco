package net.proselyte.jwtappdemo.controllers;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.jwtappdemo.dto.AdminUserDto;
import net.proselyte.jwtappdemo.dto.StudentData;
import net.proselyte.jwtappdemo.dto.StudentDataWithPhoto;
import net.proselyte.jwtappdemo.model.Task;
import net.proselyte.jwtappdemo.model.TaskType;
import net.proselyte.jwtappdemo.model.User;
import net.proselyte.jwtappdemo.service.PercoService;
import net.proselyte.jwtappdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for ROLE_ADMIN requests.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/admin/")
@Slf4j
public class AdminRestControllerV1 {

    private final UserService userService;
    private final PercoService percoService;

    @Autowired
    public AdminRestControllerV1(UserService userService, PercoService percoService) {
        this.userService = userService;
        this.percoService = percoService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "students/add")
    public ResponseEntity<AdminUserDto> add(@RequestBody StudentDataWithPhoto student) throws InterruptedException {

        Task task = new Task();

        task.type = TaskType.ADD;
        task.data = student;

        percoService.queue.put(task);

        log.info(student.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "students/delete")
    public ResponseEntity<AdminUserDto> delete(@RequestBody StudentData student) throws InterruptedException {
        Task task = new Task();

        task.type = TaskType.DELETE;
        task.data = student;

        percoService.queue.put(task);

        log.info(student.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "students/update")
    public ResponseEntity<AdminUserDto> update(@RequestBody StudentData student) throws InterruptedException {
        Task task = new Task();

        task.type = TaskType.UPDATE;
        task.data = student;

        percoService.queue.put(task);

        log.info(student.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

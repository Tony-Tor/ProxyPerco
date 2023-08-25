package net.proselyte.jwtappdemo.service;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.jwtappdemo.dto.StudentDataWithPhoto;
import net.proselyte.jwtappdemo.model.Task;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Service
@Slf4j
public class PercoService {

    public BlockingQueue<Task> queue = new ArrayBlockingQueue<>(10000);

    public PercoService() {
        Thread thread = new Thread(()->{
            while (true){
                Task take = null;
                try {
                    take = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(take != null){
                    switch (take.type){
                        case ADD: add(take); break;
                        case DELETE: delete(take); break;
                        case UPDATE: update(take); break;
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void add(Task task){
        if(task.data instanceof StudentDataWithPhoto){
            типаЗапросКСервису();
            log.info("Выполненно добавление");
        }
    }

    private void delete(Task task){
        типаЗапросКСервису();
        log.info("Выполненно удаление");
    }

    private void update(Task task){
        типаЗапросКСервису();
        log.info("Выполненно обновление");
    }

    private void типаЗапросКСервису(){
        while (true){}

    }
}

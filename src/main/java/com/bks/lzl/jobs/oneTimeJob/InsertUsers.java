package com.bks.lzl.jobs.oneTimeJob;

import com.bks.lzl.model.domain.User;
import com.bks.lzl.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@Component
public class InsertUsers {

    @Resource
    private UserService userService;

    private final ExecutorService executorService = new ThreadPoolExecutor(16,
                    200,
                    10,
                    TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(10000));

    public Long doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                User user = new User();
                user.setUsername("测试用户" + (j * 1000 + i));
                user.setUserAccount("testAccount");
                user.setAvatarUrl("https://th.bing.com/th/id/OIP.di5K59Gsb6Nlebqh5mIhOwAAAA?rs=1&pid=ImgDetMain");
                user.setGender(0);
                user.setUserPassword("123456789");
                user.setPhone("111");
                user.setEmail("111@111.com");
                user.setTags(generateTags());
                user.setUserStatus(0);
                user.setUserRole(0);
                userList.add(user);
            }
            //userService.saveBatch(userList);
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> userService.saveBatch(userList), executorService);
            futureList.add(completableFuture);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture<?>[0])).join();
        stopWatch.stop();
        Long totalTime = stopWatch.getTotalTimeMillis();
        return totalTime;
    }

    public Long commonInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int j = 0; j < 100; j++) {
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                User user = new User();
                user.setUsername("测试用户" + (j * 1000 + i));
                user.setUserAccount("testAccount");
                user.setAvatarUrl("https://th.bing.com/th/id/OIP.di5K59Gsb6Nlebqh5mIhOwAAAA?rs=1&pid=ImgDetMain");
                user.setGender(0);
                user.setUserPassword("123456789");
                user.setPhone("111");
                user.setEmail("111@111.com");
                user.setTags(generateTags());
                user.setUserStatus(0);
                user.setUserRole(0);
                userList.add(user);
            }
            userService.saveBatch(userList);
        }
        stopWatch.stop();
        Long totalTime = stopWatch.getTotalTimeMillis();
        System.out.println(totalTime);
        return totalTime;
    }

    private String generateTags(){
        Random random = new Random();
        int rounds = random.nextInt(20) + 1;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < rounds; i++) {
            sb.append(random.nextInt(20) + 1);
            if (i < rounds - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

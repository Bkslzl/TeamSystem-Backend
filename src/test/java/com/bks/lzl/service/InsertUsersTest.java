package com.bks.lzl.service;

import com.bks.lzl.model.domain.User;
import com.bks.lzl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@SpringBootTest
public class InsertUsersTest {
    @Resource
    private UserService userService;

    private ExecutorService executorService = new ThreadPoolExecutor(40, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                User user = new User();
                user.setUsername("测试用户" + (j * 1000 + i));
                user.setUserAccount("testAccount");
                user.setAvatarUrl("https://bkimg.cdn.bcebos.com/pic/023b5bb5c9ea15ce36d342a91e562df33a87e950144e?x-bce-process=image/format,f_auto/watermark,image_d2F0ZXIvYmFpa2UyNzI,g_7,xp_5,yp_5,P_20/resize,m_lfit,limit_1,h_1080");
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
        System.out.println(stopWatch.getTotalTimeMillis());
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

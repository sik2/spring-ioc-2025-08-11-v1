package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    public ApplicationContext() {

    }
    private Map<String,Object> beans = new HashMap<>();

    public <T> T genBean(String beanName) {
        if (beans.containsKey(beanName)) {
            // t3: IoC 컨테이너가 이미 만든 빈을 보관했다가 같은 객체를 다시 돌려준다.
            return (T) beans.get(beanName);
        }

        if(beanName.equals("testPostService")){
            TestPostRepository testPostRepository = new TestPostRepository();
            TestPostService testPostService = new TestPostService(testPostRepository);
            beans.put(beanName, testPostService);
            return (T) testPostService;
        }

        if(beanName.equals("testPostRepository")){
            // t4: 저장소도 컨테이너가 이름으로 찾아 만들 수 있는 빈으로 등록한다.
            TestPostRepository testPostRepository = new TestPostRepository();
            beans.put(beanName, testPostRepository);
            return (T) testPostRepository;
        }

        return (T) null;
    }
}

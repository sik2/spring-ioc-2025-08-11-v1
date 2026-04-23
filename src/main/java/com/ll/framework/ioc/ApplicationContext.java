package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    public ApplicationContext() {

    }
    private Map<String,Object> bens = new HashMap<>();

    public <T> T genBean(String beanName) {
       if(beanName.equals("testPostService")){
           TestPostRepository testPostRepository = new TestPostRepository();
           return (T) new TestPostService(testPostRepository);
       }
        return (T) null;
    }
}

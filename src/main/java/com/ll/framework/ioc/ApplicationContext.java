package com.ll.framework.ioc;


import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

        // Map 저장소 만들기
        private Map<String, Object> beans = new HashMap<>();

        // 생성자에 빈 등록하기
        public ApplicationContext() {
            TestPostRepository testPostRepository = new TestPostRepository();
            TestPostService testPostService = new TestPostService(testPostRepository);

            beans.put("testPostService", testPostService);
        }

    public <T> T genBean(String beanName) {
        return (T) beans.get(beanName);
    }
}

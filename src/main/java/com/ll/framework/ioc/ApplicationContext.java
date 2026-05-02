package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
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
            // t5: 서비스가 의존 객체를 직접 만들지 않고 컨테이너에서 받아 DI 되도록 한다.
            TestPostRepository testPostRepository = genBean("testPostRepository");
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

        if(beanName.equals("testFacadePostService")){
            // t6: 파사드 서비스도 필요한 빈들을 컨테이너에서 받아 조립한다.
            TestPostService testPostService = genBean("testPostService");
            TestPostRepository testPostRepository = genBean("testPostRepository");
            TestFacadePostService testFacadePostService = new TestFacadePostService(
                    testPostService,
                    testPostRepository
            );
            beans.put(beanName, testFacadePostService);
            return (T) testFacadePostService;
        }

        return (T) null;
    }
}

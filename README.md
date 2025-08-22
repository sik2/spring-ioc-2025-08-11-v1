## 코드 요약
- beans 맵: ApplicationContext 내부에 선언된 Map<String, Object> 형태의 변수입니다. 이 맵은 애플리케이션 전반에 걸쳐 공유될 **싱글톤 객체(빈)** 들을 저장하는 역할을 합니다.
- 생성자: ApplicationContext가 초기화될 때, 필요한 객체들을 직접 생성합니다. 이때 TestPostService와 TestFacadePostService는 생성자 주입 방식을 사용하여 testPostRepository 등 다른 객체를 주입받습니다. 이렇게 생성된 객체들은 모두 beans 맵에 저장되어 재사용됩니다.
- genBean 메서드: 외부에서 특정 빈의 이름을 키(key)로 전달하면, beans 맵에 저장된 객체를 반환하는 메서드입니다. 이 메서드는 빈을 가져오는 핵심 인터페이스 역할을 합니다.

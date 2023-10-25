
- Repository -> Service -> Controller 순서로 개발을 진행한다.
- Repository 계층의 테스트는 H2와 같은 인메모리 데이터베이스 기반의 통합 테스트로 진행한다.
- Service 계층의 테스트는 Mockito를 사용해 Repository 계층을 Mock하여 진행한다.
- Controller 계층의 테스트는 SpringTest의 MockMvc를 사용해 진행한다.


다른 예제나 강의들을 보면 Controller -> Service -> Repository 순서로 TDD 개발을 하는 경우도 많이 있다. 
하지만 Repository부터 계층을 작성해야 TDD의 flow가 매끄럽게 진행이 되는 것 같다. 
왜냐하면 Repository 계층은 다른 계층에 대한 의존성이 거의 없기 때문에 먼저 작성하기가 편리하기 때문이다. 
Service 계층은 Repository에 의존하기 때문에 Repository가 있어야 개발이 편리하며 흐름이 끊기지 않고, 
Controller 계층은 마찬가지로 Service 계층에 의존하기 때문이다.

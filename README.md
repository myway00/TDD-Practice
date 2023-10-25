## TDD(테스트 주도 개발) 프로그래밍 학습 레포지토리

- 요구사항이 주어진 과제를 테스트에 의해 주도되는 방법으로 실제 개발을 진행해보고자 합니다.
- [Tdd 실습 Blog](https://mangkyu.tistory.com/182)에서 주어진 과제를 분석하고, TDD 기반으로 개발해보며 TDD 를 학습하는 레포지토리입니다.

## TDD Study docs

> TDD를 학습하며 정리한 문서입니다.

- [JUnit을 활용한 Java 단위 테스트 코드 작성법.md](docs/JUnit을 활용한 Java 단위 테스트 코드 작성법.md)
- [TDD를 하는 이유.md](docs/TDD를 하는 이유.md)
- [TDD 접근 방법.md](docs/TDD 접근 방법.md)
- [Spring에서의 TDD 프로그래밍 방법.md](docs/Spring에서의 TDD 프로그래밍 방법.md)
- [0. JUnit과 Mockito 기반 Spring 단위 테스트 - Mockito.md](https://github.com/myway00/TDD-Practice/blob/master/docs/0.%20JUnit%EA%B3%BC%20Mockito%20%EA%B8%B0%EB%B0%98%20Spring%20%EB%8B%A8%EC%9C%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8%20%20-%20Mockito.md)
- [1. JUnit과 Mockito 기반 Spring 단위 테스트 - Controller.md](https://github.com/myway00/TDD-Practice/blob/master/docs/1.%20JUnit%EA%B3%BC%20Mockito%20%EA%B8%B0%EB%B0%98%20Spring%20%EB%8B%A8%EC%9C%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8%20%20-%20Controller.md)
- [2. JUnit과 Mockito 기반 Spring 단위 테스트 - Service.md](https://github.com/myway00/TDD-Practice/blob/master/docs/2.%20JUnit%EA%B3%BC%20Mockito%20%EA%B8%B0%EB%B0%98%20Spring%20%EB%8B%A8%EC%9C%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8%20%20-%20Service.md)
- [3. JUnit과 Mockito 기반 Spring 단위 테스트 - Repository.md](https://github.com/myway00/TDD-Practice/blob/master/docs/3.%20JUnit%EA%B3%BC%20Mockito%20%EA%B8%B0%EB%B0%98%20Spring%20%EB%8B%A8%EC%9C%84%20%ED%85%8C%EC%8A%A4%ED%8A%B8%20%20-%20Repository.md)

## TDD(Test-Driven Development, 테스트 주도 개발) 프로그래밍 방법 및 순서

### <TDD 개발 방법론의 프로그래밍 순서 >

1. 실패하는 작은 단위 테스트를 작성한다. 처음에는 컴파일조차 되지 않을 수 있다.
2. 빨리 테스트를 통과하기 위해 프로덕션 코드를 작성한다. 이를 위해 정답이 아닌 가짜 구현 등을 작성할 수도 있다.
3. 그 다음의 테스트 코드를 작성한다. 실패 테스트가 없을 경우에만 성공 테스트를 작성한다.
4. 새로운 테스트를 통과하기 위해 프로덕션 코드를 추가 또는 수정한다.
5. 1~4단계를 반복하여 실패/성공의 모든 테스트 케이스를 작성한다.
6. 개발된 코드들에 대해 모든 중복을 제거하며 리팩토링한다.

### 문제 설명

- 구현할 대상은 멤버십 적립 서비스입니다.
- 현재 지원중인 멤버십에는 네이버, 카카오, 라인 3가지 멤버십이 있으며, 사용자는 원하는 멤버십을 등록할 수 있습니다.
- 포인트 적립비율은 결제금액의 1%로 고정되며, 추후에 고정 금액(1000원)으로 확자적립될 수 있어야 합니다.
- 이번 연습문제에서는 위의 문제 설명과 아래의 요구사항을 만족하는 REST API를 자유롭게 정의하고, TDD 방식으로 구현하는 것입니다.

### 기능 요구 사항

- 멤버십 연결하기, 나의 멤버십 조회, 멤버십 연결끊기, 포인트 적립 API 를 구현합니다.
- 사용자 식별값은 문자열 형태이며 "X-USER-ID" 라는 HTTP Header 로 전달되며, 이 값은 포인트 적립할 때 바코드 대신 사용됩니다.
- Content-type 응답 형태는 application/json(JSON) 형식을 사용합니다.
- 각 기능 및 제약사항에 대한 개발을 TDD, 단위테스트를 기반으로 진행해야 합니다.

### 요구사항에 따른 상세 기술 구현 사항

- 나의 멤버십 등록 API
    - 기능: 나의 멤버십을 등록합니다.
    - 요청: 사용자 식별값, 멤버십 이름, 포인트
    - 응답: 멤버십 ID, 멤버십 이름
- 나의 멤버십 전체 조회 API
    - 기능: 내가 가진 모든 멤버십을 조회합니다.
    - 요청: 사용자 식별값
    - 응답: {멤버십 ID, 멤버십 이름, 포인트, 멤버십 상태(활성, 비활성), 가입 일시}의 멤버십 리스트
- 나의 멤버십 상세 조회 API
    - 기능: 나의 1개 멤버십을 상세 조회합니다.
    - 요청: 사용자 식별값, 멤버십 ID
    - 응답: 멤버십 ID, 멤버십 이름, 사용자 식별값, 포인트, 가입일시, 멤버십상태(활성, 비활성)
- 나의 멤버십 비활성화 API
    - 기능: 나의 멤버십을 비활성화 합니다.
    - 요청: 사용자 식별값, 멤버십 번호
    - 응답: X
- 나의 멤버십 삭제 API
    - 기능: 나의 멤버십을 삭제합니다.
    - 요청: 사용자 식별값, 멤버십 번호
    - 응답: X
- 멤버십 포인트 적립 API
    - 기능: 나의 멤버십 포인트를 결제 금액의 1%만큼 적립합니다.
    - 요청: 사용자 식별값, 멤버십 ID, 사용 금액을 입력값으로 받습니다.
    - 응답: X

### 기술 요구 사항

- 개발 언어: Java 11
- Framework: Spring Boot
- ORM: JPA
- DB: Mysql/H2

### Reference

[Tdd 실습 Blog](https://mangkyu.tistory.com/182)
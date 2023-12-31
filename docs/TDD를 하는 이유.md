### [ 테스트 코드를 먼저 작성해야 하는 이유 ]
테스트 코드를 먼저 작성하는 개발 방법론은 테스트 주도 개발(Test-Driven Development, TDD)로 많이 불린다. 우리는 프로덕션 코드 보다 테스트 코드를 먼저 작성해야 하는데, 그 이유는 다음과 같다.

- 깔끔한 코드를 작성할 수 있다.
- 장기적으로 개발 비용을 절감할 수 있다.
- 개발이 끝나면 테스트 코드를 작성하는 것은 매우 귀찮다. 실패 케이스면 더욱 그렇다.

________________
- TDD의 궁극적인 목표는 작동하는 깔끔한 코드를 작성하는 것이다.
  - TDD의 개발 단계에는 리팩토링이 있는데, 이 리팩토링 과정을 거치면서 중복된 코드들은 제거되고, 복잡한 코드들은 깔끔하게 정리하게 된다. 
    - 또한 테스트를 처음 작성할 때에는 귀찮고 개발을 느리게 한다는 느낌을 받을 수 있지만, 
    - 장기적으로 보면 반드시 개발 비용을 아껴줄 것이다.
    - 프로덕션 코드를 먼저 작성하였다면 이후에 테스트 코드를 작성하는 과정은 너무 귀찮다.
       - 왜냐하면 테스트 코드는 성공 케이스 뿐만 아니라 실패 케이스까지 작성해야 하기 때문에 작성해야 할 테스트의 개수는 해당 함수에서 발생가능한 모든 경우들인 N이며, 이미 개발이 완료되었기에 끝났다는 심리적 요인 때문에 테스트를 작성하는 것이 꺼려지기 때문이다. 
      - 그렇기 때문에 특별한 경우가 아니라면 테스트 코드를 먼저 작성하는 것이 좋다.
- 그리고 그 중 실패 테스트부터 작성해야 한다.
    - 즉, 순차적으로 실패하는 테스트를 먼저 작성하고, 오직 테스트가 실패할 경우에만 새로운 코드를 작성해야 한다.
    - 그리고 중복된 코드가 있으면 제거를 하는 것이다

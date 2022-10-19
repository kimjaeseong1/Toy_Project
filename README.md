# Toy_Project
### 자바 토이 프로젝트 스마트스토어 고객 분류

#### 프로젝트 주제
- 스마트스토어 운영진을 위한 고객 분류 프로그램 개발 `개별 프로젝트` 👤
- `유의사항`
    - 해당 프로젝트는 클래스 및 메소드 설계를 직접 해보는 것이 목적이므로 `List, Set, Map과 같은 API의 사용은 금합니다.`
    - [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html), [Set](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html), [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)의 내부를 분석해보고 이와 비슷하게 직접 함수를 작성해보세요.
- `고객 분류 결과`
    - General
    - VIP
    - VVIP
- `고객 분류기준`
    - 분류기준은 무조건 `총 이용시간과 결제금액`으로 정의하고 각 그룹이 되기 위한 최소 이용시간과 결제금액은 해당 프로그램을 사용하는 운영진에게 입력받는 형태입니다.

#### 프로젝트 정의서
- 스마트스토어를 운영 중인 Sally는 본인이 운영 중인 스마트스토어에서 한번이라도 구매 이력이 있는 고객들의 정보를 가지고 있다고 가정하자.
- Sally가 가진 고객정보는 다음과 같다.
    - 고객 일련번호
        - `자동 생성`
    - 고객 이름
        - `알파벳`
        - `3글자 이상`
    - 고객 아이디
        - `알파벳 / 숫자 / _ 가능`
        - `5글자 ~ 12글자`
        - `첫 글자로 숫자나 _가 올 순 없음`
    - 고객이 스마트스토어를 이용시간 → `분류기준`
        - `10, 20, 30시간 …`
    - 고객이 스마트스토어에서 구매한 총 결제금액 → `분류기준`
        - `100,000원, 200,000원 …`
- Sally는 스마트스토어 `총 이용시간과 결제금액`에 따라 고객을 세 그룹으로 분류하고 싶다고 가정하자.
    - General
    - VIP
    - VVIP

#### 프로젝트 요구사항 
- 객체지향 성격이 잘 들어날 수 있도록 클래스를 설계하자.
- 프로젝트 기능구현을 위한 필요한 메소드를 정의하고 구현해보자.
- 기능
    - 분류기준
        - 고객의 분류기준을 입력할 수 있다.
        - 고객의 분류기준을 설정할 수 있다.
        - 고객의 분류기준을 수정할 수 있다.
    - 고객정보
        - 고객의 정보를 입력할 수 있다.
        - 고객의 정보를 추가할 수 있다.
        - 고객의 정보를 삭제할 수 있다.
    - 고객 분류기능
        - 분류기준에 의해 고객을 분류할 수 있다.
        - 분류기준에 의해 분류된 고객의 정보를 출력할 수 있다.
        - 분류기준에 의해 분류된 고객의 정보를 이름순으로 정렬할 수 있다.
        - 분류기준에 의해 분류된 고객의 정보를 총 이용시간 순으로 정렬할 수 있다.
        - 분류기준에 의해 분류된 고객의 정보를 총 결제금액 순으로 정렬할 수 있다.
    - 예외처리
        - 고객 분류 기준이 추가될 경우 수정된 분류기준에 의해 고객을 다시 고려할 수 있다.
        - 고객 정보가 추가되거나 삭제될 경우의 시나리오도 생기는 예외도 고려할 수 있다.
        - 배열의 저장범위를 벗어나게 되면 생기는 오류를 해결할 수 있다.

실행 과정

![ezgif com-gif-maker](https://user-images.githubusercontent.com/105026909/196478834-2d8f9f06-e3db-4e17-869e-e9697cdb4638.gif)


![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/105026909/196666495-ac618b69-a5b3-423e-bf63-ca3ac003513c.gif)


![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/105026909/196667157-f1ce050d-30a2-4a83-872f-577249ab0a6e.gif)


![ezgif com-gif-maker (3)](https://user-images.githubusercontent.com/105026909/196667369-f24ec55e-b9b2-4bf1-bec3-2c7b3f200871.gif)


![ezgif com-gif-maker (4)](https://user-images.githubusercontent.com/105026909/196667686-216e8aa6-6485-4e68-90f2-ce5533e18bfe.gif)


![ezgif com-gif-maker (5)](https://user-images.githubusercontent.com/105026909/196667792-f9c9c087-26b6-46eb-b6c6-af5c64b569e5.gif)


![ezgif com-gif-maker (5)](https://user-images.githubusercontent.com/105026909/196667792-f9c9c087-26b6-46eb-b6c6-af5c64b569e5.gif)

![ezgif com-gif-maker (7)](https://user-images.githubusercontent.com/105026909/196668292-d7bd836d-8f50-4cc0-a3fe-11ab8089ce0d.gif)

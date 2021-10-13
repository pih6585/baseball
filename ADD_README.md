# 주사위 게임
## 진행 방법
* 주사위 게임
* 이전 미션과 동일

###기능 요구사항
* 입력인원을 입력받는다 최대 4명
* 참가자의 이름을 입력받는다.
* 참가자의 이름은 최대 5자리이고 영문만 가능하다.
* 참가자별 주사위 2개를 굴린다.
* 주사위의 합이 높은사람이 우승이다.
* 우승자는 여러명이 가능하다.

### 실행화면
#### 참여 인원은 몇명인가요?(최대4명)
#### 3
#### 참가자의 이름을 입력하세요 :
#### aaa
#### 참가자의 이름을 입력하세요 :
#### bbb
#### 참가자의 이름을 입력하세요 :
#### ccc
#### 실행결과
#### aaa : 5 - 5 : 10
#### bbb : 2 - 6 : 8
#### ccc : 4 - 6 : 10
#### 우승자는 aaa, bbb 입니다.

### TODO LIST
- [] 스캐너는 별도의 utils로 관리한다.
- [] 랜덤은 별도의 utils로 관리한다.  
- [] 게임 참가 인원을 객체로 관리한다.
- [] 참가인원 예외처리를 검증한다.
  - [] 빈값 또는 null 을 검증한다.
  - [] 참가인원은 2 ~ 4명이다.
  - [] 숫자만 입력 가능하다.
- [] 참가자의 이름을 객체로 관리한다.
- [] 참가자의 이름의 예외처리를 관리한다.
  - [] 빈값 또는 null을 검증한다.
  - [] 최대 5글자 이다.
  - [] 영문만 입력 가능하다.
- [] 주사위의 객체를 관리한다.
- [] 주사위는 2번 굴릴수 있다.
- [] 주사위의 게임 결과를 객체로 관리한다.
- [] 주사위의 합을 구할 수있다.
- [] 합의 따라 우승자를 구할 수 있다.
- [] 참가인원을 입력받는다.
- [] 게임참가자를 입력 받는다.  
- [] 실행결과를 출력한다.
- [] 우승자를 출력한다.
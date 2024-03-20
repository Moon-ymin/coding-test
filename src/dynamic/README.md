### 중복되는 연산을 줄이자
- 연산 속도와 메모리 공간을 최대한으로 활용할 수 있는 알고리즘을 작성해야 한다
- 다만, 메모리 공간을 약간만 더 사용하여 연산 속도를 `비약적으로` 증가시킬 수 있다
- 대표적인 방법이 `다이나믹 프로그래밍(동적 계획법)`

#### 🔍 다이나믹 프로그래밍 전제 조건
    1. 큰 문제를 작은 문제로 나눌 수 있다
    2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다

- 메모이제이션 기법 
  - 다이나믹 프로그래밍을 구현하는 방법 중 하나로, 한 번 구한 결과를 
    메모리 공간에 메모해두고 같은 식을 다시 호출하면 메모한 결과를 그대로
    가져오는 기법.
  - 값을 저장하는 방법이므로, 캐싱(Caching)이라고도 한다.
  - 코드 구현에서는 한 번 구한 정보를 리스트에 저장하면 된다

#### 🔍 다이나믹 프로그래밍
- 큰 문제를 작게 나누고, 같은 문제라면 한 번씩만 풀어 문제를 효율적으로 해결하는 알고리즘
- `큰 문제를 작게 나눈다`는 분할 정복과 비슷한데, 다이나믹은 문제들이 서로 영향을 미친다는 차이가 있음
- 탑 다운(Top-down, 메모이제이션) - 하향식
  - 큰 문제를 해결하기 위해 작은 문제를 호출하는 방식
- 보텀 업(Bottom-up) - 상향식
  - 작은 문제부터 차근차근 답을 도출하는 방식
  - 다이나믹 프로그래밍의 전형적인 형태는 보텀 업 방식
  - 결과 저장용 리스트는 `DP테이블`이라고 불린다

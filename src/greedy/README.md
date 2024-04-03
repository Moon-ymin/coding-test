# Greedy Algorithm
- 현재 상황에서 당장 좋은 것만 고르는 방법

## 선택을 위한 기준
매 순간 좋은 것을 선택하기 위해서는 다양한 기준(ex. 가장 큰 순서대로, 가장 작은 순서대로)이 있다

## 그리디 알고리즘의 정당성
- 가지고 있는 동전 중에서 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전을 종합해 다른 해가 나올 수 없다.

---
### 자바 표준 입출력
- https://limkydev.tistory.com/170
- Scanner의 next(), nextInt(), nextLine() 함수
### 빠른 입출력을 위한 BufferedReader, BufferedWriter, StringTokenizer, StringBuilder
- https://rlakuku-program.tistory.com/33
#### BufferedReader, BufferedWriter
1. BufferedReader, BufferedWriter : 버퍼를 이용하여 읽기와 쓰기를 하는 함수
   - 키보드의 입력이 있을 때마다 바로 이동시키는 것보다 중간에 버퍼를 두어 한 번에 묶어보내는 것이 더 효율적이고 빠르다.
     ex) 쓰레기 하나하나 밖에 버리는 것보다, 쓰레기 통에 모아두고 한 번에 밖에 버리기
2. Scanner
   - 입력값의 원하는 타입을 설정할 수 있다
   - BufferedReader는 String으로 입력 받는 데이터 타입이 고정되어 있다
   - 버퍼 사이즈가 1024char이기 때문에 많은 입력을 필요로 할 경우 성능이 좋지 못하다
3. BufferedReader 
   - Scanner와 다르게 개행문자만 경계로 인식하고 입력받은 데이터가 String으로 고정된다.
   - 버퍼 사이즈가 8192 char로 유리하다
   - BufferedReader는 동기화돼서 멀티 쓰레드 환경에서 안전하고, Scanner는 동기화되지 않기 때문에 멀티 쓰레드 환경에서 안전하지 않다
   - 사용법
     1. BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ); // 선언
     2. String s = br.readLine();
     3. int i = Integer.parseInt(br.readLine());
     4. throws IOException으로 예외처리 필수
   - 데이터 가공
     1. StringTokenizer, String.split() : 공백 단위로 데이터를 가공
        1. StringTokenizer의 nextToken() : readLine을 통해 입력받은 값을 공백 단위로 구분하여 호출 
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        StringTokenizer st = new StringTokenizer( br.readLine() );
        int N = Integer.parseInt(st.nextToken());
        2. String.split() : 배열에 공백단위로 끊어 데이터 저장 사용
        String[] arr = s.split(" ");
4. BufferedWriter
   - 양이 많을 때는 입력과 동일하게 버퍼를 사용하는 것이 좋다
   - 사용법
     1. BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out) );
        String str = "abcdef";
        bw.write(str); // 출력
        bw.newLine(); // 줄바꿈
        bw.flush(); // 남아있는 데이터 모두 출력
        bw.close(); //
#### StringBuilder
1. String과의 차이
   - String은 불변 속성 : concat이나 +연산으로 값을 변경하면, 기존의 String 메모리에서 값이 바뀌는 게 아니라,
     기존의 String에 들어있던 값을 버리고( Garbage, GC로 인해 사라짐 ) 새로운 값을 재할당
   - 문자열 연산이 자주 일어나는 경우, 힙 메모리에 많은 Garbage가 생성되고, 힙 메모리 부족으로 이어져 성능에 영향
2. StringBuffer / StringBuilder
   - StringBuffer : 동기화를 지원하며 멀티 쓰레드 환경에서 안전
   - StringBuilder : 동기화 지원하지 않아 멀티 쓰레드에서 적합하지 않음. 단일 쓰레드에서는 얘가 더 좋음
   => 문자열의 연산이 자주 일어나는 단일 쓰레드 환경에서는 StringBuilder사용이 유리
3. StringBuilder 사용법
    StringBuilder sb = new StringBuilder();
    sb.append("a");
    sb.append("b").append(" ");
4. 
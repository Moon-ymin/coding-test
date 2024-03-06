## int와 Integer의 차이
- https://smin1620.tistory.com/287
- int
1. Primitive 자료형, 변수의 타입
   1. 데이터를 가지는 자료형을 뜻하는 원시적인 자료형
   2. 메소드를 가지지 못한다
2. data의 type에 따라 값이 저장될 공간의 크기와 저장 형식을 정의한 것
- Integer


    ArrayList<Integer> intList = new ArrayList<Integer>();
    intList.add(1);
    intList.add(2);
    System.out.println(intList.get(0));

    String stringNum = "123";
    int intNum = Integer.parseInt(stringNum);
    System.out.println(intNum);
    
1. 사용할 때?
   - 매개변수로 객체를 필요로 할 때
   - 기본형 값이 아닌 객체로 저장해야할 때
   - 객체 간 비교가 필요할 때 
   ⇒ `래퍼 클래스(wrapper class)` : 객체가 기본 데이터 유형을 래핑하거나 포함하는 클래스
   - 객체를 만들 때 필드를 포함하고 이 필드에 기본 데이터 유형을 저장할 수 있다
   - Integer은 int의 래퍼 클래스 

- int와 Integer의 차이
1. int는 자료형
   - 산술연산 가능
   - null로 초기화 불가능
   - 저장공간이 4byte
2. Integer
   - Unboxing하지 않을 시 산술 연산이 불가능
   - null값으로 처리 가능
   - 저장공간이 큼
   - null값으로 처리가 가능해 SQL에 용이하게 쓰인다 
package sorting.part3;

import java.util.Scanner;
import java.util.TreeSet;

public class Ex1 {
    public static int n;
    static class Student implements Comparable<Student>{
        String name;
        int Korean;
        int English;
        int Math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            Korean = korean;
            English = english;
            Math = math;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student other) {
            int kcompare = Integer.compare(other.Korean, this.Korean);
            int ecompare = Integer.compare(this.English, other.English);
            int mcompare = Integer.compare(other.Math, this.Math);

            if (kcompare == 0){ // 1. 국어 내림차순
                if (ecompare ==0){ // 2. 영어 오름차순
                    if (mcompare ==0){ // 3. 수학 내림차순
                        return this.name.compareTo(other.name); // 4. 이름 오름차순
                    } return mcompare;
                } return ecompare;
            } return kcompare;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        TreeSet<Student> students = new TreeSet<>();

        // 학생 객체 입력받기
        for (int i = 0; i < n; i++) {
            String sname = sc.next();
            int k = sc.nextInt();
            int e = sc.nextInt();
            int m = sc.nextInt();
            students.add(new Student(sname, k, e, m));
        }

        for(Student s : students){
            System.out.println(s.getName());
        }
    }
}

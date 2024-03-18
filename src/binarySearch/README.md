## 1. 범위를 반씩 좁혀가는 탐색
---
### 🔍 순차 탐색
- 리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 확인하는 방법
- 시간 복잡도 : O(N)
### 🔍 이진 탐색
- 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법
- 이진 탐색은 시작점, 끝점, 중간점을 이용하여 탐색 범위를 설정
- 단계마다 탐색 범위를 2로 나누는 것과 동일하므로 연산 횟수는 logN에 비례
- 시간 복잡도 : O(logN)
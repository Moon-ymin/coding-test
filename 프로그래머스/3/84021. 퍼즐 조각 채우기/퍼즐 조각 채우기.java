import java.util.*;

class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;

        // 게임 보드의 빈 칸 추출
        List<List<int[]>> empty = extractShapes(game_board, 0);
        // 테이블의 퍼즐 조각 추출
        List<List<int[]>> puzzle = extractShapes(table, 1);

        // 퍼즐 조각 사용 여부
        boolean[] used = new boolean[puzzle.size()];
        int totalFilled = 0;

        // 빈 공간마다 적합한 퍼즐 조각 찾아 채우기
        for (List<int[]> e : empty) {
            for (int i = 0; i < puzzle.size(); i++) {
                if (used[i]) continue;
                List<int[]> p = puzzle.get(i);

                // 퍼즐 회전하면서 빈 공간에 맞는지 확인
                for (int r = 0; r < 4; r++) {
                    if (isMatch(e, p)) {
                        totalFilled += p.size();
                        used[i] = true;
                        break;
                    }
                    rotate(p);
                }

                if (used[i]) break;
            }
        }
        return totalFilled;
    }

    // BFS로 도형 추출
    private List<List<int[]>> extractShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != target || visited[i][j]) continue;

                List<int[]> shape = new ArrayList<>();
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;

                int minX = i, minY = j;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    shape.add(new int[]{x, y});
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || board[nx][ny] != target)
                            continue;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }

                // 좌표 기준점 이동
                for (int[] cell : shape) {
                    cell[0] -= minX;
                    cell[1] -= minY;
                }
                normalize(shape); // 기준점 이동 후 정렬
                shapes.add(shape);
            }
        }
        return shapes;
    }

    // 퍼즐 조각 회전
    private void rotate(List<int[]> puzzle) {
        for (int[] cell : puzzle) {
            int temp = cell[0];
            cell[0] = cell[1];
            cell[1] = -temp;
        }
        normalize(puzzle);
    }

    // 퍼즐 조각 좌표를 기준점으로 정렬
    private void normalize(List<int[]> puzzle) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] cell : puzzle) {
            minX = Math.min(minX, cell[0]);
            minY = Math.min(minY, cell[1]);
        }
        for (int[] cell : puzzle) {
            cell[0] -= minX;
            cell[1] -= minY;
        }
        puzzle.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    }

    // 퍼즐 조각과 빈 공간이 일치하는지 확인
    private boolean isMatch(List<int[]> empty, List<int[]> puzzle) {
        if (empty.size() != puzzle.size()) return false;

        for (int i = 0; i < empty.size(); i++) {
            if (empty.get(i)[0] != puzzle.get(i)[0] || empty.get(i)[1] != puzzle.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
}

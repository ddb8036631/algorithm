def solution(board):
    h, w = len(board), len(board[0])
    tmp = [[0 for _ in range(w + 1)]] + [[0] + board[i] for i in range(h)]
    answer = 0

    for x in range(1, h + 1):
        for y in range(1, w + 1):
            if tmp[x][y] == 0:
                continue
            tmp[x][y] = min(tmp[x - 1][y - 1], tmp[x - 1][y], tmp[x][y - 1]) + 1
            answer = max(answer, tmp[x][y])

    return answer ** 2


print(solution([[0, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [0, 0, 1, 0]]))
print(solution([[0, 0, 1, 1], [1, 1, 1, 1]]))

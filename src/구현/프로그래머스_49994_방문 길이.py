def solution(dirs):
    d = {"U": [-1, 0], "D": [1, 0], "L": [0, -1], "R": [0, 1]}
    size = 10
    visit = [
        [[[False for _ in range(size + 1)] for _ in range(size + 1)] for _ in range(size + 1)] for _ in range(size + 1)
    ]
    x, y = 5, 5
    answer = 0

    for command in dirs:
        nx, ny = x + d[command][0], y + d[command][1]
        if nx < 0 or nx > size or ny < 0 or ny > size:
            continue
        if not visit[x][y][nx][ny]:
            visit[x][y][nx][ny] = visit[nx][ny][x][y] = True
            answer += 1
        x, y = nx, ny

    return answer


print(solution("ULURRDLLU"))
print(solution("LULLLLLLU"))

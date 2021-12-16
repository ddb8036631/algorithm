map = []


def solution(rows, columns, queries):
    answer = []
    cnt = 1
    map = [[0] * columns for i in range(rows)]

    for i in range(rows):
        for j in range(columns):
            map[i][j] = cnt
            cnt += 1

    for q in queries:
        answer.append(rotate(map, [el - 1 for el in q], answer))

    return answer


def rotate(map, query):
    x1, y1, x2, y2 = query
    nx = x2 - 1
    ny = y2
    min_value = tmp = map[nx][ny]

    while nx != x1:
        map[nx][ny] = map[nx - 1][ny]
        min_value = min(min_value, map[nx - 1][ny])
        nx -= 1
    while ny != y1:
        map[nx][ny] = map[nx][ny - 1]
        min_value = min(min_value, map[nx][ny - 1])
        ny -= 1
    while nx != x2:
        map[nx][ny] = map[nx + 1][ny]
        min_value = min(min_value, map[nx + 1][ny])
        nx += 1
    while ny != y2:
        map[nx][ny] = map[nx][ny + 1]
        min_value = min(min_value, map[nx][ny + 1])
        ny += 1
    map[nx][ny] = tmp

    return min_value


print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]))
print(solution(3, 3, [[1, 1, 2, 2], [1, 2, 2, 3], [2, 1, 3, 2], [2, 2, 3, 3]]))
print(solution(100, 97, [[1, 1, 100, 97]]))

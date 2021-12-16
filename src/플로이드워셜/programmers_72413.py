def solution(n, s, a, b, fares):
    INF = int(1e9)
    answer = INF
    arr = [[INF] * n for _ in range(n)]

    for i in range(n):
        arr[i][i] = 0
    for u, v, c in fares:
        arr[u - 1][v - 1] = arr[v - 1][u - 1] = c

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if arr[i][j] > arr[i][k] + arr[k][j]:
                    arr[i][j] = arr[i][k] + arr[k][j]

    for mid in range(n):
        answer = min(answer, arr[s - 1][mid] + arr[mid][a - 1] + arr[mid][b - 1])

    return answer


print(
    solution(
        6,
        4,
        6,
        2,
        [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]],
    )
)
print(solution(7, 3, 4, 1, [[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]))
print(solution(6, 4, 5, 6, [[2, 6, 6], [6, 3, 7], [4, 6, 7], [6, 5, 11], [2, 5, 12], [5, 3, 20], [2, 4, 8], [4, 3, 9]]))

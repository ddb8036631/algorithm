import sys


def solution(n, wires):
    global cnt
    adj = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    answer = sys.maxsize

    def dfs(cur):
        global cnt

        cnt += 1

        for next in range(1, n + 1):
            if adj[cur][next] == 1 and not visit[next]:
                visit[next] = True
                dfs(next)

    for a, b in wires:
        adj[a][b] = adj[b][a] = 1

    for a, b in wires:
        adj[a][b] = adj[b][a] = 0
        visit = [False for _ in range(n + 1)]
        cnt = 0

        for i in range(1, n + 1):
            if not visit[i]:
                visit[i] = True
                dfs(i)
            answer = min(answer, abs(cnt - (n - cnt)))

        adj[a][b] = adj[b][a] = 1

    return answer


print(solution(9, [[1, 3], [2, 3], [3, 4], [4, 5], [4, 6], [4, 7], [7, 8], [7, 9]]))
print(solution(4, [[1, 2], [2, 3], [3, 4]]))
print(solution(7, [[1, 2], [2, 7], [3, 7], [3, 4], [4, 5], [6, 7]]))

import sys


def dfs(idx, start, graph, visit, answer):
    visit[idx] = True
    next = graph[idx]

    if not visit[next]:
        dfs(next, start, graph, visit, answer)
    if next == start:
        answer.append(start + 1)


def init(N, visit):
    for i in range(N):
        visit[i] = False


input = sys.stdin.readline
N = int(input())
graph = {}
visit = [False] * N
answer = []

for i in range(N):
    graph[i] = int(input()) - 1

for i in range(N):
    init(N, visit)
    dfs(i, i, graph, visit, answer)

print(len(answer), "\n".join(map(str, sorted(answer))), sep="\n")

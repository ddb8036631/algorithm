N, S = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0


def dfs(idx, sum):
    global answer

    if idx >= N:
        return

    tmp = sum + arr[idx]

    if tmp == S:
        answer += 1

    dfs(idx + 1, tmp)
    dfs(idx + 1, sum)


dfs(0, 0)
print(answer)

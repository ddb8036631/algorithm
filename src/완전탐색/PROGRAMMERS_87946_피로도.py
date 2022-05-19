def solution(k, dungeons):
    global n, visit, answer

    def dfs(k, cnt):
        global visit, answer
        answer = max(answer, cnt)

        if k <= 0:
            return

        for i in range(n):
            if visit[i] or k < dungeons[i][0]:
                continue
            visit[i] = True
            dfs(k - dungeons[i][1], cnt + 1)
            visit[i] = False

    n = len(dungeons)
    visit = [False for _ in range(n)]
    answer = 0

    dfs(k, 0)

    return answer


print(solution(80, [[80, 20], [50, 40], [30, 10]]))

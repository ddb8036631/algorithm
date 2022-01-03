N = int(input())
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
arr = [[0] * (N + 1) for _ in range(N + 1)]
dic = {}
answer = 0

for _ in range(N * N):
    num, *like = list(map(int, input().split()))
    dic[num] = like
    max_x, max_y, max_like, max_empty = 0, 0, -1, -1

    for x in range(1, N + 1):
        for y in range(1, N + 1):
            if arr[x][y]:
                continue
            likeCnt, emptyCnt = 0, 0
            for dx, dy in d:
                nx, ny = x + dx, y + dy
                if nx < 1 or nx > N or ny < 1 or ny > N:
                    continue
                if arr[nx][ny] in dic[num]:
                    likeCnt += 1
                if not arr[nx][ny]:
                    emptyCnt += 1

            if likeCnt > max_like or (likeCnt == max_like and emptyCnt > max_empty):
                max_x, max_y = x, y
                max_like = likeCnt
                max_empty = emptyCnt

    arr[max_x][max_y] = num

for x in range(1, N + 1):
    for y in range(1, N + 1):
        cnt = 0
        for dx, dy in d:
            nx, ny = x + dx, y + dy
            if nx < 1 or nx > N or ny < 1 or ny > N or arr[nx][ny] not in dic[arr[x][y]]:
                continue
            cnt += 1
        if cnt:
            answer += 10 ** (cnt - 1)

print(answer)

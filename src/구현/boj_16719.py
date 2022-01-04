import heapq

s = input()
used = [False] * len(s)

for step in range(len(s)):
    q = []

    for i in range(len(s)):
        if used[i]:
            continue

        used[i] = True
        tmp = list(map(lambda x: x[1], filter(lambda x: used[x[0]], enumerate(s))))
        heapq.heappush(q, (tmp, i))
        used[i] = False

    answer, idx = heapq.heappop(q)
    used[idx] = True
    print("".join(answer))

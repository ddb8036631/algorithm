def solution(n, k, cmd):
    table = {i: [i - 1, i + 1] for i in range(n)}
    table[0], table[n - 1] = [None, 1], [n - 2, None]
    cur = k
    deleted = []
    answer = ["O" for _ in range(n)]

    for c in cmd:
        if c == "C":
            answer[cur] = "X"
            prev, next = table[cur]
            deleted.append([prev, cur, next])

            if next == None:
                cur = table[cur][0]
            else:
                cur = table[cur][1]

            if prev == None:
                table[next][0] = None
            elif next == None:
                table[prev][1] = None
            else:
                table[prev][1] = next
                table[next][0] = prev
        elif c == "Z":
            prev, now, next = deleted.pop()
            answer[now] = "O"
            if prev == None:
                table[next][0] = now
            elif next == None:
                table[prev][1] = now
            else:
                table[prev][1] = now
                table[next][0] = now
        else:
            c1, c2 = c.split()
            c2 = int(c2)
            if c1 == "U":
                for _ in range(c2):
                    cur = table[cur][0]
            else:
                for _ in range(c2):
                    cur = table[cur][1]

    return "".join(answer)


print(solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]))
print(solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"]))

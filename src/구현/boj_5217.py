t = int(input())
for _ in range(t):
    n = int(input())
    answer = []
    for i in range(1, n):
        for j in range(i + 1, n):
            if i + j == n:
                answer.append(str(i) + " " + str(j))
    print("Pairs for " + str(n) + ": " + ", ".join(answer))

scores = [[i + 1, sum(map(int, input().split()))] for i in range(5)]
print(*sorted(scores, key=lambda x: x[1], reverse=True)[0])

int(input())
scores = [*map(int, input().split())]
print(max(scores) - min(scores))

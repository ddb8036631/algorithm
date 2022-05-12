A, B = map(int, input().split())
A, B = min(A, B), max(A, B)
print(len(range(A + 1, B)))
print(*list(range(A + 1, B)))

N, M = map(int, input().split())
A = sorted(list(map(int, input().split())))
B = set(map(int, input().split()))
answer = [a for a in A if a not in B]

print(len(answer))
print(*answer)

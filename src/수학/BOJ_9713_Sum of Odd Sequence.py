T = int(input())
for _ in range(T):
    N = int(input())
    print(sum(i for i in list(range(1, N + 1)) if i % 2 == 1))

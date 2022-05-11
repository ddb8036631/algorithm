N, M, P = map(int, input().split())
rank = [] if N == 0 else list(map(int, input().split()))

if N == 0:
    print(1)
else:
    if N == P and rank[-1] >= M:
        print(-1)
    else:
        answer = N + 1
        for i in range(N):
            if M >= rank[i]:
                answer = i + 1
                break
        print(answer)

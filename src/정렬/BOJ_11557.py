T = int(input())
for _ in range(T):
    N = int(input())
    arr = []

    for _ in range(N):
        univ, amount = input().split()
        arr.append((univ, int(amount)))

    arr.sort(key=lambda x:x[1], reverse=True)
    print(arr[0][0])

M, N = map(int, input().split())
convert = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
l = []

for num in range(M, N + 1):
    q, r = num // 10, num % 10
    if q == 0:
        l.append([convert[r], num])
    else:
        l.append([convert[q] + convert[r], num])

l.sort(key=lambda x: x[0])

for i in range(1, N - M + 2):
    print(l[i - 1][1], end=" ")
    if i % 10 == 0:
        print()

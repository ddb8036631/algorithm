M = int(input())
N = int(input())
sum = 0
min_value = int(1e4)

for num in range(M, N + 1):
    sqrt = int(num ** 0.5)
    if sqrt ** 2 == num:
        sum += num
        min_value = min(min_value, num)

if sum == 0:
    print(-1)
else:
    print(sum, min_value, sep="\n")

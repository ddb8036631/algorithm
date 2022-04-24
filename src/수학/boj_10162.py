T = int(input())
a = T // 300
T %= 300
b = T // 60
T %= 60
print(*[[-1], [a, b, T // 10]][T % 10 == 0])

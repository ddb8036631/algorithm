N, T = input().split()
x = list(map(int, input().split()))
v = list(map(int, input().split()))
min_value = int(1e9)
max_value = 0

for i in range(len(x)):
    min_value = min(min_value, round(x[i] + v[i] * float(T), 4))
    max_value = max(max_value, round(x[i] - v[i] * float(T), 4))

if max_value <= min_value:
    print(1)
else:
    print(0)

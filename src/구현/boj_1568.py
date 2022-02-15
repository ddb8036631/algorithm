n, k, time = int(input()), 0, 0

while 1:
    k += 1
    if not n:
        break
    if n < k:
        k = 1
    n -= k
    time += 1

print(time)

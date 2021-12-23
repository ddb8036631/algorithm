n = [*map(int, input())]
s = sum(map(int, n))
answer = 0

if 0 not in n or s % 3 != 0:
    print(-1)
else:
    n.sort(key=lambda x: -x)
    print("".join(map(str, n)))

n = int(input())
l = []

for _ in range(n):
    name, dd, mm, yyyy = map(lambda x: int(x) if x.isnumeric() else x, input().split())
    l.append([name, dd, mm, yyyy])

l.sort(key=lambda x: (x[3], x[2], x[1]))
print(l[-1][0], l[0][0], sep="\n")

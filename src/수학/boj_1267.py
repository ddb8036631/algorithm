n = int(input())
l = list(map(int, input().split(" ")))
y = 0
m = 0
for x in l:
    y += x // 30 * 10 + 10
    m += x // 60 * 15 + 15

if y < m:
    print("Y %d" % y)
elif y > m:
    print("M %d" % m)
else:
    print("Y M %d" % y)

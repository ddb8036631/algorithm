S = int(input())
border = [1]
cnt = 2

while 1:
    if S < border[-1] + cnt: break

    border.append(border[-1] + cnt)
    cnt += 1

print(len(border))


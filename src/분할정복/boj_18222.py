def go(idx):
    if idx == 0:
        return 0

    if idx % 2 == 0:
        return go(idx // 2)
    else:
        return 1 - go(idx // 2)


k = int(input())
print(go(k - 1))

while True:
    line = input().lower()
    if line == "#":
        break
    dic = {"a", "e", "i", "o", "u"}
    cnt = 0
    for ch in line:
        if ch in dic:
            cnt += 1
    print(cnt)

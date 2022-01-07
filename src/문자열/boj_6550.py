while True:
    try:
        s, t = input().split(" ")
        i = j = 0

        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1
                j += 1
            else:
                j += 1

        print("Yes" if i == len(s) else "No")
    except:
        break

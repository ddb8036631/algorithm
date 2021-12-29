s = set(["a", "e", "i", "o", "u"])

while True:
    word = input()
    first, second, third = 0, True, True
    if word == "end":
        break

    for i in range(len(word)):
        c = word[i]
        if c in s:
            first += 1

        m, j = 0, 0
        for cc in word[i : i + 3]:
            if cc in s:
                m += 1
            else:
                j += 1

        if m == 3 or j == 3:
            second = False

        if i + 1 < len(word):
            t = word[i : i + 2]
            if t != "ee" and t != "oo" and word[i] == word[i + 1]:
                third = False
    print("<%s> is %s." % (word, "acceptable" if first > 0 and second and third else "not acceptable"))

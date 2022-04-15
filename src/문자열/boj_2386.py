while True:
    s = input()
    if s == "#":
        break

    target, sentence = s[0], s[2:].lower()
    print(target, sentence.count(target))

l = sorted([(int(input()), i) for i in range(1, 9)], key=lambda t: t[0])[3:]
print(sum(map(lambda t: t[0], l)), " ".join(map(str, sorted(map(lambda t: t[1], l)))), sep="\n")

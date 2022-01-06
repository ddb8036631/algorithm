from collections import Counter

for _ in range(int(input())):
    c = Counter(input().replace(" ", "")).most_common(2)
    print("?" if len(c) > 1 and c[0][1] == c[1][1] else c[0][0])

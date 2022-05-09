cards = []
answer = 0


for _ in range(5):
    cards.append(input().split())


def solve():
    color = {"R": 0, "B": 1, "Y": 2, "G": 3}
    color_cnt = [0, 0, 0, 0]
    num_cnt = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    for c, n in cards:
        color_cnt[color[c]] += 1
        num_cnt[int(n)] += 1

    if 5 in color_cnt:
        for i in range(1, 6):
            if num_cnt[i : i + 5] == [1, 1, 1, 1, 1]:
                return i + 4 + 900

    if 4 in num_cnt:
        return num_cnt.index(4) + 800

    if 3 in num_cnt and 2 in num_cnt:
        return num_cnt.index(3) * 10 + num_cnt.index(2) + 700

    if 5 in color_cnt:
        for i in range(9, 0, -1):
            if num_cnt[i]:
                return i + 600

    for i in range(1, 6):
        if num_cnt[i : i + 5] == [1, 1, 1, 1, 1]:
            return i + 4 + 500

    if 3 in num_cnt:
        return num_cnt.index(3) + 400

    if 2 in num_cnt:
        small = num_cnt.index(2)
        if 2 in num_cnt[small + 1 :]:
            big = num_cnt[small + 1 :].index(2) + small + 1
            return big * 10 + small + 300

    if 2 in num_cnt:
        return num_cnt.index(2) + 200

    for i in range(9, 0, -1):
        if num_cnt[i]:
            return i + 100


print(solve())

import sys


def solution(line):
    N = len(line)
    # min_x, min_y, max_x, max_y = 100000, 100000, -100000, -100000
    min_x, min_y, max_x, max_y = sys.maxsize, sys.maxsize, -sys.maxsize, -sys.maxsize
    points = []

    for i in range(N):
        for j in range(i + 1, N):
            A, B, E = line[i]
            C, D, F = line[j]
            x_numerator, y_numerator = B * F - E * D, E * C - A * F
            denominator = A * D - B * C

            if denominator == 0 or x_numerator % denominator != 0 or y_numerator % denominator != 0:
                continue

            x, y = x_numerator // denominator, y_numerator // denominator
            min_x, max_x = min(min_x, x), max(max_x, x)
            min_y, max_y = min(min_y, y), max(max_y, y)
            points.append([x, y])

    board = [["." for _ in range(max_x - min_x + 1)] for _ in range(max_y - min_y + 1)]
    for x, y in points:
        board[max_y - y][x - min_x] = "*"

    return list(map(lambda x: "".join(x), board))


print(solution([[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]))
print(solution([[0, 1, -1], [1, 0, -1], [1, 0, 1]]))
print(solution([[1, -1, 0], [2, -1, 0]]))
print(solution([[1, -1, 0], [2, -1, 0], [4, -1, 0]]))

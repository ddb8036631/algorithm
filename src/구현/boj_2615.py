n = 19
board = [list(map(int, input().split())) for _ in range(n)]


def right(x, y, num):
    if y + 4 >= n:
        return False
    if board[x][y + 1] != num or board[x][y + 2] != num or board[x][y + 3] != num or board[x][y + 4] != num:
        return False
    if y - 1 >= 0 and board[x][y - 1] == num:
        return False
    if y + 5 < n and board[x][y + 5] == num:
        return False
    return True


def down(x, y, num):
    if x + 4 >= n:
        return False
    if board[x + 1][y] != num or board[x + 2][y] != num or board[x + 3][y] != num or board[x + 4][y] != num:
        return False
    if x - 1 >= 0 and board[x - 1][y] == num:
        return False
    if x + 5 < n and board[x + 5][y] == num:
        return False
    return True


def rightDown(x, y, num):
    if x + 4 >= n or y + 4 >= n:
        return False
    if (
        board[x + 1][y + 1] != num
        or board[x + 2][y + 2] != num
        or board[x + 3][y + 3] != num
        or board[x + 4][y + 4] != num
    ):
        return False
    if x - 1 >= 0 and y - 1 >= 0 and board[x - 1][y - 1] == num:
        return False
    if x + 5 < n and y + 5 < n and board[x + 5][y + 5] == num:
        return False
    return True


def rightup(x, y, num):
    if x - 4 < 0 or y + 4 >= n:
        return False
    if (
        board[x - 1][y + 1] != num
        or board[x - 2][y + 2] != num
        or board[x - 3][y + 3] != num
        or board[x - 4][y + 4] != num
    ):
        return False
    if x + 1 < n and y - 1 >= 0 and board[x + 1][y - 1] == num:
        return False
    if x - 5 >= 0 and y + 5 < n and board[x - 5][y + 5] == num:
        return False
    return True


for i in range(n):
    for j in range(n):
        num = board[i][j]

        if num == 0:
            continue

        if (
            right(i, j, board[i][j])
            or down(i, j, board[i][j])
            or rightDown(i, j, board[i][j])
            or rightup(i, j, board[i][j])
        ):
            print(num)
            print(i + 1, j + 1)
            exit()


print(0)

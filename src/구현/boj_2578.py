import sys

arr = [input().split() for _ in range(5)]
board = [[False] * 5 for _ in range(5)]
loc = {}
hor, ver, dia = set(), set(), set()
answer = 0


def isBingo():
    global hor, ver, dia, answer
    if len(hor) + len(ver) + len(dia) == 3:
        print(answer)
        sys.exit()


for i in range(5):
    for j in range(5):
        loc[arr[i][j]] = (i, j)

for _ in range(5):
    turn = input().split()
    for target in turn:
        answer += 1
        x, y = loc[target]
        board[x][y] = True
        for i in range(5):
            if i not in hor:
                if board[i] == [True] * 5:
                    hor.add(i)
                    isBingo()
        for j in range(5):
            if j not in ver:
                if list(map(list, zip(*board)))[j] == [True] * 5:
                    ver.add(j)
                    isBingo()
        if 0 not in dia:
            if board[0][0] and board[1][1] and board[2][2] and board[3][3] and board[4][4]:
                dia.add(0)
                isBingo()
        if 4 not in dia:
            if board[0][4] and board[1][3] and board[2][2] and board[3][1] and board[4][0]:
                dia.add(4)
                isBingo()

def go(x, y, z, dp, d):
    if x == 0 and y == 0 and z == 0:
        return 0

    ret = dp[x][y][z]
    if ret != -1:
        return ret
    ret = int(1e9)

    for i in range(6):
        ret = min(ret, go(max(0, x - d[i][0]), max(0, y - d[i][1]), max(0, z - d[i][2]), dp, d) + 1)

    dp[x][y][z] = ret

    return ret


N = int(input())
arr = list(map(int, input().split())) + [0, 0][:3]
d = [(1, 3, 9), (1, 9, 3), (3, 1, 9), (3, 9, 1), (9, 1, 3), (9, 3, 1)]
dp = [[[-1 for _ in range(61)] for _ in range(61)] for _ in range(61)]

print(go(arr[0], arr[1], arr[2], dp, d))

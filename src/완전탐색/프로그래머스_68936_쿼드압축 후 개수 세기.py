def solution(arr):
    def dfs(x, y, size):
        if size == 1:
            return [1, 0] if arr[x][y] == 0 else [0, 1]

        same = True

        for i in range(x, x + size):
            for j in range(y, y + size):
                if arr[i][j] != arr[x][y]:
                    same = False
                    break
            if not same:
                break

        if same:
            return [1, 0] if arr[x][y] == 0 else [0, 1]
        else:
            result = [0, 0]
            nextsize = size // 2
            d = [[0, 0], [0, nextsize], [nextsize, 0], [nextsize, nextsize]]
            for dx, dy in d:
                zero, one = dfs(x + dx, y + dy, nextsize)
                result[0] += zero
                result[1] += one

            return result

    return dfs(0, 0, len(arr))


print(solution([[1, 1, 0, 0], [1, 0, 0, 0], [1, 0, 0, 1], [1, 1, 1, 1]]))
print(
    solution(
        [
            [1, 1, 1, 1, 1, 1, 1, 1],
            [0, 1, 1, 1, 1, 1, 1, 1],
            [0, 0, 0, 0, 1, 1, 1, 1],
            [0, 1, 0, 0, 1, 1, 1, 1],
            [0, 0, 0, 0, 0, 0, 1, 1],
            [0, 0, 0, 0, 0, 0, 0, 1],
            [0, 0, 0, 0, 1, 0, 0, 1],
            [0, 0, 0, 0, 1, 1, 1, 1],
        ]
    )
)

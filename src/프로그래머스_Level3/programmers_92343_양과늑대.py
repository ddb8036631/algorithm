def solution(info, edges):
    def dfs(idx, sheep, wolf, path):
        if info[idx] == 0:
            sheep += 1
        else:
            wolf += 1

        if wolf >= sheep:
            return 0

        max_cnt = sheep

        for now in path:
            for fr, to in edges:
                if now == fr and to not in path:
                    path.append(to)
                    max_cnt = max(max_cnt, dfs(to, sheep, wolf, path))
                    path.pop()

        return max_cnt

    return dfs(0, 0, 0, [0])


print(
    solution(
        [0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1],
        [[0, 1], [1, 2], [1, 4], [0, 8], [8, 7], [9, 10], [9, 11], [4, 3], [6, 5], [4, 6], [8, 9]],
    )
)

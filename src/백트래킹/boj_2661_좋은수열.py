N = int(input())


def dfs(cur):
    if len(cur) == N:
        print(cur)
        exit()

    for num in range(1, 4):
        next = cur + str(num)
        length = len(next)
        worst = False

        for i in range(1, len(next) // 2 + 1):
            front, back = next[length - i - i : length - i], next[length - i :]
            if front == back:
                worst = True
                break

        if not worst:
            dfs(next)


dfs("")

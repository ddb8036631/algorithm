N = int(input())
memo = {}


def hanoi(N, start, to, via):
    if (N, start, to) in memo:
        return memo[(N, start, to)]

    if N == 1:
        s = f"{start} {to}"
    else:
        s = f"{hanoi(N-1, start, via, to)}\n{start} {to}\n{hanoi(N-1, via, to, start)}"
    memo[(N, start, to)] = s

    return s


print(2 ** N - 1)
print(hanoi(N, 1, 3, 2))

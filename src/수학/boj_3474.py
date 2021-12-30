import sys

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N = int(input())
    answer = 0
    i = 5
    while i <= N:
        answer += N // i
        i *= 5
    print(answer)

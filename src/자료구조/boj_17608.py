import sys

input = sys.stdin.readline
N = int(input())
stack = []
answer = 0

for _ in range(N):
    h = int(input())
    stack.append(h)

while stack:
    high = stack.pop()
    answer += 1

    while stack and stack[-1] <= high:
        stack.pop()

print(answer)

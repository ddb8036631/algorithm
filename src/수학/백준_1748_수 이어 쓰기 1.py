n = int(input())
i = 1
answer = 0

while i <= n:
    answer += n - i + 1
    i *= 10

print(answer)

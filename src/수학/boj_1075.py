N = input()
F = int(input())
answer = int(N[:-2] + "00")

while answer % F != 0:
    answer += 1

print(str(answer)[-2:])

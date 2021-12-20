def getClockNum(num):
    ret = num

    for _ in range(0, 3):
        num = num % 1000 * 10 + num // 1000
        ret = min(ret, num)

    return ret


input = int("".join(input().split()))
clockNum = getClockNum(input)
answer = 0

for num in range(1111, clockNum + 1):
    if num == getClockNum(num):
        answer += 1


print(answer)

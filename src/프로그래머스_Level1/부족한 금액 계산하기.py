def solution(price, money, count):
    cost = 0

    for i in range(1, count + 1):
        cost += price * i

    return cost - money if cost > money else 0


print(solution(3, 20, 4))

def solution(n):
    next = n + 1
    while True:
        if bin(n)[2:].count("1") == bin(next)[2:].count("1"):
            return next
        next += 1


print(solution(78))
print(solution(15))

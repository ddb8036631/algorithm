def solution(s):
    convert, zero = 0, 0

    while len(s) != 1:
        zero_cnt = s.count("0")
        s = "1" * (len(s) - zero_cnt)
        zero += zero_cnt
        convert += 1
        s = bin(len(s))[2:]

    return [convert, zero]


print(solution("110010101001"))
print(solution("01110"))
print(solution("1111111"))

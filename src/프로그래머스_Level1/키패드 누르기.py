def solution(numbers, hand):
    d = {1: (0, 0), 2: (0, 1), 3: (0, 2), 4: (1, 0), 5: (1, 1), 6: (1, 2), 7: (2, 0), 8: (2, 1), 9: (2, 2), 0: (3, 1)}
    l = (3, 0)
    r = (3, 2)
    answer = ""

    for number in numbers:
        if number == 1 or number == 4 or number == 7:
            answer += "L"
            l = d[number]
        elif number == 3 or number == 6 or number == 9:
            answer += "R"
            r = d[number]
        else:
            ld = abs(l[0] - d[number][0]) + abs(l[1] - d[number][1])
            rd = abs(r[0] - d[number][0]) + abs(r[1] - d[number][1])

            if ld < rd:
                answer += "L"
                l = d[number]
            elif ld > rd:
                answer += "R"
                r = d[number]
            else:
                if hand == "left":
                    answer += "L"
                    l = d[number]
                else:
                    answer += "R"
                    r = d[number]

    return answer


print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"))

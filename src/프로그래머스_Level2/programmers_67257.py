from itertools import permutations


def solution(expression):
    answer = 0
    opers = ["+", "-", "*"]
    priorities = [*map(list, permutations(opers))]

    for priority in priorities:
        first = expression.split(priority[0])
        tmp = []

        for item in first:
            second = item.split(priority[1])
            second = [str(eval(x)) for x in second]
            tmp.append(str(eval(priority[1].join(second))))

        res = abs(eval(priority[0].join(tmp)))
        answer = max(answer, res)

    return answer


print(solution("100-200*300-500+20"))
print(solution("50*6-3*2"))

def solution(answers):
    answer = []
    p1 = [1, 2, 3, 4, 5]
    p2 = [
        2,
        1,
        2,
        3,
        2,
        4,
        2,
        5,
    ]
    p3 = [
        3,
        3,
        1,
        1,
        2,
        2,
        4,
        4,
        5,
        5,
    ]
    c1 = 0
    c2 = 0
    c3 = 0

    for i in range(0, len(answers)):
        if p1[i % len(p1)] == answers[i]:
            c1 += 1
        if p2[i % len(p2)] == answers[i]:
            c2 += 1
        if p3[i % len(p3)] == answers[i]:
            c3 += 1

    max_cnt = c1
    max_cnt = max(max_cnt, c2)
    max_cnt = max(max_cnt, c3)

    print("max_cnt : ", max_cnt)
    print(c1, c2, c3)

    if max_cnt == c1:
        answers.append(1)
    if max_cnt == c2:
        answers.append(2)
    if max_cnt == c3:
        answer.append(3)

    return answers


print(solution([1, 2, 3, 4, 5]))
print(solution([1, 3, 2, 4, 2]))

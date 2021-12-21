def solution(gems):
    left, right, start, end = 0, 0, 1, len(gems)
    target = set(gems)
    dic = {gems[0]: 1}

    while left <= right and right < len(gems):
        if len(dic) == len(target):
            if right - left < end - start:
                start, end = left + 1, right + 1

            dic[gems[left]] -= 1
            if dic[gems[left]] == 0:
                del dic[gems[left]]
            left += 1

        else:
            right += 1
            if right == len(gems):
                break
            dic[gems[right]] = dic[gems[right]] + 1 if gems[right] in dic.keys() else 1

    return [start, end]


print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))
print(solution(["AA", "AB", "AC", "AA", "AC"]))
print(solution(["XYZ", "XYZ", "XYZ"]))
print(solution(["ZZZ", "YYY", "NNNN", "YYY", "BBB"]))

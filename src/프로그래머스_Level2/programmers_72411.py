from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    for c in course:
        temp = []
        for order in orders:
            comb = combinations(sorted(order), c)
            temp += comb
        counter = Counter(temp)
        
        if len(counter) == 0 or max(counter.values()) == 1: continue
        answer += ["".join(f) for f in counter if counter[f] == max(counter.values())]
        
    return sorted(answer)

print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))
print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2,3,5]))
print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))

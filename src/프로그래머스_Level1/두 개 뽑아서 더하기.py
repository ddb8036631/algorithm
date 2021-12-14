from itertools import combinations

def solution(numbers):
    answer = set()
    comb = list(combinations(numbers, 2))
    
    for arr in comb:
        answer.add(sum(arr))
    
    return sorted(list(answer))

print(solution([2,1,3,4,1]))
print(solution([5,0,2,7]))

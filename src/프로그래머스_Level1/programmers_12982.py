from itertools import combinations

def solution(d, budget):
    answer, sum = 0, 0
    d.sort()
    
    for price in d:
        sum += price

        if sum <= budget: answer += 1 
        else: break

    return answer

print(solution([1,3,2,5,4], 9))
print(solution([2,2,3,3], 10))

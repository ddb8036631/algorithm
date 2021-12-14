from itertools import combinations

def prime_list(n):
    sieve = [True] * n

    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if sieve[i] == True:
            for j in range(i+i, n, i):
                sieve[j] = False

    # return [i for i in range(2, n) if sieve[i] == True]
    return sieve

def solution(nums):
    prime = prime_list(3000)
    comb = list(combinations(nums, 3))
    answer = 0

    for arr in comb:
        # if sum(arr) in prime:
        if prime[sum(arr)]:
            answer += 1

    return answer

print(solution([1,2,3,4]))
print(solution([1,2,7,6,4]))

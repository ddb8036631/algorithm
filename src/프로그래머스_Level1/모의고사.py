def solution(answers):
    answer = []
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    cntOne = cntTwo = cntThree = 0

    for i in range(len(answers)):
        if answers[i] == one[i % len(one)]:
            cntOne += 1
        if answers[i] == two[i % len(two)]:
            cntTwo += 1
        if answers[i] == three[i % len(three)]:
            cntThree += 1

    counts = [cntOne, cntTwo, cntThree]
    
    for idx, cnt in enumerate(counts):
        if cnt == max(counts):
            answer.append(idx + 1)
    
    return answer


print(solution([1,2,3,4,5]))
print(solution([1,3,2,4,2]))


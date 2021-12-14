def solution(answers):
    answer = []
    personOne = [1,2,3,4,5]
    personTwo = [2,1,2,3,2,4,2,5]
    personThree = [3,3,1,1,2,2,4,4,5,5]
    countOne = countTwo = countThree = 0

    for i in range(len(answers)):
        if answers[i] == personOne[i % len(personOne)]:
            countOne += 1
        if answers[i] == personTwo[i % len(personTwo)]:
            countTwo += 1
        if answers[i] == personThree[i % len(personThree)]:
            countThree += 1

    counts = [countOne, countTwo, countThree]
    
    for idx, cnt in enumerate(counts):
        if cnt == max(counts):
            answer.append(idx + 1)
    
    return answer


print(solution([1,2,3,4,5]))
print(solution([1,3,2,4,2]))


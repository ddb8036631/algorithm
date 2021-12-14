answer = 0
for _ in range(int(input())):
    *_, a, b, c = sorted(input())
    answer = max(answer, int(['1'+b, c][a<b<c] + '000'[a<c:]))

print(answer)
    

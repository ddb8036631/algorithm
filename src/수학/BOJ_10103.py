cc = ss = 100
for _ in range(int(input())):
    C, S = map(int, input().split())
    if C == S: continue
    if C > S: ss -= C
    else: cc -= S

print(cc,ss,sep='\n')

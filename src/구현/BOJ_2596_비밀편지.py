n = int(input())
s = input()
l = ["000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"]
answer = ""

for i in range(0, n * 6, 6):
    now = s[i : i + 6]
    found = False

    for j in range(8):
        target = l[j]
        
        if now == target:
            answer += chr(j + ord("A"))
            found = True
            break

        diff_cnt = 0
        for k in range(6):
            if now[k] != target[k]:
                diff_cnt += 1

        if diff_cnt == 1:
            answer += chr(j + ord("A"))
            found = True
            break

    if not found:
        answer = i // 6 + 1
        break

print(answer)

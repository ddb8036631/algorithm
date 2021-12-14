A = input()
oper = input()
B = input()

if oper == "+":
    if A == B:
        answer = "2" + A[1:]
    else:
        answer = list(A) if len(A) > len(B) else list(B)
        answer[max(len(A), len(B)) - min(len(A), len(B))] = "1"
        answer = "".join(answer)
else:
    if A == B:
        answer = "1" + "0" * ((len(A) - 1) * 2)
    else:
        answer = "1" + "0" * (len(A) - 1) + "0" * (len(B) - 1)

print(answer)

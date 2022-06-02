N = int(input())
students = [input() for _ in range(N)]
l = len(students[0])

for i in range(1, l + 1):
    s = set()
    flag = True
    for student in students:
        tmp = student[l - i :]
        if tmp in s:
            flag = False
            break
        s.add(tmp)
    if flag:
        print(i)
        break

N, K = map(int, input().split())
arr = input().split()
selected = []
answer = 0

for i, v in enumerate(arr):
    if v in selected:
        pass
    elif len(selected) < N:
        selected.append(v)
    else:
        last = -1
        for ii, vv in enumerate(selected):
            found = False
            for j in range(i + 1, K):
                if arr[j] == vv:
                    found = True
                    last = max(last, j)
                    break
            if not found:
                selected[ii] = v
                answer += 1
                break
        if found and last > -1:
            target = selected.index(arr[last])
            selected[target] = v
            answer += 1
print(answer)

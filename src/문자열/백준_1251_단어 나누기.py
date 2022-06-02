word = input()
n = len(word)
l = []

for i in range(1, n - 1):
    for j in range(i + 1, n):
        left, mid, right = word[:i], word[i:j], word[j:]
        l.append(left[::-1] + mid[::-1] + right[::-1])

l.sort()
print(l[0])

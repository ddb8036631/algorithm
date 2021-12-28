s = input()
cnt = [0] * 26
odd = 0
left, mid = "", ""

for c in s:
    cnt[ord(c) - 65] += 1

for i in range(26):
    c = cnt[i]

    if c % 2 == 1:
        odd += 1
        mid = chr(i + 65)

    left += chr(i + 65) * (c // 2)

print("I'm Sorry Hansoo" if odd > 1 else left + mid + left[::-1])

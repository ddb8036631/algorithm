s = input()
start = "A"
answer = 0
for ch in s:
    if ch == start:
        continue
    if ch > start:
        answer += min(ord(ch) - ord(start), ord(start) - ord(ch) + 26)
    else:
        answer += min(ord(start) - ord(ch), ord(ch) - ord(start) + 26)
    start = ch
print(answer)

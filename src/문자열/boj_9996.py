import re

N = int(input())
pattern = "^" + input().replace("*", ".*") + "$"

for _ in range(N):
    print("DA" if re.compile(pattern).match(input()) else "NE")

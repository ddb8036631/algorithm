n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    print("MMM BRAINS" if x >= y else "NO BRAINS")

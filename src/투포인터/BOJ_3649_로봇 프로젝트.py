import sys

input = sys.stdin.readline

while True:
    try:
        x = int(input()) * 10 ** 7
        n = int(input())
        lego = sorted([int(input()) for _ in range(n)])
        left, right = 0, n - 1
        found = False

        while left < right:
            sum = lego[left] + lego[right]
            if sum == x:
                print("yes " + str(lego[left]) + " " + str(lego[right]))
                found = True
                break

            if sum < x:
                left += 1
            else:
                right -= 1
        if not found:
            print("danger")
    except:
        break

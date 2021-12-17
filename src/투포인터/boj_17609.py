T = int(input())
s = ""


def isPalindrome(left, right, isRemain):
    while left < right:
        if s[left] != s[right]:
            if isRemain == True:
                if isPalindrome(left, right - 1, False) == 0 or isPalindrome(left + 1, right, False) == 0:
                    return 1
            return 2
        left += 1
        right -= 1
    return 0


for _ in range(T):
    s = input()
    print(isPalindrome(0, len(s) - 1, True))

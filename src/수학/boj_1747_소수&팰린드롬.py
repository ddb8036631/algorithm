N = int(input())
MAX = 1003002
prime = [True for _ in range(MAX)]
prime[0] = prime[1] = False
num = N

for i in range(2, MAX):
    if prime[i]:
        for j in range(i + i, MAX, i):
            prime[j] = False


def isPalindrome(num):
    if str(num)[::-1] == str(num):
        return True
    return False


while True:
    if prime[num] and isPalindrome(num):
        print(num)
        exit()
    num += 1
